package wgpu

import lib.wgpu.WGPUFeatureName

public enum class GPUFeatureName(
    public val interop: WGPUFeatureName,
) {
    DepthClipControl(WGPUFeatureName.DepthClipControl),
    Depth32FloatStencil8(WGPUFeatureName.Depth32FloatStencil8),
    TimestampQuery(WGPUFeatureName.TimestampQuery),
    TextureCompressionBC(WGPUFeatureName.TextureCompressionBC),
    TextureCompressionBCSliced3D(WGPUFeatureName.TextureCompressionBCSliced3D),
    TextureCompressionETC2(WGPUFeatureName.TextureCompressionETC2),
    TextureCompressionASTC(WGPUFeatureName.TextureCompressionASTC),
    TextureCompressionASTCSliced3D(WGPUFeatureName.TextureCompressionASTCSliced3D),
    IndirectFirstInstance(WGPUFeatureName.IndirectFirstInstance),
    ShaderF16(WGPUFeatureName.ShaderF16),
    RG11B10UfloatRenderable(WGPUFeatureName.RG11B10UfloatRenderable),
    BGRA8UnormStorage(WGPUFeatureName.BGRA8UnormStorage),
    Float32Filterable(WGPUFeatureName.Float32Filterable),
    Float32Blendable(WGPUFeatureName.Float32Blendable),
    ClipDistances(WGPUFeatureName.ClipDistances),
    DualSourceBlending(WGPUFeatureName.DualSourceBlending),
    Subgroups(WGPUFeatureName.Subgroups),
    ;
}
