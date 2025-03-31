package wgpu

import lib.wgpu.WGPUTextureDimension

public typealias GPUTextureDimensionInterop = WGPUTextureDimension

public actual enum class GPUTextureDimension(
    internal val interop: GPUTextureDimensionInterop,
) {
    `1D`(GPUTextureDimensionInterop.`1D`),
    `2D`(GPUTextureDimensionInterop.`2D`),
    `3D`(GPUTextureDimensionInterop.`3D`),
    ;

    public fun into(): GPUTextureDimensionInterop = interop

    public companion object {
        public fun from(v: GPUTextureDimensionInterop): GPUTextureDimension = when (v) {
            GPUTextureDimensionInterop.`1D` -> `1D`
            GPUTextureDimensionInterop.`2D` -> `2D`
            GPUTextureDimensionInterop.`3D` -> `3D`
            else -> error("Invalid GPUTextureDimension: $v")
        }
    }
}
