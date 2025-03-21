package wgpu

public expect class GPUTexture : GPUObjectBase {
    override var label: String

    public val width: GPUIntegerCoordinateOut

    public val height: GPUIntegerCoordinateOut

    public val depthOrArrayLayers: GPUIntegerCoordinateOut

    public val mipLevelCount: GPUIntegerCoordinateOut

    public val sampleCount: GPUSize32Out

    public val dimension: GPUTextureDimension

    public val format: GPUTextureFormat

    public val usage: GPUFlagsConstant

    public fun createView(descriptor: GPUTextureViewDescriptor = GPUTextureViewDescriptor()): GPUTextureView

    public fun destroy()
}
