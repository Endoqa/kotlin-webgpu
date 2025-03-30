package wgpu

import lib.wgpu.WGPUTextureAspect

public typealias GPUTextureAspectInterop = WGPUTextureAspect

public actual enum class GPUTextureAspect(
    internal val interop: GPUTextureAspectInterop,
) {
    All(GPUTextureAspectInterop.All),
    StencilOnly(GPUTextureAspectInterop.StencilOnly),
    DepthOnly(GPUTextureAspectInterop.DepthOnly),
    ;

    public fun into(`out`: GPUTextureAspectInterop): GPUTextureAspectInterop = interop
}
