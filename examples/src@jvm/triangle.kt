package examples.triangle

import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import org.lwjgl.glfw.GLFW.*
import org.lwjgl.glfw.GLFWNativeWayland.glfwGetWaylandDisplay
import org.lwjgl.glfw.GLFWNativeWayland.glfwGetWaylandWindow
import wgpu.*
import wgpu.limits.GPULimitPreset
import java.io.File


fun main() {
    System.load(File("../../libs/libwgpu_native.so").absolutePath)
    runBlocking(newSingleThreadContext("App")) {
        appMain(emptyArray())
    }
}

private val shaderSource = """
@vertex
fn vs_main(@builtin(vertex_index) in_vertex_index: u32) -> @builtin(position) vec4f {
	var p = vec2f(0.0, 0.0);
	if (in_vertex_index == 0u) {
		p = vec2f(-0.5, -0.5);
	} else if (in_vertex_index == 1u) {
		p = vec2f(0.5, -0.5);
	} else {
		p = vec2f(0.0, 0.5);
	}
	return vec4f(p, 0.0, 1.0);
}

@fragment
fn fs_main() -> @location(0) vec4f {
	return vec4f(0.0, 0.4, 1.0, 1.0);
}
""".trimIndent()

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
    val window = glfwCreateWindow(800, 600, "Hello Triangle", 0, 0)

    val surface = gpu.createSurface(glfwGetWaylandDisplay(), glfwGetWaylandWindow(window))

    val capabilities = surface.getCapabilities(adapter)

    println(capabilities)

    val preferredFormat = capabilities.formats.first()

    println("Preferred format: $preferredFormat")

    println(GPULimitPreset.Default.limits)
    val device = adapter.requestDevice(GPUDeviceDescriptor(requiredLimits = GPULimitPreset.Default.limits))

    println(device)

    val shader = device.createShaderModule(GPUShaderModuleDescriptor(code = shaderSource))


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


    val pipeline = device.createRenderPipeline(
        GPURenderPipelineDescriptor(
            layout = null,
            vertex = GPUVertexState(
                module = shader,
                entryPoint = "vs_main"
            ),
            fragment = GPUFragmentState(
                module = shader,
                entryPoint = "fs_main",
                targets = listOf(GPUColorTargetState(format = preferredFormat))
            )
        )
    )

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
    pass.draw(3u)
    pass.end()

    val commandBuffer = encoder.finish()
    device.queue.submit(listOf(commandBuffer))


    surface.present()

    while (!glfwWindowShouldClose(window)) {
        glfwPollEvents()
        glfwSwapBuffers(window)
    }
}

