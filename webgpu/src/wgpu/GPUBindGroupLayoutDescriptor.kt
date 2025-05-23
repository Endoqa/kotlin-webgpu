package wgpu

/**
 * @param entries - A list of entries describing the shader resource bindings for a bind group.
 */
public data class GPUBindGroupLayoutDescriptor(
    override var label: String = "",
    public var entries: List<GPUBindGroupLayoutEntry>,
) : GPUObjectDescriptorBase(label = label)
