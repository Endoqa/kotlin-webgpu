package wgpu

public expect class GPUPipelineError : Exception {
    public val reason: GPUPipelineErrorReason

    public constructor(message: String = "", options: GPUPipelineErrorInit)
}
