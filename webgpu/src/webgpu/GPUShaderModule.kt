package webgpu

import java.lang.foreign.Arena
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class GPUShaderModule(
    internal val module_: WGPUShaderModule,
    internal val desc_: GPUShaderModuleDescriptor,
) {

    //     Promise<GPUCompilationInfo> getCompilationInfo();
    suspend fun getCompilationInfo(): GPUCompilationInfo {

        return Arena.ofConfined().use { temp ->
            suspendCoroutine {

                val callback = webgpu.callback.WGPUCompilationInfoCallback { status, info, userData ->
                    when (status) {
                        WGPUCompilationInfoRequestStatus.Success -> {
                            it.resume(GPUCompilationInfo.from(WGPUCompilationInfo(info)))
                        }

                        else -> {
                            it.resumeWithException(Exception("Compilation failed"))
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