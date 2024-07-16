package webgpu

import Converter
import webgpu.c.WGPUComputePipelineDescriptor
import java.lang.foreign.Arena

data class GPUComputePipelineDescriptor(
    override val label: String = "",
    override val layout: GPUPipelineLayout,
    val compute: GPUProgrammableStageDescriptor,
) : GPUPipelineDescriptorBase {
    companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(
            interop: GPUComputePipelineDescriptor,
            native: WGPUComputePipelineDescriptor
        ) {
            Converter.convert(this@Arena, interop.label) { native.label = it }
            native.layout = interop.layout.layout_
            GPUProgrammableStageDescriptor.convert(interop.compute, native.compute)
        }
    }
}
