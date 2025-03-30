package wgpu

import lib.wgpu.WGPUShaderModule

public actual class GPUShaderModule(
    private val module: WGPUShaderModule
) : GPUObjectBase {
    actual override var label: String
        get() = TODO("Not yet implemented")
        set(value) {}

    public actual suspend fun getCompilationInfo(): GPUCompilationInfo {
        TODO("Not yet implemented")
    }


    public fun into(): WGPUShaderModule = module
}