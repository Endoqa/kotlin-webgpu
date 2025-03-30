package wgpu

public expect enum class GPUDeviceLostReason {
    Unknown,
    Destroyed,
    CallbackCancelled,
    FailedCreation,
}
