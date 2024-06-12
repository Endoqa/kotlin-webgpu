package webgpu

import java.lang.foreign.Arena

public data class GPUVertexAttribute(
    public val format: GPUVertexFormat,
    public val offset: GPUSize64,
    public val shaderLocation: GPUIndex32,
) {
    public companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPUVertexAttribute, native: WGPUVertexAttribute) {
            TODO()
        }
    }
}
