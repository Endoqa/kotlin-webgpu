package wgpu

public actual class GPUUncapturedErrorEvent(
    public actual val error: GPUError
) {
    public actual constructor(
        type: String,
        gpuUncapturedErrorEventInitDict: GPUUncapturedErrorEventInit
    ) : this(gpuUncapturedErrorEventInitDict.error)
}