package webgpu

public data class GPUDeviceDescriptor(
    override val label: String = "",
    public val requiredFeatures: List<GPUFeatureName> = mutableListOf(),
    public val requiredLimits: WGPULimits? = null,
    public val defaultQueue: GPUQueueDescriptor = GPUQueueDescriptor(),
) : GPUObjectDescriptorBase
