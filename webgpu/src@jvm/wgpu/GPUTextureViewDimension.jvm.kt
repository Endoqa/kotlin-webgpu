package wgpu

import lib.wgpu.WGPUTextureViewDimension

public typealias GPUTextureViewDimensionInterop = WGPUTextureViewDimension

public actual enum class GPUTextureViewDimension(
    internal val interop: GPUTextureViewDimensionInterop,
) {
    `1D`(GPUTextureViewDimensionInterop.`1D`),
    `2D`(GPUTextureViewDimensionInterop.`2D`),
    `2DArray`(GPUTextureViewDimensionInterop.`2DArray`),
    Cube(GPUTextureViewDimensionInterop.Cube),
    CubeArray(GPUTextureViewDimensionInterop.CubeArray),
    `3D`(GPUTextureViewDimensionInterop.`3D`),
    ;

    public fun into(): GPUTextureViewDimensionInterop = interop

    public companion object {
        public fun from(v: GPUTextureViewDimensionInterop): GPUTextureViewDimension = when (v) {
            GPUTextureViewDimensionInterop.`1D` -> `1D`
            GPUTextureViewDimensionInterop.`2D` -> `2D`
            GPUTextureViewDimensionInterop.`2DArray` -> `2DArray`
            GPUTextureViewDimensionInterop.Cube -> Cube
            GPUTextureViewDimensionInterop.CubeArray -> CubeArray
            GPUTextureViewDimensionInterop.`3D` -> `3D`
            else -> error("Invalid GPUTextureViewDimension: ${'$'}v")
        }
    }
}
