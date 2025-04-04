package wgpu

import lib.wgpu.WGPUBindGroup
import lib.wgpu.wgpuBindGroupSetLabel

public actual class GPUBindGroup(
    private val group: WGPUBindGroup
) : GPUObjectBase {
    actual override var label: String
        get() = TODO()
        set(value) {
            unsafeScope { wgpuBindGroupSetLabel(group, value.into()) }
        }

    public fun into(): WGPUBindGroup = group
}