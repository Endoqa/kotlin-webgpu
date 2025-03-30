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

    public fun into(): GPUTextureAspectInterop = interop

    public companion object {
        public fun from(v: GPUTextureAspectInterop): GPUTextureAspect = when (v) {
            GPUTextureAspectInterop.All -> All
            GPUTextureAspectInterop.StencilOnly -> StencilOnly
            GPUTextureAspectInterop.DepthOnly -> DepthOnly
            else -> error("Invalid GPUTextureAspect: ${'$'}v")
        }
    }
}
