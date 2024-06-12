package webgpu

import Converter
import java.lang.foreign.Arena

public data class GPUComputePipelineDescriptor(
    override val label: String = "",
    override val layout: GPUPipelineLayout,
    public val compute: GPUProgrammableStageDescriptor,
) : GPUPipelineDescriptorBase {
    public companion object {
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
