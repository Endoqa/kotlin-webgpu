package wgpu

import lib.wgpu.WGPUTextureView

public actual class GPUTextureView(
    private val view: WGPUTextureView
) : GPUBindingResource, GPUObjectBase {
    actual override var label: String
        get() = TODO("Not yet implemented")
        set(value) {}


    public fun into(): WGPUTextureView = view
}