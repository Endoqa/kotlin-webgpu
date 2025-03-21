package wgpu

import lib.wgpu.WGPUTextureDimension

public enum class GPUTextureDimension(
    public val interop: WGPUTextureDimension,
) {
    `1D`(WGPUTextureDimension.`1D`),
    `2D`(WGPUTextureDimension.`2D`),
    `3D`(WGPUTextureDimension.`3D`),
    ;
}
