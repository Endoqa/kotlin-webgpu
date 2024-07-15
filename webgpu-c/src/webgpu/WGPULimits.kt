// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.foreign.*
import java.lang.invoke.VarHandle

@JvmInline
public value class WGPULimits(
    public val `$mem`: MemorySegment,
) {
    public var maxTextureDimension1D: uint32_t
        get() = (maxTextureDimension1DHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            maxTextureDimension1DHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var maxTextureDimension2D: uint32_t
        get() = (maxTextureDimension2DHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            maxTextureDimension2DHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var maxTextureDimension3D: uint32_t
        get() = (maxTextureDimension3DHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            maxTextureDimension3DHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var maxTextureArrayLayers: uint32_t
        get() = (maxTextureArrayLayersHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            maxTextureArrayLayersHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var maxBindGroups: uint32_t
        get() = (maxBindGroupsHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            maxBindGroupsHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var maxBindGroupsPlusVertexBuffers: uint32_t
        get() = (maxBindGroupsPlusVertexBuffersHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            maxBindGroupsPlusVertexBuffersHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var maxBindingsPerBindGroup: uint32_t
        get() = (maxBindingsPerBindGroupHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            maxBindingsPerBindGroupHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var maxDynamicUniformBuffersPerPipelineLayout: uint32_t
        get() = (maxDynamicUniformBuffersPerPipelineLayoutHandle.get(this.`$mem`, 0L) as
                Int).toUInt()
        set(`value`) {
            maxDynamicUniformBuffersPerPipelineLayoutHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var maxDynamicStorageBuffersPerPipelineLayout: uint32_t
        get() = (maxDynamicStorageBuffersPerPipelineLayoutHandle.get(this.`$mem`, 0L) as
                Int).toUInt()
        set(`value`) {
            maxDynamicStorageBuffersPerPipelineLayoutHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var maxSampledTexturesPerShaderStage: uint32_t
        get() = (maxSampledTexturesPerShaderStageHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            maxSampledTexturesPerShaderStageHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var maxSamplersPerShaderStage: uint32_t
        get() = (maxSamplersPerShaderStageHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            maxSamplersPerShaderStageHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var maxStorageBuffersPerShaderStage: uint32_t
        get() = (maxStorageBuffersPerShaderStageHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            maxStorageBuffersPerShaderStageHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var maxStorageTexturesPerShaderStage: uint32_t
        get() = (maxStorageTexturesPerShaderStageHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            maxStorageTexturesPerShaderStageHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var maxUniformBuffersPerShaderStage: uint32_t
        get() = (maxUniformBuffersPerShaderStageHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            maxUniformBuffersPerShaderStageHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var maxUniformBufferBindingSize: uint64_t
        get() = (maxUniformBufferBindingSizeHandle.get(this.`$mem`, 0L) as Long).toULong()
        set(`value`) {
            maxUniformBufferBindingSizeHandle.set(this.`$mem`, 0L, value.toLong())
        }

    public var maxStorageBufferBindingSize: uint64_t
        get() = (maxStorageBufferBindingSizeHandle.get(this.`$mem`, 0L) as Long).toULong()
        set(`value`) {
            maxStorageBufferBindingSizeHandle.set(this.`$mem`, 0L, value.toLong())
        }

    public var minUniformBufferOffsetAlignment: uint32_t
        get() = (minUniformBufferOffsetAlignmentHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            minUniformBufferOffsetAlignmentHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var minStorageBufferOffsetAlignment: uint32_t
        get() = (minStorageBufferOffsetAlignmentHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            minStorageBufferOffsetAlignmentHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var maxVertexBuffers: uint32_t
        get() = (maxVertexBuffersHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            maxVertexBuffersHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var maxBufferSize: uint64_t
        get() = (maxBufferSizeHandle.get(this.`$mem`, 0L) as Long).toULong()
        set(`value`) {
            maxBufferSizeHandle.set(this.`$mem`, 0L, value.toLong())
        }

    public var maxVertexAttributes: uint32_t
        get() = (maxVertexAttributesHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            maxVertexAttributesHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var maxVertexBufferArrayStride: uint32_t
        get() = (maxVertexBufferArrayStrideHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            maxVertexBufferArrayStrideHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var maxInterStageShaderComponents: uint32_t
        get() = (maxInterStageShaderComponentsHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            maxInterStageShaderComponentsHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var maxInterStageShaderVariables: uint32_t
        get() = (maxInterStageShaderVariablesHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            maxInterStageShaderVariablesHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var maxColorAttachments: uint32_t
        get() = (maxColorAttachmentsHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            maxColorAttachmentsHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var maxColorAttachmentBytesPerSample: uint32_t
        get() = (maxColorAttachmentBytesPerSampleHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            maxColorAttachmentBytesPerSampleHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var maxComputeWorkgroupStorageSize: uint32_t
        get() = (maxComputeWorkgroupStorageSizeHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            maxComputeWorkgroupStorageSizeHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var maxComputeInvocationsPerWorkgroup: uint32_t
        get() = (maxComputeInvocationsPerWorkgroupHandle.get(this.`$mem`, 0L) as
                Int).toUInt()
        set(`value`) {
            maxComputeInvocationsPerWorkgroupHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var maxComputeWorkgroupSizeX: uint32_t
        get() = (maxComputeWorkgroupSizeXHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            maxComputeWorkgroupSizeXHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var maxComputeWorkgroupSizeY: uint32_t
        get() = (maxComputeWorkgroupSizeYHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            maxComputeWorkgroupSizeYHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var maxComputeWorkgroupSizeZ: uint32_t
        get() = (maxComputeWorkgroupSizeZHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            maxComputeWorkgroupSizeZHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public var maxComputeWorkgroupsPerDimension: uint32_t
        get() = (maxComputeWorkgroupsPerDimensionHandle.get(this.`$mem`, 0L) as Int).toUInt()
        set(`value`) {
            maxComputeWorkgroupsPerDimensionHandle.set(this.`$mem`, 0L, value.toInt())
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            ValueLayout.JAVA_INT.withName("maxTextureDimension1D"),
            ValueLayout.JAVA_INT.withName("maxTextureDimension2D"),
            ValueLayout.JAVA_INT.withName("maxTextureDimension3D"),
            ValueLayout.JAVA_INT.withName("maxTextureArrayLayers"),
            ValueLayout.JAVA_INT.withName("maxBindGroups"),
            ValueLayout.JAVA_INT.withName("maxBindGroupsPlusVertexBuffers"),
            ValueLayout.JAVA_INT.withName("maxBindingsPerBindGroup"),
            ValueLayout.JAVA_INT.withName("maxDynamicUniformBuffersPerPipelineLayout"),
            ValueLayout.JAVA_INT.withName("maxDynamicStorageBuffersPerPipelineLayout"),
            ValueLayout.JAVA_INT.withName("maxSampledTexturesPerShaderStage"),
            ValueLayout.JAVA_INT.withName("maxSamplersPerShaderStage"),
            ValueLayout.JAVA_INT.withName("maxStorageBuffersPerShaderStage"),
            ValueLayout.JAVA_INT.withName("maxStorageTexturesPerShaderStage"),
            ValueLayout.JAVA_INT.withName("maxUniformBuffersPerShaderStage"),
            ValueLayout.JAVA_LONG.withName("maxUniformBufferBindingSize"),
            ValueLayout.JAVA_LONG.withName("maxStorageBufferBindingSize"),
            ValueLayout.JAVA_INT.withName("minUniformBufferOffsetAlignment"),
            ValueLayout.JAVA_INT.withName("minStorageBufferOffsetAlignment"),
            ValueLayout.JAVA_INT.withName("maxVertexBuffers"),
            MemoryLayout.paddingLayout(4),
            ValueLayout.JAVA_LONG.withName("maxBufferSize"),
            ValueLayout.JAVA_INT.withName("maxVertexAttributes"),
            ValueLayout.JAVA_INT.withName("maxVertexBufferArrayStride"),
            ValueLayout.JAVA_INT.withName("maxInterStageShaderComponents"),
            ValueLayout.JAVA_INT.withName("maxInterStageShaderVariables"),
            ValueLayout.JAVA_INT.withName("maxColorAttachments"),
            ValueLayout.JAVA_INT.withName("maxColorAttachmentBytesPerSample"),
            ValueLayout.JAVA_INT.withName("maxComputeWorkgroupStorageSize"),
            ValueLayout.JAVA_INT.withName("maxComputeInvocationsPerWorkgroup"),
            ValueLayout.JAVA_INT.withName("maxComputeWorkgroupSizeX"),
            ValueLayout.JAVA_INT.withName("maxComputeWorkgroupSizeY"),
            ValueLayout.JAVA_INT.withName("maxComputeWorkgroupSizeZ"),
            ValueLayout.JAVA_INT.withName("maxComputeWorkgroupsPerDimension"),
        ).withName("WGPULimits")

        @JvmField
        public val maxTextureDimension1DHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("maxTextureDimension1D"))

        @JvmField
        public val maxTextureDimension2DHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("maxTextureDimension2D"))

        @JvmField
        public val maxTextureDimension3DHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("maxTextureDimension3D"))

        @JvmField
        public val maxTextureArrayLayersHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("maxTextureArrayLayers"))

        @JvmField
        public val maxBindGroupsHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("maxBindGroups"))

        @JvmField
        public val maxBindGroupsPlusVertexBuffersHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("maxBindGroupsPlusVertexBuffers"))

        @JvmField
        public val maxBindingsPerBindGroupHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("maxBindingsPerBindGroup"))

        @JvmField
        public val maxDynamicUniformBuffersPerPipelineLayoutHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("maxDynamicUniformBuffersPerPipelineLayout"))

        @JvmField
        public val maxDynamicStorageBuffersPerPipelineLayoutHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("maxDynamicStorageBuffersPerPipelineLayout"))

        @JvmField
        public val maxSampledTexturesPerShaderStageHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("maxSampledTexturesPerShaderStage"))

        @JvmField
        public val maxSamplersPerShaderStageHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("maxSamplersPerShaderStage"))

        @JvmField
        public val maxStorageBuffersPerShaderStageHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("maxStorageBuffersPerShaderStage"))

        @JvmField
        public val maxStorageTexturesPerShaderStageHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("maxStorageTexturesPerShaderStage"))

        @JvmField
        public val maxUniformBuffersPerShaderStageHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("maxUniformBuffersPerShaderStage"))

        @JvmField
        public val maxUniformBufferBindingSizeHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("maxUniformBufferBindingSize"))

        @JvmField
        public val maxStorageBufferBindingSizeHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("maxStorageBufferBindingSize"))

        @JvmField
        public val minUniformBufferOffsetAlignmentHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("minUniformBufferOffsetAlignment"))

        @JvmField
        public val minStorageBufferOffsetAlignmentHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("minStorageBufferOffsetAlignment"))

        @JvmField
        public val maxVertexBuffersHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("maxVertexBuffers"))

        @JvmField
        public val maxBufferSizeHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("maxBufferSize"))

        @JvmField
        public val maxVertexAttributesHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("maxVertexAttributes"))

        @JvmField
        public val maxVertexBufferArrayStrideHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("maxVertexBufferArrayStride"))

        @JvmField
        public val maxInterStageShaderComponentsHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("maxInterStageShaderComponents"))

        @JvmField
        public val maxInterStageShaderVariablesHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("maxInterStageShaderVariables"))

        @JvmField
        public val maxColorAttachmentsHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("maxColorAttachments"))

        @JvmField
        public val maxColorAttachmentBytesPerSampleHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("maxColorAttachmentBytesPerSample"))

        @JvmField
        public val maxComputeWorkgroupStorageSizeHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("maxComputeWorkgroupStorageSize"))

        @JvmField
        public val maxComputeInvocationsPerWorkgroupHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("maxComputeInvocationsPerWorkgroup"))

        @JvmField
        public val maxComputeWorkgroupSizeXHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("maxComputeWorkgroupSizeX"))

        @JvmField
        public val maxComputeWorkgroupSizeYHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("maxComputeWorkgroupSizeY"))

        @JvmField
        public val maxComputeWorkgroupSizeZHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("maxComputeWorkgroupSizeZ"))

        @JvmField
        public val maxComputeWorkgroupsPerDimensionHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("maxComputeWorkgroupsPerDimension"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPULimits =
            WGPULimits(alloc.allocate(layout))
    }
}
