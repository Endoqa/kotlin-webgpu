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

    public fun into(`out`: GPUBufferBindingTypeInterop): GPUBufferBindingTypeInterop = interop
}
