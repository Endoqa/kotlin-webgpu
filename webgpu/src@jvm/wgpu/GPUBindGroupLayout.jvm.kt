package wgpu

import lib.wgpu.WGPUBindGroupLayout

public actual class GPUBindGroupLayout(
    private val layout: WGPUBindGroupLayout
) : GPUObjectBase {
    actual override var label: String
        get() = TODO("Not yet implemented")
        set(value) {}

    public fun into(): WGPUBindGroupLayout = layout
}