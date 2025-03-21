package wgpu

import lib.wgpu.WGPUBufferBindingType

public enum class GPUBufferBindingType(
    public val interop: WGPUBufferBindingType,
) {
    BindingNotUsed(WGPUBufferBindingType.BindingNotUsed),
    Uniform(WGPUBufferBindingType.Uniform),
    Storage(WGPUBufferBindingType.Storage),
    ReadOnlyStorage(WGPUBufferBindingType.ReadOnlyStorage),
    ;
}
