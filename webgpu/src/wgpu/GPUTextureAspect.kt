package wgpu

import lib.wgpu.WGPUTextureAspect

public enum class GPUTextureAspect(
    public val interop: WGPUTextureAspect,
) {
    All(WGPUTextureAspect.All),
    StencilOnly(WGPUTextureAspect.StencilOnly),
    DepthOnly(WGPUTextureAspect.DepthOnly),
    ;
}
