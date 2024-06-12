package webgpu

import Converter
import java.lang.foreign.Arena

public data class GPUVertexState(
    override val module: GPUShaderModule,
    override val entryPoint: String? = null,
    override val constants: MutableMap<String, GPUPipelineConstantValue>? = null,
    public val buffers: List<GPUVertexBufferLayout> = emptyList(),
) : GPUProgrammableStage {
    public companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPUVertexState, native: WGPUVertexState) {
            native.module = interop.module.module_
            Converter.convert(this@Arena, interop.entryPoint) { native.entryPoint = it }

            if (interop.constants != null) {
                native.constantCount = Converter.convert(
                    this@Arena,
                    { native.constants = it },
                    interop.constants.entries,
                    WGPUConstantEntry.layout,
                    { constant, mem ->
                        val entry = WGPUConstantEntry(mem)
                        Converter.convert(this@Arena, constant.key) { entry.key = it }
                        entry.value = constant.value
                    }
                )
            }

            native.bufferCount = Converter.convert(
                this@Arena,
                { native.buffers = it },
                interop.buffers,
                WGPUVertexBufferLayout.layout,
                { buffer, nativeBuffer ->
                    GPUVertexBufferLayout.convert(buffer, WGPUVertexBufferLayout(nativeBuffer))
                }
            )


        }
    }
}
