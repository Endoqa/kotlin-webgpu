package wgpu

/**
 * @param type - Indicates the type required for buffers bound to this bindings.
 * @param hasDynamicOffset - Indicates whether this binding requires a dynamic offset.
 * @param minBindingSize - Indicates the minimum [wgpu.GPUBufferBinding.size] of a buffer binding used with this bind point.
 *
 * Bindings are always validated against this size in [wgpu.GPUDevice.createBindGroup].
 *
 * If this *is not* `0`, pipeline creation additionally [$validating shader binding|validates$]
 * that this value ≥ the minimum buffer binding size of the variable.
 *
 * If this *is* `0`, it is ignored by pipeline creation, and instead draw/dispatch commands
 * [$Validate encoder bind groups|validate$] that each binding in the [wgpu.GPUBindGroup]
 * satisfies the minimum buffer binding size of the variable.
 *
 * Note:
 * Similar execution-time validation is theoretically possible for other
 * binding-related fields specified for early validation, like
 * [wgpu.GPUTextureBindingLayout.sampleType] and [wgpu.GPUStorageTextureBindingLayout.format],
 * which currently can only be validated in pipeline creation.
 * However, such execution-time validation could be costly or unnecessarily complex, so it is
 * available only for [wgpu.GPUBufferBindingLayout.minBindingSize] which is expected to have the
 * most ergonomic impact.
 */
public data class GPUBufferBindingLayout(
    public var type: GPUBufferBindingType = GPUBufferBindingType.Uniform,
    public var hasDynamicOffset: Boolean = false,
    public var minBindingSize: GPUSize64 = 0UL,
)
