package wgpu

public actual class GPUPipelineError(
    public actual val reason: GPUPipelineErrorReason,
    message: String? = null,
) : Exception(message ?: "GPU pipeline error: $reason") {


    public actual constructor(message: String, options: GPUPipelineErrorInit) : this(options.reason, message)
}
