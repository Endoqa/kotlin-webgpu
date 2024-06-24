package webgpu

import Converter
import java.lang.foreign.Arena

public data class GPUProgrammableStageDescriptor(
    override val module: GPUShaderModule,
    override val entryPoint: String? = null,
    override val constants: MutableMap<String, GPUPipelineConstantValue>? = null,
) : GPUProgrammableStage {
    public companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPUProgrammableStageDescriptor, native: WGPUProgrammableStageDescriptor) {
            native.module = interop.module.module_
            Converter.convert(this@Arena, interop.entryPoint) { native.entryPoint = it }

            // skip constants for now

            if (!interop.constants.isNullOrEmpty()) {

                native.constantCount = Converter.convert(
                    this@Arena,
                    { native.constants = it },
                    interop.constants.entries,
                    WGPUConstantEntry.layout,
                    { (k, v), mem ->
                        val entry = WGPUConstantEntry(mem)
                        Converter.convert(this@Arena, k) { entry.key = it }
                        entry.value = v
                    }
                )


            }

        }
    }
}