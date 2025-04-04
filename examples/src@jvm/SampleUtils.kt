import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import org.lwjgl.glfw.GLFW.*
import org.lwjgl.glfw.GLFWNativeWayland.glfwGetWaylandDisplay
import org.lwjgl.glfw.GLFWNativeWayland.glfwGetWaylandWindow
import wgpu.*
import java.io.File
import java.lang.foreign.MemorySegment
import java.lang.foreign.StructLayout


suspend fun initGPU(): Pair<GPU, GPUAdapter> {
    val gpu = GPU()
    val adapter = gpu.requestAdapter(GPURequestAdapterOptions(powerPreference = GPUPowerPreference.HighPerformance))
    require(adapter != null) { "Failed to find a suitable GPU" }
    println(adapter.features)
    println(adapter.info)
    println(adapter.limits)
    return Pair(gpu, adapter)
}


fun createWindow(width: Int, height: Int, title: String): Long {
    if (!glfwInit()) {
        error("Failed to initialize GLFW")
    }
    glfwInitHint(GLFW_PLATFORM, GLFW_PLATFORM_WAYLAND)
    glfwWindowHint(GLFW_CLIENT_API, GLFW_NO_API)
    return glfwCreateWindow(width, height, title, 0, 0)
}


fun createSurface(gpu: GPU, window: Long): GPUSurface {
    return gpu.createSurface(glfwGetWaylandDisplay(), glfwGetWaylandWindow(window))
}


fun configureSurface(surface: GPUSurface, device: GPUDevice, format: GPUTextureFormat, width: UInt, height: UInt) {
    surface.configure(
        GPUSurfaceConfiguration(
            device = device,
            format = format,
            usage = GPUTextureUsage.RENDER_ATTACHMENT,
            presentMode = GPUPresentMode.Fifo,
            alphaMode = GPUCompositeAlphaMode.Auto,
            width = width,
            height = height,
            viewFormats = emptyList()
        )
    )
}


fun createShaderModule(device: GPUDevice, code: String): GPUShaderModule {
    return device.createShaderModule(GPUShaderModuleDescriptor(code = code))
}

fun createTextureView(texture: GPUTexture): GPUTextureView {
    return texture.createView(
        GPUTextureViewDescriptor(
            format = texture.format,
            mipLevelCount = 1u,
            arrayLayerCount = 1u
        )
    )
}

fun createRenderPass(encoder: GPUCommandEncoder, view: GPUTextureView): GPURenderPassEncoder {
    return encoder.beginRenderPass(
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
}


fun handleEvents(window: Long) {
    glfwPollEvents()
    glfwSwapBuffers(window)
}


fun windowShouldClose(window: Long): Boolean {
    return glfwWindowShouldClose(window)
}


fun runApp(libPath: String, appMain: suspend (Array<String>) -> Unit) {
    System.load(File(libPath).absolutePath)
    runBlocking(newSingleThreadContext("App")) {
        appMain(emptyArray())
    }
}


fun randomFloat(min: Float, max: Float): Float {
    return (Math.random() * (max - min)).toFloat() + min
}

fun <T> memorySegmentEach(seg: MemorySegment, layout: StructLayout, block: (MemorySegment) -> T) {
    seg
        .spliterator(layout)
        .forEachRemaining { block(it) }
}