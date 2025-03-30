package wgpu

import lib.wgpu.WGPUFrontFace

public typealias GPUFrontFaceInterop = WGPUFrontFace

public actual enum class GPUFrontFace(
    internal val interop: GPUFrontFaceInterop,
) {
    CCW(GPUFrontFaceInterop.CCW),
    CW(GPUFrontFaceInterop.CW),
    ;

    public fun into(): GPUFrontFaceInterop = interop

    public companion object {
        public fun from(v: GPUFrontFaceInterop): GPUFrontFace = when (v) {
            GPUFrontFaceInterop.CCW -> CCW
            GPUFrontFaceInterop.CW -> CW
            else -> error("Invalid GPUFrontFace: ${'$'}v")
        }
    }
}
