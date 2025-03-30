package wgpu

import lib.wgpu.WGPUFrontFace

public typealias GPUFrontFaceInterop = WGPUFrontFace

public actual enum class GPUFrontFace(
    internal val interop: GPUFrontFaceInterop,
) {
    CCW(GPUFrontFaceInterop.CCW),
    CW(GPUFrontFaceInterop.CW),
    ;

    public fun into(`out`: GPUFrontFaceInterop): GPUFrontFaceInterop = interop
}
