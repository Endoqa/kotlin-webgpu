package wgpu

public expect enum class GPUFeatureName {
    DepthClipControl,
    Depth32FloatStencil8,
    TimestampQuery,
    TextureCompressionBC,
    TextureCompressionBCSliced3D,
    TextureCompressionETC2,
    TextureCompressionASTC,
    TextureCompressionASTCSliced3D,
    IndirectFirstInstance,
    ShaderF16,
    RG11B10UfloatRenderable,
    BGRA8UnormStorage,
    Float32Filterable,
    Float32Blendable,
    ClipDistances,
    DualSourceBlending,
    Subgroups,
}
