package wgpu

/**
 * @param type - Indicates the required type of a sampler bound to this bindings.
 */
public data class GPUSamplerBindingLayout(
    public var type: GPUSamplerBindingType = GPUSamplerBindingType.Filtering,
)
