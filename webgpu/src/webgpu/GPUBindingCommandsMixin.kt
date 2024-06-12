package webgpu


interface GPUBindingCommandsMixin {

    fun setBindGroup(index: GPUIndex32, bindGroup: GPUBindGroup?, dynamicOffsets: UIntArray? = null)

    fun setBindGroup(
        index: GPUIndex32,
        bindGroup: GPUBindGroup?,
        dynamicOffsetsData: UIntArray,
        dynamicOffsetsDataStart: GPUSize64,
        dynamicOffsetsDataLength: GPUSize32
    ) {
        // slice from array
        val offsets = dynamicOffsetsData.copyOfRange(dynamicOffsetsDataStart.toInt(), dynamicOffsetsDataLength.toInt())
        setBindGroup(index, bindGroup, offsets)
    }

}