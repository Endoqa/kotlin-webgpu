package wgpu

import lib.wgpu.WGPUStorageTextureAccess

public typealias GPUStorageTextureAccessInterop = WGPUStorageTextureAccess

public actual enum class GPUStorageTextureAccess(
    internal val interop: GPUStorageTextureAccessInterop,
) {
    BindingNotUsed(GPUStorageTextureAccessInterop.BindingNotUsed),
    WriteOnly(GPUStorageTextureAccessInterop.WriteOnly),
    ReadOnly(GPUStorageTextureAccessInterop.ReadOnly),
    ReadWrite(GPUStorageTextureAccessInterop.ReadWrite),
    ;

    public fun into(`out`: GPUStorageTextureAccessInterop): GPUStorageTextureAccessInterop = interop
}
