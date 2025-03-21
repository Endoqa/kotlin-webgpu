package wgpu

public data class GPUDeviceDescriptor(
    override var label: String = "",
    public var requiredFeatures: List<GPUFeatureName> = listOf(),
    public var requiredLimits: GPULimits = GPULimits(),
    public var defaultQueue: GPUQueueDescriptor = GPUQueueDescriptor(),
) : GPUObjectDescriptorBase(label = label)
