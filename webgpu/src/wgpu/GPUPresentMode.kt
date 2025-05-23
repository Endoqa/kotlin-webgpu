package wgpu

public expect enum class GPUPresentMode {
    Fifo,
    FifoRelaxed,
    Immediate,
    Mailbox,
}
