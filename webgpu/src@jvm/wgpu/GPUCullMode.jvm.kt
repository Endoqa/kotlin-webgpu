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

    public fun into(`out`: GPUCullModeInterop): GPUCullModeInterop = interop
}
