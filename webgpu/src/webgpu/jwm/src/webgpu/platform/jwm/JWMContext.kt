package webgpu.platform.jwm

import GPU
import io.github.humbleui.jwm.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Runnable
import kotlinx.coroutines.channels.Channel
import webgpu.*
import java.lang.foreign.Arena
import java.lang.foreign.MemorySegment
import java.util.function.Consumer
import kotlin.coroutines.CoroutineContext


data class Application(
    val navigator: Navigator,
    val context: JWMContext
)

data class Navigator(
    val gpu: GPU
)

object JWMDispatcher : CoroutineDispatcher() {
    override fun dispatch(context: CoroutineContext, block: Runnable) {
        App.runOnUIThread(block)
    }

}

class JWMContext(
    internal val surface: WGPUSurface,
    internal val instance: WGPUInstance,
    internal val layer: LayerMetal,
    internal val window: WindowMac,
) : Consumer<Event> {


    var width = (window.contentRect.width).toInt()
    var height = (window.contentRect.height).toInt()


    val arena = Arena.ofAuto()


    fun configure(device: GPUDevice, width: UInt, height: UInt) {
        Arena.ofAuto().let { temp ->
            val cfg = WGPUSurfaceConfiguration.allocate(temp)
            cfg.width = width
            cfg.height = height
            cfg.usage = GPUTextureUsage.RENDER_ATTACHMENT
            cfg.format = WGPUTextureFormat.BGRA8Unorm
            cfg.viewFormatCount = 0u
            cfg.viewFormats = MemorySegment.NULL
            cfg.device = device._internalDevice()
            cfg.presentMode = WGPUPresentMode.Mailbox
            cfg.alphaMode = WGPUCompositeAlphaMode.Auto
            wgpuSurfaceConfigure(surface, cfg.`$mem`)
        }
    }

    fun present() {
        wgpuSurfacePresent(surface)
    }

    fun currentTexture(): GPUTexture {
        Arena.ofConfined().use { onStack ->
            val st = WGPUSurfaceTexture.allocate(onStack)
            wgpuSurfaceGetCurrentTexture(surface, st.`$mem`)

            if (st.status != WGPUSurfaceGetCurrentTextureStatus.Success) {
                throw RuntimeException("Texture not loaded")
            }

            return GPUTexture(st.texture, null, arena)
        }
    }

    private val frameRequester = Channel<Unit>()
    val onResize = Channel<Unit>()


    override fun accept(event: Event) {
        when (event) {
            is EventWindowResize -> {
                width = (event.contentWidth).toInt()
                height = (event.contentHeight).toInt()
                onResize.trySend(Unit)
            }

            is EventFrame -> {
                frameRequester.trySend(Unit)
            }
        }
    }

    suspend fun requestFrame() {
        window.requestFrame()
        frameRequester.receive()
    }

    companion object {
        @JvmStatic
        fun initFrom(window: WindowMac): Application {


            val instance = wgpuCreateInstance(WGPUInstanceDescriptor.allocate(Arena.ofAuto()).`$mem`)

            val layer = LayerMetal()
            window.setLayer(layer)
            window.setVisible(true)


            val surface = Arena.ofConfined().use { temp ->
                val desc = WGPUSurfaceDescriptor.allocate(temp)
                val mtDesc = WGPUSurfaceDescriptorFromMetalLayer.allocate(temp)

                desc.label = temp.allocateFrom("JWM Surface")
                mtDesc.layer = MemorySegment.ofAddress(layer._nGetMetalLayer())
                mtDesc.chain.sType = WGPUSType.SurfaceDescriptorFromMetalLayer
                mtDesc.chain.next = MemorySegment.NULL

                desc.nextInChain = mtDesc.`$mem`

                println(mtDesc.chain.sType)

                val surface = wgpuInstanceCreateSurface(instance, desc.`$mem`)
                surface
            }


            val gpu = GPU(instance, surface, Arena.ofAuto())
            val context = JWMContext(surface, instance, layer, window)
            window.setEventListener(context)
            val app = Application(Navigator(gpu), context)
            return app
        }
    }

}