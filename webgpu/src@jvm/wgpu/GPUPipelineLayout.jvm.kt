package wgpu

import lib.wgpu.WGPUPipelineLayout

public actual class GPUPipelineLayout(
    private val layout: WGPUPipelineLayout
) : GPUObjectBase {
    actual override var label: String
        get() = TODO("Not yet implemented")
        set(value) {}

    public fun into(): WGPUPipelineLayout = layout
}