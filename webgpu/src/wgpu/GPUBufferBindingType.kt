package wgpu

public expect enum class GPUBufferBindingType {
    BindingNotUsed,
    Uniform,
    Storage,
    ReadOnlyStorage,
}
