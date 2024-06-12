import webgpu.*
import java.lang.foreign.Arena
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine


typealias WGSLLanguageFeatures = Set<WGPUWGSLFeatureName>


class GPU(
    internal val instance: WGPUInstance,
    internal val surface: WGPUSurface,
    internal val arena: Arena,
) {


    suspend fun requestAdapter(options: GPURequestAdapterOptions = GPURequestAdapterOptions()): GPUAdapter =
        suspendCoroutine<GPUAdapter> { cont ->
            val callback = webgpu.callback.WGPURequestAdapterCallback2 { status, adapter, message, _, _ ->
                when (status) {
                    WGPURequestAdapterStatus.Success -> cont.resume(GPUAdapter(adapter, arena))
                    else -> {
                        if (!message) {
                            cont.resumeWithException(IllegalStateException(status.toString()))
                        } else {
                            cont.resumeWithException(IllegalStateException("$status: ${message.getString(0)}"))
                        }
                    }
                }
            }

            Arena.ofConfined().use { temp ->

                val opt = WGPURequestAdapterOptions.allocate(temp)
                opt.powerPreference = options.powerPreference
                opt.forceFallbackAdapter = Converter.convert(options.forceFallbackAdapter)
                opt.compatibleSurface = surface
                opt.backendType = WGPUBackendType.Metal

                val cb = WGPURequestAdapterCallbackInfo2.allocate(temp)
                cb.callback = callback.allocate(temp)
                cb.mode = WGPUCallbackMode.AllowSpontaneous


                with(temp) {
                    wgpuInstanceRequestAdapter2(
                        instance,
                        opt.`$mem`,
                        cb,
                    )
                }
            }
        }


}