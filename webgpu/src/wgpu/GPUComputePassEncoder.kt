package wgpu

public expect class GPUComputePassEncoder : GPUObjectBase, GPUCommandsMixin, GPUDebugCommandsMixin,
    GPUBindingCommandsMixin {
    override var label: String

    override fun pushDebugGroup(groupLabel: String)

    override fun popDebugGroup()

    override fun insertDebugMarker(markerLabel: String)

    override fun setBindGroup(
        index: GPUIndex32,
        bindGroup: GPUBindGroup?,
        dynamicOffsets: List<GPUBufferDynamicOffset>,
    )

    override fun setBindGroup(
        index: GPUIndex32,
        bindGroup: GPUBindGroup?,
        dynamicOffsetsData: NativeBuffer,
        dynamicOffsetsDataStart: GPUSize64,
        dynamicOffsetsDataLength: GPUSize32,
    )

    public fun setPipeline(pipeline: GPUComputePipeline)

    public fun dispatchWorkgroups(
        workgroupCountX: GPUSize32,
        workgroupCountY: GPUSize32 = 1U,
        workgroupCountZ: GPUSize32 = 1U,
    )

    public fun dispatchWorkgroupsIndirect(indirectBuffer: GPUBuffer, indirectOffset: GPUSize64)

    public fun end()
}
