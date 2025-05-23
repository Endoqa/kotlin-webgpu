package wgpu

/**
 * @param layout - The [wgpu.GPUBindGroupLayout] the entries of this bind group will conform to.
 * @param entries - A list of entries describing the resources to expose to the shader for each binding
 * described by the [wgpu.GPUBindGroupDescriptor.layout].
 */
public data class GPUBindGroupDescriptor(
    override var label: String = "",
    public var layout: GPUBindGroupLayout,
    public var entries: List<GPUBindGroupEntry>,
) : GPUObjectDescriptorBase(label = label)
