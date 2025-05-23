package wgpu

/**
 * @param layout - A [wgpu.GPUPipelineLayout] that the [wgpu.GPUShaderModule] may be used with in a future
 * [wgpu.GPUDevice.createComputePipeline] or [wgpu.GPUDevice.createRenderPipeline] call.
 * If set to {{GPUAutoLayoutMode/"auto"}} the layout will be the [$default pipeline layout$]
 * for the entry point associated with this hint will be used.
 */
public data class GPUShaderModuleCompilationHint(
    public var entryPoint: String,
    public var layout: GPUPipelineLayout? = null,
)
