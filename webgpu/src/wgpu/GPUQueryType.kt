package wgpu

import lib.wgpu.WGPUQueryType

public enum class GPUQueryType(
    public val interop: WGPUQueryType,
) {
    Occlusion(WGPUQueryType.Occlusion),
    Timestamp(WGPUQueryType.Timestamp),
    ;
}
