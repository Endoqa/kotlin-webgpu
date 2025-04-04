import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import org.lwjgl.glfw.GLFW.*
import org.lwjgl.glfw.GLFWNativeWayland.glfwGetWaylandDisplay
import org.lwjgl.glfw.GLFWNativeWayland.glfwGetWaylandWindow
import wgpu.*
import wgpu.limits.GPULimitPreset
import java.io.File
import java.lang.foreign.Arena
import java.lang.foreign.MemorySegment


private val vsShader = """
    struct Constants {
            scale : f32,
            time : f32,
            offsetX : f32,
            offsetY : f32,
            scalar : f32,
            scalarOffset : f32,
        };
        @group(0) @binding(0) var<uniform> c : Constants;

        struct VertexOut {
            @location(0) v_color : vec4f,
            @builtin(position) Position : vec4f,
        };

        @vertex fn main(@builtin(vertex_index) VertexIndex : u32) -> VertexOut {
            var positions : array<vec4f, 3> = array(
                vec4f( 0.0,  0.1, 0.0, 1.0),
                vec4f(-0.1, -0.1, 0.0, 1.0),
                vec4f( 0.1, -0.1, 0.0, 1.0)
            );

            var colors : array<vec4f, 3> = array(
                vec4f(1.0, 0.0, 0.0, 1.0),
                vec4f(0.0, 1.0, 0.0, 1.0),
                vec4f(0.0, 0.0, 1.0, 1.0)
            );

            var position : vec4f = positions[VertexIndex];
            var color : vec4f = colors[VertexIndex];

            // TODO(dawn:572): Revisit once modf has been reworked in WGSL.
            var fade : f32 = c.scalarOffset + c.time * c.scalar / 10.0;
            fade = fade - floor(fade);
            if (fade < 0.5) {
                fade = fade * 2.0;
            } else {
                fade = (1.0 - fade) * 2.0;
            }

            var xpos : f32 = position.x * c.scale;
            var ypos : f32 = position.y * c.scale;
            let angle : f32 = 3.14159 * 2.0 * fade;
            let xrot : f32 = xpos * cos(angle) - ypos * sin(angle);
            let yrot : f32 = xpos * sin(angle) + ypos * cos(angle);
            xpos = xrot + c.offsetX;
            ypos = yrot + c.offsetY;

            var output : VertexOut;
            output.v_color = vec4f(fade, 1.0 - fade, 0.0, 1.0) + color;
            output.Position = vec4f(xpos, ypos, 0.0, 1.0);
            return output;
        }
""".trimIndent()

private val fsShader = """
      @fragment fn main(@location(0) v_color : vec4f) -> @location(0) vec4f {
            return v_color;
        }
""".trimIndent()


private const val numTriangles = 10000

fun main() {
    System.load(File("../libs/libwgpu_native.so").absolutePath)
    runBlocking(newSingleThreadContext("App")) {
        appMain(emptyArray())
    }
}

