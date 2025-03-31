package wgpu

import lib.wgpu.WGPULimits
import lib.wgpu.WGPUStatus
import java.lang.foreign.MemorySegment

public actual data class GPUSupportedLimits(
    actual val maxTextureDimension1D: UInt,
    actual val maxTextureDimension2D: UInt,
    actual val maxTextureDimension3D: UInt,
    actual val maxTextureArrayLayers: UInt,
    actual val maxBindGroups: UInt,
    actual val maxBindGroupsPlusVertexBuffers: UInt,
    actual val maxBindingsPerBindGroup: UInt,
    actual val maxDynamicUniformBuffersPerPipelineLayout: UInt,
    actual val maxDynamicStorageBuffersPerPipelineLayout: UInt,
    actual val maxSampledTexturesPerShaderStage: UInt,
    actual val maxSamplersPerShaderStage: UInt,
    actual val maxStorageBuffersPerShaderStage: UInt,
    actual val maxStorageTexturesPerShaderStage: UInt,
    actual val maxUniformBuffersPerShaderStage: UInt,
    actual val maxUniformBufferBindingSize: ULong,
    actual val maxStorageBufferBindingSize: ULong,
    actual val minUniformBufferOffsetAlignment: UInt,
    actual val minStorageBufferOffsetAlignment: UInt,
    actual val maxVertexBuffers: UInt,
    actual val maxBufferSize: ULong,
    actual val maxVertexAttributes: UInt,
    actual val maxVertexBufferArrayStride: UInt,
    actual val maxInterStageShaderVariables: UInt,
    actual val maxColorAttachments: UInt,
    actual val maxColorAttachmentBytesPerSample: UInt,
    actual val maxComputeWorkgroupStorageSize: UInt,
    actual val maxComputeInvocationsPerWorkgroup: UInt,
    actual val maxComputeWorkgroupSizeX: UInt,
    actual val maxComputeWorkgroupSizeY: UInt,
    actual val maxComputeWorkgroupSizeZ: UInt,
    actual val maxComputeWorkgroupsPerDimension: UInt,
) {


    public companion object {
        public fun from(func: (MemorySegment) -> WGPUStatus): GPUSupportedLimits {
            return unsafe { temp ->
                val limits = WGPULimits.allocate(temp)
                when (val status = func(limits.`$mem`)) {
                    WGPUStatus.Success -> {}
                    else -> error("Failed to get limits for adapter. Status: $status")
                }

                GPUSupportedLimits(
                    maxTextureDimension1D = limits.maxTextureDimension1D,
                    maxTextureDimension2D = limits.maxTextureDimension2D,
                    maxTextureDimension3D = limits.maxTextureDimension3D,
                    maxTextureArrayLayers = limits.maxTextureArrayLayers,
                    maxBindGroups = limits.maxBindGroups,
                    maxBindGroupsPlusVertexBuffers = limits.maxBindGroupsPlusVertexBuffers,
                    maxBindingsPerBindGroup = limits.maxBindingsPerBindGroup,
                    maxDynamicUniformBuffersPerPipelineLayout = limits.maxDynamicUniformBuffersPerPipelineLayout,
                    maxDynamicStorageBuffersPerPipelineLayout = limits.maxDynamicStorageBuffersPerPipelineLayout,
                    maxSampledTexturesPerShaderStage = limits.maxSampledTexturesPerShaderStage,
                    maxSamplersPerShaderStage = limits.maxSamplersPerShaderStage,
                    maxStorageBuffersPerShaderStage = limits.maxStorageBuffersPerShaderStage,
                    maxStorageTexturesPerShaderStage = limits.maxStorageTexturesPerShaderStage,
                    maxUniformBuffersPerShaderStage = limits.maxUniformBuffersPerShaderStage,
                    maxUniformBufferBindingSize = limits.maxUniformBufferBindingSize,
                    maxStorageBufferBindingSize = limits.maxStorageBufferBindingSize,
                    minUniformBufferOffsetAlignment = limits.minUniformBufferOffsetAlignment,
                    minStorageBufferOffsetAlignment = limits.minStorageBufferOffsetAlignment,
                    maxVertexBuffers = limits.maxVertexBuffers,
                    maxBufferSize = limits.maxBufferSize,
                    maxVertexAttributes = limits.maxVertexAttributes,
                    maxVertexBufferArrayStride = limits.maxVertexBufferArrayStride,
                    maxInterStageShaderVariables = limits.maxInterStageShaderVariables,
                    maxColorAttachments = limits.maxColorAttachments,
                    maxColorAttachmentBytesPerSample = limits.maxColorAttachmentBytesPerSample,
                    maxComputeWorkgroupStorageSize = limits.maxComputeWorkgroupStorageSize,
                    maxComputeInvocationsPerWorkgroup = limits.maxComputeInvocationsPerWorkgroup,
                    maxComputeWorkgroupSizeX = limits.maxComputeWorkgroupSizeX,
                    maxComputeWorkgroupSizeY = limits.maxComputeWorkgroupSizeY,
                    maxComputeWorkgroupSizeZ = limits.maxComputeWorkgroupSizeZ,
                    maxComputeWorkgroupsPerDimension = limits.maxComputeWorkgroupsPerDimension,
                )
            }
        }
    }


}