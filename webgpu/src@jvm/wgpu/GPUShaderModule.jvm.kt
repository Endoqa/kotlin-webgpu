package wgpu

import lib.wgpu.WGPUCompilationInfo
import lib.wgpu.WGPUCompilationInfoRequestStatus
import lib.wgpu.WGPUShaderModule
import lib.wgpu.wgpuShaderModuleGetCompilationInfo
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

public actual class GPUShaderModule(
    private val module: WGPUShaderModule
) : GPUObjectBase {
    actual override var label: String
        get() = TODO("Not yet implemented")
        set(value) {}

    public actual suspend fun getCompilationInfo(): GPUCompilationInfo {
        return unsafeScope {
            suspendCoroutine { cont ->
                val info = createCompilationInfoCallback { status, info, _, _ ->
                    when (status) {
                        WGPUCompilationInfoRequestStatus.Success
                            -> cont.resume(GPUCompilationInfo(WGPUCompilationInfo(info)))

                        else -> cont.resumeWithException(Error("Shader module compilation failed: $status"))
                    }
                }

                wgpuShaderModuleGetCompilationInfo(module, info)
            }
        }
    }


    public fun into(): WGPUShaderModule = module
}