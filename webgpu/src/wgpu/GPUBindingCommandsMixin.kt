package wgpu

public interface GPUBindingCommandsMixin {
    public fun setBindGroup(
        index: GPUIndex32,
        bindGroup: GPUBindGroup?,
        dynamicOffsets: List<GPUBufferDynamicOffset> = listOf(),
    )

    public fun setBindGroup(
        index: GPUIndex32,
        bindGroup: GPUBindGroup?,
        dynamicOffsetsData: NativeBuffer,
        dynamicOffsetsDataStart: GPUSize64,
        dynamicOffsetsDataLength: GPUSize32,
    )
}
