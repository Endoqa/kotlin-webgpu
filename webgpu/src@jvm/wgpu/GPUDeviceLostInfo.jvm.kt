package wgpu

public actual data class GPUDeviceLostInfo(
    public actual val reason: GPUDeviceLostReason,
    public actual val message: String
)