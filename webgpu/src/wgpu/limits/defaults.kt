package wgpu.limits

import wgpu.GPULimits


public enum class GPULimitPreset(public val limits: GPULimits) {
    Default(default()),
//    Downlevel,
}

private fun default(): GPULimits {
    return GPULimits(
        maxTextureDimension1D = 8192u,
        maxTextureDimension2D = 8192u,
        maxTextureDimension3D = 2048u,
        maxTextureArrayLayers = 256u,
        maxBindGroups = 4u,
        maxBindingsPerBindGroup = 1000u,
        maxDynamicUniformBuffersPerPipelineLayout = 8u,
        maxDynamicStorageBuffersPerPipelineLayout = 4u,
        maxSampledTexturesPerShaderStage = 16u,
        maxSamplersPerShaderStage = 16u,
        maxStorageBuffersPerShaderStage = 8u,
        maxStorageTexturesPerShaderStage = 4u,
        maxUniformBuffersPerShaderStage = 12u,
        maxUniformBufferBindingSize = (64uL shl 10), // (64 KiB)
        maxStorageBufferBindingSize = (128uL shl 20), // (128 MiB)
        maxVertexBuffers = 8u,
        maxBufferSize = (256uL shl 20), // (256 MiB)
        maxVertexAttributes = 16u,
        maxVertexBufferArrayStride = 2048u,
        minUniformBufferOffsetAlignment = 256u,
        minStorageBufferOffsetAlignment = 256u,
        maxColorAttachments = 8u,
        maxColorAttachmentBytesPerSample = 32u,
        maxComputeWorkgroupStorageSize = 16384u,
        maxComputeInvocationsPerWorkgroup = 256u,
        maxComputeWorkgroupSizeX = 256u,
        maxComputeWorkgroupSizeY = 256u,
        maxComputeWorkgroupSizeZ = 64u,
        maxComputeWorkgroupsPerDimension = 65535u
    )
}