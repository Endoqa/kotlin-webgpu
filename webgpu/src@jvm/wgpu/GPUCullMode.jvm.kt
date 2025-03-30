package wgpu

import lib.wgpu.WGPUCullMode

public typealias GPUCullModeInterop = WGPUCullMode

public actual enum class GPUCullMode(
    internal val interop: GPUCullModeInterop,
) {
    None(GPUCullModeInterop.None),
    Front(GPUCullModeInterop.Front),
    Back(GPUCullModeInterop.Back),
    ;

    public fun into(): GPUCullModeInterop = interop

    public companion object {
        public fun from(v: GPUCullModeInterop): GPUCullMode = when (v) {
            GPUCullModeInterop.None -> None
            GPUCullModeInterop.Front -> Front
            GPUCullModeInterop.Back -> Back
            else -> error("Invalid GPUCullMode: ${'$'}v")
        }
    }
}
