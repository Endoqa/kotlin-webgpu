package webgpu

import Converter
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

            if (interop.unclippedDepth) {
                val depthClip = WGPUPrimitiveDepthClipControl.allocate(this@Arena)
                depthClip.chain.sType = WGPUSType.PrimitiveDepthClipControl

                depthClip.unclippedDepth = Converter.convert(true) // todo: just use 1u

                native.nextInChain = depthClip.`$mem`
            }
        }
    }
}
