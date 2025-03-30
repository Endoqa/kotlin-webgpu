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

    public fun into(): GPUFeatureNameInterop = interop

    public companion object {
        public fun from(v: GPUFeatureNameInterop): GPUFeatureName = when (v) {
            GPUFeatureNameInterop.DepthClipControl -> DepthClipControl
            GPUFeatureNameInterop.Depth32FloatStencil8 -> Depth32FloatStencil8
            GPUFeatureNameInterop.TimestampQuery -> TimestampQuery
            GPUFeatureNameInterop.TextureCompressionBC -> TextureCompressionBC
            GPUFeatureNameInterop.TextureCompressionBCSliced3D -> TextureCompressionBCSliced3D
            GPUFeatureNameInterop.TextureCompressionETC2 -> TextureCompressionETC2
            GPUFeatureNameInterop.TextureCompressionASTC -> TextureCompressionASTC
            GPUFeatureNameInterop.TextureCompressionASTCSliced3D -> TextureCompressionASTCSliced3D
            GPUFeatureNameInterop.IndirectFirstInstance -> IndirectFirstInstance
            GPUFeatureNameInterop.ShaderF16 -> ShaderF16
            GPUFeatureNameInterop.RG11B10UfloatRenderable -> RG11B10UfloatRenderable
            GPUFeatureNameInterop.BGRA8UnormStorage -> BGRA8UnormStorage
            GPUFeatureNameInterop.Float32Filterable -> Float32Filterable
            GPUFeatureNameInterop.Float32Blendable -> Float32Blendable
            GPUFeatureNameInterop.ClipDistances -> ClipDistances
            GPUFeatureNameInterop.DualSourceBlending -> DualSourceBlending
            GPUFeatureNameInterop.Subgroups -> Subgroups
            else -> error("Invalid GPUFeatureName: ${'$'}v")
        }
    }
}
