package wgpu

import lib.wgpu.WGPUBindGroup

public actual class GPUBindGroup(
    private val group: WGPUBindGroup
) : GPUObjectBase {
    actual override var label: String
        get() = TODO("Not yet implemented")
        set(value) {}

    public fun into(): WGPUBindGroup = group
}