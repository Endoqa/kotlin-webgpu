package wgpu

import lib.wgpu.WGPUQueryType

public typealias GPUQueryTypeInterop = WGPUQueryType

public actual enum class GPUQueryType(
    internal val interop: GPUQueryTypeInterop,
) {
    Occlusion(GPUQueryTypeInterop.Occlusion),
    Timestamp(GPUQueryTypeInterop.Timestamp),
    ;

    public fun into(): GPUQueryTypeInterop = interop

    public companion object {
        public fun from(v: GPUQueryTypeInterop): GPUQueryType = when (v) {
            GPUQueryTypeInterop.Occlusion -> Occlusion
            GPUQueryTypeInterop.Timestamp -> Timestamp
            else -> error("Invalid GPUQueryType: $v")
        }
    }
}
