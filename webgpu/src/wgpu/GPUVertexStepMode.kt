package wgpu

import lib.wgpu.WGPUVertexStepMode

public enum class GPUVertexStepMode(
    public val interop: WGPUVertexStepMode,
) {
    Vertex(WGPUVertexStepMode.Vertex),
    Instance(WGPUVertexStepMode.Instance),
    ;
}
