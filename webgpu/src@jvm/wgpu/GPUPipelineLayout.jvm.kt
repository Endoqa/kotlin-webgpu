package wgpu

import lib.wgpu.WGPUPipelineLayout
import lib.wgpu.wgpuPipelineLayoutSetLabel

public actual class GPUPipelineLayout(
    private val layout: WGPUPipelineLayout
) : GPUObjectBase {
    actual override var label: String
        get() = TODO("Not yet implemented")
        set(value) {
            unsafeScope { wgpuPipelineLayoutSetLabel(layout, value.into()) }
        }

    public fun into(): WGPUPipelineLayout = layout
}
