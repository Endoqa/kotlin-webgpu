package wgpu

import lib.wgpu.WGPUTextureViewDimension

public enum class GPUTextureViewDimension(
    public val interop: WGPUTextureViewDimension,
) {
    `1D`(WGPUTextureViewDimension.`1D`),
    `2D`(WGPUTextureViewDimension.`2D`),
    `2DArray`(WGPUTextureViewDimension.`2DArray`),
    Cube(WGPUTextureViewDimension.Cube),
    CubeArray(WGPUTextureViewDimension.CubeArray),
    `3D`(WGPUTextureViewDimension.`3D`),
    ;
}
