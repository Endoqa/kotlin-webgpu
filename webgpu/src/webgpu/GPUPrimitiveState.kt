package webgpu

import Converter
import webgpu.c.WGPUPrimitiveDepthClipControl
import webgpu.c.WGPUPrimitiveState
import webgpu.c.WGPUSType
import java.lang.foreign.Arena


data class GPUPrimitiveState(
    val topology: GPUPrimitiveTopology = GPUPrimitiveTopology.TriangleList,
    val stripIndexFormat: GPUIndexFormat = GPUIndexFormat.Undefined,
    val frontFace: GPUFrontFace = GPUFrontFace.CCW,
    val cullMode: GPUCullMode = GPUCullMode.None,
    val unclippedDepth: Boolean = false,
) {
    companion object {
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
