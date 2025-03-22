package wgpu

public expect enum class GPUStorageTextureAccess {
    BindingNotUsed,
    WriteOnly,
    ReadOnly,
    ReadWrite,
}
