package wgpu

import lib.wgpu.WGPUQueryType

public typealias GPUQueryTypeInterop = WGPUQueryType

public actual enum class GPUQueryType(
    internal val interop: GPUQueryTypeInterop,
) {
    Occlusion(GPUQueryTypeInterop.Occlusion),
    Timestamp(GPUQueryTypeInterop.Timestamp),
    ;

    public fun into(`out`: GPUQueryTypeInterop): GPUQueryTypeInterop = interop
}
