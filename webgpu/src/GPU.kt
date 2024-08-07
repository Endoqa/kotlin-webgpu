import webgpu.GPUAdapter
import webgpu.GPUBackendType
import webgpu.GPURequestAdapterOptions
import webgpu.c.*
import webgpu.wgpuError
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


    suspend fun requestAdapter(
        backendType: GPUBackendType,
        options: GPURequestAdapterOptions = GPURequestAdapterOptions()
    ): GPUAdapter =
        suspendCoroutine<GPUAdapter> { cont ->
            val callback = webgpu.c.callback.WGPURequestAdapterCallback2 { status, adapter, message, _, _ ->
                when (status) {
                    WGPURequestAdapterStatus.Success -> cont.resume(GPUAdapter(adapter, arena))
                    else -> cont.resumeWithException(wgpuError(status, message))
                }
            }

            Arena.ofConfined().use { temp ->

                val opt = WGPURequestAdapterOptions.allocate(temp)
                opt.powerPreference = options.powerPreference
                opt.forceFallbackAdapter = Converter.convert(options.forceFallbackAdapter)
                opt.compatibleSurface = surface
                opt.backendType = backendType //TODO auto detect

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