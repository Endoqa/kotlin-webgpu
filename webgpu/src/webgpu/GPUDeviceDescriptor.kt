package webgpu

import webgpu.c.WGPULimits

data class GPUDeviceDescriptor(
    override val label: String = "",
    val requiredFeatures: List<GPUFeatureName> = mutableListOf(),
    val requiredLimits: WGPULimits? = null,
    val defaultQueue: GPUQueueDescriptor = GPUQueueDescriptor(),
) : GPUObjectDescriptorBase
