import io.github.humbleui.jwm.App
import io.github.humbleui.jwm.WindowMac
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import webgpu.*
import webgpu.platform.jwm.Application
import webgpu.platform.jwm.JWMContext
import webgpu.platform.jwm.JWMDispatcher
import java.io.File
import java.lang.foreign.*

private fun setDawnInCPP() {

    val hackyCCode = SymbolLookup.loaderLookup().find("_ZN4dawn6native8GetProcsEv").get()

    val m = Linker.nativeLinker().downcallHandle(
        hackyCCode,
        FunctionDescriptor.of(
            ValueLayout.ADDRESS
        )
    )

    val dawnProcSetProcsAddr = SymbolLookup.loaderLookup().find("dawnProcSetProcs").get()
    val dawnProcSetProcs = Linker.nativeLinker().downcallHandle(
        dawnProcSetProcsAddr,
        FunctionDescriptor.ofVoid(ValueLayout.ADDRESS)
    )

    val table = m.invokeExact() as MemorySegment
    dawnProcSetProcs.invokeExact(table) as Unit

}


fun main(args: Array<String>) {
    System.load(File("../libs/libdawn_native.dylib").absolutePath)
    System.load(File("../libs/libdawn_platform.dylib").absolutePath)
    System.load(File("../libs/libdawn_proc.dylib").absolutePath)
    System.load(File("../libs/libwebgpu_dawn.dylib").absolutePath)
    setDawnInCPP()




    App.start {
        val window = App.makeWindow()
        window as WindowMac
        window.setTitle("Fun")
        window.setVisible(true)
        window.requestFrame()

        val app = JWMContext.initFrom(window as WindowMac)

        with(app) {
            GlobalScope.launch(JWMDispatcher) {
                appMain()
            }
        }
    }
}


context(Application)
suspend fun appMain() = coroutineScope {

    val adapter =
        navigator.gpu.requestAdapter(GPURequestAdapterOptions(powerPreference = GPUPowerPreference.HighPerformance))
    val device = adapter.requestDevice()


    context.configure(device, context.width.toUInt(), context.height.toUInt())


    launch {
        for (e in context.onResize) {
            context.configure(device, context.width.toUInt(), context.height.toUInt())
        }
    }


    val module = device.createShaderModule(
        GPUShaderModuleDescriptor(
            label = "triangle",
            code = """
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
        """.trimIndent(),
        )
    )


    val pipeline = device.createRenderPipeline(
        GPURenderPipelineDescriptor(
            label = "our red triangle pipeline",
            vertex = GPUVertexState(
                module = module,
                entryPoint = "vs_main"
            ),
            fragment = GPUFragmentState(
                module = module,
                entryPoint = "fs_main",
                targets = listOf(
                    GPUColorTargetState(
                        format = GPUTextureFormat.BGRA8Unorm
                    )
                )
            ),
            primitive = GPUPrimitiveState(
                topology = GPUPrimitiveTopology.TriangleList,
                frontFace = GPUFrontFace.CCW,
            )
        )
    )


    val renderPassDescriptor = GPURenderPassDescriptor(
        colorAttachments = listOf(
            GPURenderPassColorAttachment(
                view = GPUTextureView(MemorySegment.NULL),
                clearValue = GPUColor(0.0, 0.0, 0.0, 0.0),
                loadOp = GPULoadOp.Clear,
                storeOp = GPUStoreOp.Store,
            )
        )
    )

    fun render() {
        renderPassDescriptor.colorAttachments[0].view = context.currentTexture().createView(
            GPUTextureViewDescriptor(
                label = "our red triangle color attachment",
                dimension = GPUTextureViewDimension.`2D`,
                mipLevelCount = 1u,
                arrayLayerCount = 1u
            )
        )

        val encoder = device.createCommandEncoder()

        val pass = encoder.beginRenderPass(renderPassDescriptor)
        pass.setPipeline(pipeline)
        pass.draw(3u)
        pass.end()

        val commandBuffer = encoder.finish()
        device.queue.submit(listOf(commandBuffer))
        context.present()
    }


    fun loop() {
        render()
    }


    while (true) {
        context.requestFrame()
        loop()
    }

}
