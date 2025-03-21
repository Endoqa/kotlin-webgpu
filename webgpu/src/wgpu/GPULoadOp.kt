package wgpu

import lib.wgpu.WGPULoadOp

public enum class GPULoadOp(
    public val interop: WGPULoadOp,
) {
    Load(WGPULoadOp.Load),
    Clear(WGPULoadOp.Clear),
    ;
}
