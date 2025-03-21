package wgpu

public expect class GPUUncapturedErrorEvent {
    public val error: GPUError

    public constructor(type: String, gpuUncapturedErrorEventInitDict: GPUUncapturedErrorEventInit)
}
