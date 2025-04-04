import wgpu.*
import wgpu.limits.GPULimitPreset
import java.lang.foreign.Arena
import java.lang.foreign.MemorySegment
import runApp
import initGPU
import createWindow
import createSurface
import configureSurface
import createShaderModule
import createTextureView
import createRenderPass
import windowShouldClose
import handleEvents
import randomFloat
import memorySegmentEach


private val vsShader = """
struct Constants_std140_0
{
    @align(16) scale_0 : f32,
    @align(4) time_0 : f32,
    @align(8) offsetX_0 : f32,
    @align(4) offsetY_0 : f32,
    @align(16) scalar_0 : f32,
    @align(4) scalarOffset_0 : f32,
};

struct SLANG_ParameterGroup_ConstantsBuffer_std140_0
{
    @align(16) c_0 : Constants_std140_0,
};

@binding(0) @group(0) var<uniform> ConstantsBuffer_0 : SLANG_ParameterGroup_ConstantsBuffer_std140_0;
struct VertexOut_0
{
    @location(0) v_color_0 : vec4<f32>,
    @builtin(position) Position_0 : vec4<f32>,
};

@vertex
fn main(@builtin(vertex_index) VertexIndex_0 : u32) -> VertexOut_0
{
    var positions_0 : array<vec4<f32>, i32(3)> = array<vec4<f32>, i32(3)>( vec4<f32>(0.0f, 0.10000000149011612f, 0.0f, 1.0f), vec4<f32>(-0.10000000149011612f, -0.10000000149011612f, 0.0f, 1.0f), vec4<f32>(0.10000000149011612f, -0.10000000149011612f, 0.0f, 1.0f) );
    var colors_0 : array<vec4<f32>, i32(3)> = array<vec4<f32>, i32(3)>( vec4<f32>(1.0f, 0.0f, 0.0f, 1.0f), vec4<f32>(0.0f, 1.0f, 0.0f, 1.0f), vec4<f32>(0.0f, 0.0f, 1.0f, 1.0f) );
    var fade_0 : f32 = ConstantsBuffer_0.c_0.scalarOffset_0 + ConstantsBuffer_0.c_0.time_0 * ConstantsBuffer_0.c_0.scalar_0 / 10.0f;
    var fade_1 : f32 = fade_0 - floor(fade_0);
    var fade_2 : f32;
    if(fade_1 < 0.5f)
    {
        fade_2 = fade_1 * 2.0f;
    }
    else
    {
        fade_2 = (1.0f - fade_1) * 2.0f;
    }
    var xpos_0 : f32 = positions_0[VertexIndex_0].x * ConstantsBuffer_0.c_0.scale_0;
    var ypos_0 : f32 = positions_0[VertexIndex_0].y * ConstantsBuffer_0.c_0.scale_0;
    var angle_0 : f32 = 6.28318023681640625f * fade_2;
    var _S1 : f32 = cos(angle_0);
    var _S2 : f32 = sin(angle_0);
    var xpos_1 : f32 = xpos_0 * _S1 - ypos_0 * _S2 + ConstantsBuffer_0.c_0.offsetX_0;
    var ypos_1 : f32 = xpos_0 * _S2 + ypos_0 * _S1 + ConstantsBuffer_0.c_0.offsetY_0;
    var output_0 : VertexOut_0;
    output_0.v_color_0 = vec4<f32>(fade_2, 1.0f - fade_2, 0.0f, 1.0f) + colors_0[VertexIndex_0];
    output_0.Position_0 = vec4<f32>(xpos_1, ypos_1, 0.0f, 1.0f);
    return output_0;
}


""".trimIndent()

private val fsShader = """
      @fragment fn main(@location(0) v_color : vec4f) -> @location(0) vec4f {
            return v_color;
        }
""".trimIndent()


private const val numTriangles = 10000

fun main() {
    runApp("../libs/libwgpu_native.so") { args ->
        appMain(args)
    }
}

private suspend fun appMain(args: Array<String>) {
    val (gpu, adapter) = initGPU()

    val window = createWindow(800, 600, "Animometer")

    val surface = createSurface(gpu, window)


    val capabilities = surface.getCapabilities(adapter)
    val preferredFormat = capabilities.formats.first()
    println("Preferred format: $preferredFormat")

    val device = adapter.requestDevice(GPUDeviceDescriptor(requiredLimits = GPULimitPreset.Default.limits))

    configureSurface(surface, device, preferredFormat, 800u, 600u)


    val vsModule = createShaderModule(device, vsShader)
    val fsModule = createShaderModule(device, fsShader)

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

    while (!windowShouldClose(window)) {

        frameCount++
        shaderDataEach(shaderData) { data ->
            data.time += frameCount / 60.0f
        }

        queue.writeBuffer(buffer, 0u, shaderData.address(), 0u, shaderData.byteSize().toULong())


        val surfaceTexture = surface.getCurrentTexture()
        val texture = surfaceTexture.texture
        val view = createTextureView(texture)

        val encoder = device.createCommandEncoder()
        val pass = createRenderPass(encoder, view)

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

        handleEvents(window)
    }

}


private fun shaderDataEach(seg: MemorySegment, block: (ShaderData) -> Unit) {
    memorySegmentEach(seg, ShaderData.layout) { block(ShaderData(it)) }
}