private suspend fun appMain(args: Array<String>) {
    val gpu = GPU()

    val adapter = gpu.requestAdapter(GPURequestAdapterOptions(powerPreference = GPUPowerPreference.HighPerformance))
    require(adapter != null) { "Failed to find a suitable GPU" }
    println(adapter.features)
    println(adapter.info)
    println(adapter.limits)

    if (!glfwInit()) {
        error("Failed to initialize GLFW")
    }
    glfwInitHint(GLFW_PLATFORM, GLFW_PLATFORM_WAYLAND)
    glfwWindowHint(GLFW_CLIENT_API, GLFW_NO_API)
    val window = glfwCreateWindow(800, 600, "Animometer", 0, 0)

    val surface = gpu.createSurface(glfwGetWaylandDisplay(), glfwGetWaylandWindow(window))

    val capabilities = surface.getCapabilities(adapter)

    val preferredFormat = capabilities.formats.first()



    println("Preferred format: $preferredFormat")

    val device = adapter.requestDevice(GPUDeviceDescriptor(requiredLimits = GPULimitPreset.Default.limits))

    surface.configure(
        GPUSurfaceConfiguration(
            device = device,
            format = preferredFormat,
            usage = GPUTextureUsage.RENDER_ATTACHMENT,
            presentMode = GPUPresentMode.Fifo,
            alphaMode = GPUCompositeAlphaMode.Auto,
            width = 800u,
            height = 600u,
            viewFormats = emptyList()
        )
    )


    val vsModule = device.createShaderModule(GPUShaderModuleDescriptor(code = vsShader))
    val fsModule = device.createShaderModule(GPUShaderModuleDescriptor(code = fsShader))

    val bgl = device.createBindGroupLayout(
        GPUBindGroupLayoutDescriptor(
            entries = listOf(
                GPUBindGroupLayoutEntry(
                    binding = 0u,
                    visibility = GPUShaderStage.VERTEX,
                    buffer = GPUBufferBindingLayout(
                        type = GPUBufferBindingType.Uniform,
                        hasDynamicOffset = true
                    ),
                )
            )
        )
    )

    val layout = device.createPipelineLayout(GPUPipelineLayoutDescriptor(bindGroupLayouts = listOf(bgl)))

    val pipeline = device.createRenderPipeline(
        GPURenderPipelineDescriptor(
            layout = layout,
            vertex = GPUVertexState(
                module = vsModule,
                entryPoint = "main"
            ),
            fragment = GPUFragmentState(
                module = fsModule,
                entryPoint = "main",
                targets = listOf(GPUColorTargetState(format = preferredFormat))
            ),
        )
    )


    val shaderData = Arena.global().allocate(ShaderData.layout, numTriangles.toLong())

    shaderDataEach(shaderData) { data ->
        data.scale = randomFloat(0.2f, 0.4f)
        data.time = 0f
        data.offsetX = randomFloat(-0.9f, 0.9f)
        data.offsetY = randomFloat(-0.9f, 0.9f)
        data.scalar = randomFloat(0.5f, 2.0f)
        data.scalarOffset = randomFloat(0.0f, 10.0f)
    }

    println(shaderData.byteSize())

    val buffer = device.createBuffer(GPUBufferDescriptor(size = shaderData.byteSize().toULong(), usage = GPUBufferUsage.COPY_DST or GPUBufferUsage.UNIFORM))
    val bindGroup =
        device.createBindGroup(
            GPUBindGroupDescriptor(
                layout = bgl,
                entries = listOf(
                    GPUBindGroupEntry(
                        binding = 0u,
                        resource = GPUBufferBinding(
                            buffer,
                            size = 256u,
                        ),
                    )
                )
            )
        )


    val queue = device.queue
    var frameCount = 0

    while (!glfwWindowShouldClose(window)) {

        frameCount++
        shaderDataEach(shaderData) { data ->
            data.time += frameCount / 60.0f
        }

        queue.writeBuffer(buffer, 0u, shaderData.address(), 0u, shaderData.byteSize().toULong())


        val surfaceTexture = surface.getCurrentTexture()
        val texture = surfaceTexture.texture
        val view = texture.createView(
            GPUTextureViewDescriptor(
                format = texture.format,
                mipLevelCount = 1u,
                arrayLayerCount = 1u
            )
        )

        val encoder = device.createCommandEncoder()
        val pass = encoder.beginRenderPass(
            GPURenderPassDescriptor(
                colorAttachments = listOf(
                    GPURenderPassColorAttachment(
                        view = view,
                        loadOp = GPULoadOp.Clear,
                        storeOp = GPUStoreOp.Store,
                    )
                )
            )
        )

        pass.setPipeline(pipeline)
        for (i in 0 until numTriangles) {
            val offset = i.toLong() * ShaderData.layout.byteSize()
            pass.setBindGroup(0u, bindGroup, listOf(offset.toUInt()))
            pass.draw(3u)
        }
        pass.end()


        val commandBuffer = encoder.finish()
        queue.submit(listOf(commandBuffer))


        surface.present()




        glfwPollEvents()
        glfwSwapBuffers(window)
    }

}


fun randomFloat(min: Float, max: Float): Float {
    return (Math.random() * (max - min)).toFloat() + min
}

private fun shaderDataEach(seg: MemorySegment, block: (ShaderData) -> Unit) {
    seg
        .spliterator(ShaderData.layout)
        .forEachRemaining { block(ShaderData(it)) }
}