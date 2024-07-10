package webgpu

import java.lang.foreign.Arena
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class GPUShaderModule(
    internal val module_: WGPUShaderModule,
    internal val desc_: GPUShaderModuleDescriptor,
) {


    suspend fun getCompilationInfo(): GPUCompilationInfo {

        return Arena.ofConfined().use { temp ->
            suspendCoroutine {

                val callback =
                    webgpu.callback.WGPUCompilationInfoCallback2 { status, info, _, _ ->
                        when (status) {
                            WGPUCompilationInfoRequestStatus.Success -> {
                                it.resume(GPUCompilationInfo.from(WGPUCompilationInfo(info)))
                            }

                            else -> {
                                it.resumeWithException(wgpuError(status, "can't get compilation info"))
                            }
                        }
                    }

                val cb = WGPUCompilationInfoCallbackInfo2.allocate(temp)
                cb.mode = WGPUCallbackMode.AllowSpontaneous
                cb.callback = callback.allocate(temp)


                with(temp) {
                    wgpuShaderModuleGetCompilationInfo2(module_, cb)
                }
            }
        }


    }

}