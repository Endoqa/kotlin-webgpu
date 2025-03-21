package wgpu

import lib.wgpu.WGPUStorageTextureAccess

public enum class GPUStorageTextureAccess(
    public val interop: WGPUStorageTextureAccess,
) {
    BindingNotUsed(WGPUStorageTextureAccess.BindingNotUsed),
    WriteOnly(WGPUStorageTextureAccess.WriteOnly),
    ReadOnly(WGPUStorageTextureAccess.ReadOnly),
    ReadWrite(WGPUStorageTextureAccess.ReadWrite),
    ;
}
