package wgpu

public expect class GPUSupportedLimits {
    public val maxTextureDimension1D: UInt

    public val maxTextureDimension2D: UInt

    public val maxTextureDimension3D: UInt

    public val maxTextureArrayLayers: UInt

    public val maxBindGroups: UInt

    public val maxBindGroupsPlusVertexBuffers: UInt

    public val maxBindingsPerBindGroup: UInt

    public val maxDynamicUniformBuffersPerPipelineLayout: UInt

    public val maxDynamicStorageBuffersPerPipelineLayout: UInt

    public val maxSampledTexturesPerShaderStage: UInt

    public val maxSamplersPerShaderStage: UInt

    public val maxStorageBuffersPerShaderStage: UInt

    public val maxStorageTexturesPerShaderStage: UInt

    public val maxUniformBuffersPerShaderStage: UInt

    public val maxUniformBufferBindingSize: ULong

    public val maxStorageBufferBindingSize: ULong

    public val minUniformBufferOffsetAlignment: UInt

    public val minStorageBufferOffsetAlignment: UInt

    public val maxVertexBuffers: UInt

    public val maxBufferSize: ULong

    public val maxVertexAttributes: UInt

    public val maxVertexBufferArrayStride: UInt

    public val maxInterStageShaderVariables: UInt

    public val maxColorAttachments: UInt

    public val maxColorAttachmentBytesPerSample: UInt

    public val maxComputeWorkgroupStorageSize: UInt

    public val maxComputeInvocationsPerWorkgroup: UInt

    public val maxComputeWorkgroupSizeX: UInt

    public val maxComputeWorkgroupSizeY: UInt

    public val maxComputeWorkgroupSizeZ: UInt

    public val maxComputeWorkgroupsPerDimension: UInt
}
