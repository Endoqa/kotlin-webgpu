package wgpu

import lib.wgpu.*
import java.lang.foreign.MemorySegment
import java.lang.foreign.ValueLayout
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

public class RequestAdapterError(public val status: WGPURequestAdapterStatus, message: String) : Throwable(message)

public actual class GPU {

    private val instance: WGPUInstance = wgpuCreateInstance(MemorySegment.NULL)

    init {
        require(instance != MemorySegment.NULL) { "Failed to create WGPUInstance" }
    }


    public actual val wgslLanguageFeatures: WGSLLanguageFeatures by lazy {
        unsafe { onStack ->
            val featuresPtr = onStack.allocate(ValueLayout.ADDRESS)
            val features = when (wgpuInstanceGetWGSLLanguageFeatures(instance, featuresPtr)) {
                WGPUStatus.Success -> {
                    WGPUSupportedWGSLLanguageFeatures(featuresPtr.getAtIndex(ValueLayout.ADDRESS, 0))
                }

                else -> error("Failed to get WGSLLanguageFeatures")
            }

            List(features.featureCount.toInt()) {
                val feature =
                    WGPUWGSLLanguageFeatureName.fromInt(features.features.getAtIndex(ValueLayout.JAVA_INT, it.toLong()))
                feature.name
            }
                .toSet()
        }
    }

    public actual suspend fun requestAdapter(options: GPURequestAdapterOptions): GPUAdapter? {
        return unsafeScope {
            val nativeOptions = options.into()
            nativeOptions.backendType = WGPUBackendType.Vulkan

            suspendCoroutine<GPUAdapter?> { cont ->
                val info = createRequestAdapterCallback { status, adapter, message, userdata1, userdata2 ->
                    when (status) {
                        WGPURequestAdapterStatus.Success -> cont.resume(GPUAdapter(adapter))
                        else -> cont.resumeWithException(RequestAdapterError(status, String.from(message)))
                    }
                }

                wgpuInstanceRequestAdapter(instance, nativeOptions.`$mem`, info)

            }
        }
    }

    public actual fun getPreferredCanvasFormat(): GPUTextureFormat {
        return GPUTextureFormat.BGRA8Unorm
    }

}