package wgpu

public expect class GPUShaderModule : GPUObjectBase {
    override var label: String

    public suspend fun getCompilationInfo(): GPUCompilationInfo
}
