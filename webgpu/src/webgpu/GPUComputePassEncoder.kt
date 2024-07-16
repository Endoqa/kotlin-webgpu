package webgpu

import webgpu.c.*
import java.lang.foreign.Arena
import java.lang.foreign.MemorySegment

class GPUComputePassEncoder(
    internal val encoder_: WGPUComputePassEncoder,
    internal val desc_: GPUComputePassDescriptor,
    internal val arena: Arena,
) : GPUCommandsMixin, GPUDebugCommandsMixin, GPUBindingCommandsMixin {

    fun setPipeline(pipeline: GPUComputePipeline) {
        wgpuComputePassEncoderSetPipeline(encoder_, pipeline.pipeline_)
    }

    fun dispatchWorkgroups(
        workgroupCountX: GPUSize32, workgroupCountY: GPUSize32 = 1u, workgroupCountZ: GPUSize32 = 1u
    ) {
        wgpuComputePassEncoderDispatchWorkgroups(
            encoder_, workgroupCountX, workgroupCountY, workgroupCountZ
        )
    }

    fun dispatchWorkgroupsIndirect(indirectBuffer: GPUBuffer, indirectOffset: GPUSize64) {
        wgpuComputePassEncoderDispatchWorkgroupsIndirect(
            encoder_, indirectBuffer.buffer_, indirectOffset
        )
    }


    override fun pushDebugGroup(c_str: MemorySegment) {
        wgpuComputePassEncoderPushDebugGroup(encoder_, c_str)
    }

    override fun popDebugGroup() {
        wgpuComputePassEncoderPopDebugGroup(encoder_)
    }

    override fun insertDebugMarker(c_str: MemorySegment) {
        wgpuComputePassEncoderInsertDebugMarker(encoder_, c_str)
    }

    override fun setBindGroup(
        index: GPUIndex32, bindGroup: GPUBindGroup?, dynamicOffsets: UIntArray?
    ) {
        if (dynamicOffsets.isNullOrEmpty()) {
            wgpuComputePassEncoderSetBindGroup(
                encoder_, index, bindGroup?.group_ ?: MemorySegment.NULL, 0uL, MemorySegment.NULL
            )
        } else {
            wgpuComputePassEncoderSetBindGroup(
                encoder_, index, bindGroup?.group_ ?: MemorySegment.NULL, dynamicOffsets.size.toULong(),
                MemorySegment.ofArray(dynamicOffsets.asIntArray())
            )
        }
    }


}