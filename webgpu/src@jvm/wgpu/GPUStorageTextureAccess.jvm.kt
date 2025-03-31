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

    public fun into(): GPUStorageTextureAccessInterop = interop

    public companion object {
        public fun from(v: GPUStorageTextureAccessInterop): GPUStorageTextureAccess = when (v) {
            GPUStorageTextureAccessInterop.BindingNotUsed -> BindingNotUsed
            GPUStorageTextureAccessInterop.WriteOnly -> WriteOnly
            GPUStorageTextureAccessInterop.ReadOnly -> ReadOnly
            GPUStorageTextureAccessInterop.ReadWrite -> ReadWrite
            else -> error("Invalid GPUStorageTextureAccess: $v")
        }
    }
}
