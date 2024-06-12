package webgpu

import java.lang.foreign.Arena

public data class GPUPrimitiveState(
    public val topology: GPUPrimitiveTopology = GPUPrimitiveTopology.TriangleList,
    public val stripIndexFormat: GPUIndexFormat = GPUIndexFormat.Undefined,
    public val frontFace: GPUFrontFace = GPUFrontFace.CCW,
    public val cullMode: GPUCullMode = GPUCullMode.None,
    public val unclippedDepth: Boolean = false,
) {
    public companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPUPrimitiveState, native: WGPUPrimitiveState) {
            native.topology = interop.topology
            native.stripIndexFormat = interop.stripIndexFormat
            native.frontFace = interop.frontFace
            native.cullMode = interop.cullMode
//            native.unclippedDepth = interop.unclippedDepth
        }
    }
}
