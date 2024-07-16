package webgpu

import webgpu.c.WGPUVertexAttribute
import java.lang.foreign.Arena

data class GPUVertexAttribute(
    val format: GPUVertexFormat,
    val offset: GPUSize64,
    val shaderLocation: GPUIndex32,
) {
    companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPUVertexAttribute, native: WGPUVertexAttribute) {
            native.format = interop.format
            native.offset = interop.offset
            native.shaderLocation = interop.shaderLocation

        }
    }
}
