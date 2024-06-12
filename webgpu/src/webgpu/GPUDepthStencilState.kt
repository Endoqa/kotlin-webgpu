package webgpu

import Converter
import java.lang.foreign.Arena

public data class GPUDepthStencilState(
    public val format: GPUTextureFormat,
    public val depthWriteEnabled: Boolean = false,
    public val depthCompare: GPUCompareFunction = GPUCompareFunction.Undefined,
    public val stencilFront: GPUStencilFaceState = GPUStencilFaceState(),
    public val stencilBack: GPUStencilFaceState = GPUStencilFaceState(),
    public val stencilReadMask: GPUStencilValue = 0xFFFFFFFFu,
    public val stencilWriteMask: GPUStencilValue = 0xFFFFFFFFu,
    public val depthBias: GPUDepthBias = 0,
    public val depthBiasSlopeScale: Float = 0f,
    public val depthBiasClamp: Float = 0f,
) {
    public companion object {
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
