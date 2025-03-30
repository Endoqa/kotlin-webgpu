package wgpu

import lib.wgpu.WGPUVertexStepMode

public typealias GPUVertexStepModeInterop = WGPUVertexStepMode

public actual enum class GPUVertexStepMode(
    internal val interop: GPUVertexStepModeInterop,
) {
    Vertex(GPUVertexStepModeInterop.Vertex),
    Instance(GPUVertexStepModeInterop.Instance),
    ;

    public fun into(`out`: GPUVertexStepModeInterop): GPUVertexStepModeInterop = interop
}
