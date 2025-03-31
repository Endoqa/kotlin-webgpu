package wgpu

import lib.wgpu.*

public actual class GPUComputePassEncoder(
    private val encoder: WGPUComputePassEncoder,
) : GPUObjectBase, GPUCommandsMixin, GPUDebugCommandsMixin,
    GPUBindingCommandsMixin {
    actual override var label: String
        get() = TODO()
        set(value) {

        }

    actual override fun pushDebugGroup(groupLabel: String) {
        unsafeScope { wgpuComputePassEncoderPushDebugGroup(encoder, groupLabel.into()) }
    }

    actual override fun popDebugGroup() {
        wgpuComputePassEncoderPopDebugGroup(encoder)
    }

    actual override fun insertDebugMarker(markerLabel: String) {
        unsafeScope { wgpuComputePassEncoderInsertDebugMarker(encoder, markerLabel.into()) }
    }

    actual override fun setBindGroup(
        index: GPUIndex32,
        bindGroup: GPUBindGroup?,
        dynamicOffsets: List<GPUBufferDynamicOffset>,
    ) {
        TODO()
    }

    actual override fun setBindGroup(
        index: GPUIndex32,
        bindGroup: GPUBindGroup?,
        dynamicOffsetsData: NativeBuffer,
        dynamicOffsetsDataStart: GPUSize64,
        dynamicOffsetsDataLength: GPUSize32,
    ) {
        TODO()
    }

    public actual fun setPipeline(pipeline: GPUComputePipeline) {
        wgpuComputePassEncoderSetPipeline(encoder, pipeline.into())
    }

    public actual fun dispatchWorkgroups(
        workgroupCountX: GPUSize32,
        workgroupCountY: GPUSize32,
        workgroupCountZ: GPUSize32,
    ) {
        wgpuComputePassEncoderDispatchWorkgroups(encoder, workgroupCountX, workgroupCountY, workgroupCountZ)
    }

    public actual fun dispatchWorkgroupsIndirect(indirectBuffer: GPUBuffer, indirectOffset: GPUSize64) {
        wgpuComputePassEncoderDispatchWorkgroupsIndirect(encoder, indirectBuffer.into(), indirectOffset)
    }

    public actual fun end() {
        wgpuComputePassEncoderEnd(encoder)
    }

    public fun into(): WGPUComputePassEncoder = encoder
}