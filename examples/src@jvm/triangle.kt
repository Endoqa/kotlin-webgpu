import wgpu.*
import wgpu.limits.GPULimitPreset


fun main() {
    runApp("../../libs/libwgpu_native.so") { args ->
        appMain(args)
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
    val (gpu, adapter) = initGPU()

    val window = createWindow(800, 600, "Hello Triangle")

    val surface = createSurface(gpu, window)

    val capabilities = surface.getCapabilities(adapter)
    println(capabilities)
    val preferredFormat = capabilities.formats.first()
    println("Preferred format: $preferredFormat")

    println(GPULimitPreset.Default.limits)
    val device = adapter.requestDevice(GPUDeviceDescriptor(requiredLimits = GPULimitPreset.Default.limits))
    println(device)

    val shader = createShaderModule(device, shaderSource)

    configureSurface(surface, device, preferredFormat, 800u, 600u)


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
    val view = createTextureView(texture)

    val encoder = device.createCommandEncoder()
    val pass = createRenderPass(encoder, view)
    pass.setPipeline(pipeline)
    pass.draw(3u)
    pass.end()

    val commandBuffer = encoder.finish()
    device.queue.submit(listOf(commandBuffer))


    surface.present()

    while (!windowShouldClose(window)) {
        handleEvents(window)
    }
}
