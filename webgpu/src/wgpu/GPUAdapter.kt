package wgpu

public expect class GPUAdapter {
    public val features: GPUSupportedFeatures

    public val limits: GPUSupportedLimits

    public val info: GPUAdapterInfo

    public val isFallbackAdapter: Boolean

    public suspend fun requestDevice(descriptor: GPUDeviceDescriptor = GPUDeviceDescriptor()): GPUDevice
}
