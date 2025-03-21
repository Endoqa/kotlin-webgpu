package wgpu

public expect class GPUDeviceLostInfo {
    public val reason: GPUDeviceLostReason

    public val message: String
}
