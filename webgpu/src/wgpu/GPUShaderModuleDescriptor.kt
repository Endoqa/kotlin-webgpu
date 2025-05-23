package wgpu

/**
 * @param code - The <a href="https://gpuweb.github.io/gpuweb/wgsl/">WGSL</a> source code for the shader
 * module.
 * @param compilationHints - A list of [wgpu.GPUShaderModuleCompilationHint]s.
 *
 * Any hint provided by an application **should** contain information about one entry point of
 * a pipeline that will eventually be created from the entry point.
 *
 * Implementations **should** use any information present in the [wgpu.GPUShaderModuleCompilationHint]
 * to perform as much compilation as is possible within [wgpu.GPUDevice.createShaderModule].
 *
 * Aside from type-checking, these hints are not validated in any way.
 *
 * <div class="note" heading>
 *     Supplying information in [wgpu.GPUShaderModuleDescriptor.compilationHints] does not have any
 *     observable effect, other than performance. It may be detrimental to performance to
 *     provide hints for pipelines that never end up being created.
 *
 *     Because a single shader module can hold multiple entry points, and multiple pipelines
 *     can be created from a single shader module, it can be more performant for an
 *     implementation to do as much compilation as possible once in
 *     [wgpu.GPUDevice.createShaderModule] rather than multiple times in the multiple calls to
 *     [wgpu.GPUDevice.createComputePipeline] or [wgpu.GPUDevice.createRenderPipeline].
 *
 *     Hints are only applied to the entry points they explicitly name.
 *     Unlike {{GPUProgrammableStage/entryPoint|GPUProgrammableStage.entryPoint}},
 *     there is no default, even if only one entry point is present in the module.
 * </div>
 *
 * Note:
 * Hints are not validated in an observable way, but user agents **may** surface identifiable
 * errors (like unknown entry point names or incompatible pipeline layouts) to developers,
 * for example in the browser developer console.
 */
public data class GPUShaderModuleDescriptor(
    override var label: String = "",
    public var code: String,
    public var compilationHints: List<GPUShaderModuleCompilationHint> = listOf(),
) : GPUObjectDescriptorBase(label = label)
