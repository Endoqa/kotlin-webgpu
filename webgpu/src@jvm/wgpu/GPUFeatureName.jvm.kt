package wgpu

import lib.wgpu.WGPUFeatureName

public typealias GPUFeatureNameInterop = WGPUFeatureName

public actual enum class GPUFeatureName(
    internal val interop: GPUFeatureNameInterop,
) {
    DepthClipControl(GPUFeatureNameInterop.DepthClipControl),
    Depth32FloatStencil8(GPUFeatureNameInterop.Depth32FloatStencil8),
    TimestampQuery(GPUFeatureNameInterop.TimestampQuery),
    TextureCompressionBC(GPUFeatureNameInterop.TextureCompressionBC),
    TextureCompressionBCSliced3D(GPUFeatureNameInterop.TextureCompressionBCSliced3D),
    TextureCompressionETC2(GPUFeatureNameInterop.TextureCompressionETC2),
    TextureCompressionASTC(GPUFeatureNameInterop.TextureCompressionASTC),
    TextureCompressionASTCSliced3D(GPUFeatureNameInterop.TextureCompressionASTCSliced3D),
    IndirectFirstInstance(GPUFeatureNameInterop.IndirectFirstInstance),
    ShaderF16(GPUFeatureNameInterop.ShaderF16),
    RG11B10UfloatRenderable(GPUFeatureNameInterop.RG11B10UfloatRenderable),
    BGRA8UnormStorage(GPUFeatureNameInterop.BGRA8UnormStorage),
    Float32Filterable(GPUFeatureNameInterop.Float32Filterable),
    Float32Blendable(GPUFeatureNameInterop.Float32Blendable),
    ClipDistances(GPUFeatureNameInterop.ClipDistances),
    DualSourceBlending(GPUFeatureNameInterop.DualSourceBlending),
    Subgroups(GPUFeatureNameInterop.Subgroups),
    ;

    public fun into(`out`: GPUFeatureNameInterop): GPUFeatureNameInterop = interop
}
