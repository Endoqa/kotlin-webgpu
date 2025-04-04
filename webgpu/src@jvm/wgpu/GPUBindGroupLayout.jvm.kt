package wgpu

import lib.wgpu.WGPUBindGroupLayout
import lib.wgpu.wgpuBindGroupLayoutSetLabel

public actual class GPUBindGroupLayout(
    private val layout: WGPUBindGroupLayout
) : GPUObjectBase {
    actual override var label: String
        get() = TODO("Not yet implemented")
        set(value) {
            unsafeScope { wgpuBindGroupLayoutSetLabel(layout, value.into()) }
        }

    public fun into(): WGPUBindGroupLayout = layout
}
