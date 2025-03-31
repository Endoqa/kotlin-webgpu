package wgpu

import lib.wgpu.WGPUBufferBindingType

public typealias GPUBufferBindingTypeInterop = WGPUBufferBindingType

public actual enum class GPUBufferBindingType(
    internal val interop: GPUBufferBindingTypeInterop,
) {
    BindingNotUsed(GPUBufferBindingTypeInterop.BindingNotUsed),
    Uniform(GPUBufferBindingTypeInterop.Uniform),
    Storage(GPUBufferBindingTypeInterop.Storage),
    ReadOnlyStorage(GPUBufferBindingTypeInterop.ReadOnlyStorage),
    ;

    public fun into(): GPUBufferBindingTypeInterop = interop

    public companion object {
        public fun from(v: GPUBufferBindingTypeInterop): GPUBufferBindingType = when (v) {
            GPUBufferBindingTypeInterop.BindingNotUsed -> BindingNotUsed
            GPUBufferBindingTypeInterop.Uniform -> Uniform
            GPUBufferBindingTypeInterop.Storage -> Storage
            GPUBufferBindingTypeInterop.ReadOnlyStorage -> ReadOnlyStorage
            else -> error("Invalid GPUBufferBindingType: $v")
        }
    }
}
