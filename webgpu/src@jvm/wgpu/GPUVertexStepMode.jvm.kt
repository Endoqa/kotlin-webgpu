package wgpu

import lib.wgpu.WGPUVertexStepMode

public typealias GPUVertexStepModeInterop = WGPUVertexStepMode

public actual enum class GPUVertexStepMode(
    internal val interop: GPUVertexStepModeInterop,
) {
    Vertex(GPUVertexStepModeInterop.Vertex),
    Instance(GPUVertexStepModeInterop.Instance),
    ;

    public fun into(): GPUVertexStepModeInterop = interop

    public companion object {
        public fun from(v: GPUVertexStepModeInterop): GPUVertexStepMode = when (v) {
            GPUVertexStepModeInterop.Vertex -> Vertex
            GPUVertexStepModeInterop.Instance -> Instance
            else -> error("Invalid GPUVertexStepMode: ${'$'}v")
        }
    }
}
