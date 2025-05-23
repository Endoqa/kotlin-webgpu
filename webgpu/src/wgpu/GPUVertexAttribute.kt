package wgpu

/**
 * @param format - The [wgpu.GPUVertexFormat] of the attribute.
 * @param offset - The offset, in bytes, from the beginning of the element to the data for the attribute.
 * @param shaderLocation - The numeric location associated with this attribute, which will correspond with a
 * <a href="https://gpuweb.github.io/gpuweb/wgsl/#input-output-locations">"@location" attribute</a>
 * declared in the [wgpu.GPURenderPipelineDescriptor.vertex].{{GPUProgrammableStage/module|module}}.
 */
public data class GPUVertexAttribute(
    public var format: GPUVertexFormat,
    public var offset: GPUSize64,
    public var shaderLocation: GPUIndex32,
)
