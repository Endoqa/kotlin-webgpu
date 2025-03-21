package wgpu

public abstract class GPURenderPassLayout(
    override var label: String = "",
    public open var colorFormats: List<GPUTextureFormat?>,
    public open var depthStencilFormat: GPUTextureFormat? = null,
    public open var sampleCount: GPUSize32 = 1U,
) : GPUObjectDescriptorBase(label = label)
