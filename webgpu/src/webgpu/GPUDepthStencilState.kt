package webgpu

import Converter
import webgpu.c.WGPUDepthStencilState
import java.lang.foreign.Arena

data class GPUDepthStencilState(
    val format: GPUTextureFormat,
    val depthWriteEnabled: Boolean = false,
    val depthCompare: GPUCompareFunction = GPUCompareFunction.Undefined,
    val stencilFront: GPUStencilFaceState = GPUStencilFaceState(),
    val stencilBack: GPUStencilFaceState = GPUStencilFaceState(),
    val stencilReadMask: GPUStencilValue = 0xFFFFFFFFu,
    val stencilWriteMask: GPUStencilValue = 0xFFFFFFFFu,
    val depthBias: GPUDepthBias = 0,
    val depthBiasSlopeScale: Float = 0f,
    val depthBiasClamp: Float = 0f,
) {
    companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPUDepthStencilState, native: WGPUDepthStencilState) {
            native.format = interop.format
            native.depthWriteEnabled = Converter.convert(interop.depthWriteEnabled)
            native.depthCompare = interop.depthCompare
            GPUStencilFaceState.convert(interop.stencilFront, native.stencilFront)
            GPUStencilFaceState.convert(interop.stencilBack, native.stencilBack)
            native.stencilReadMask = interop.stencilReadMask
            native.stencilWriteMask = interop.stencilWriteMask
            native.depthBias = interop.depthBias
            native.depthBiasSlopeScale = interop.depthBiasSlopeScale
            native.depthBiasClamp = interop.depthBiasClamp
        }
    }
}
