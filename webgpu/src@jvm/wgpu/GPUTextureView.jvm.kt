package wgpu

import lib.wgpu.WGPUTextureView
import lib.wgpu.wgpuTextureViewSetLabel

public actual class GPUTextureView(
    private val view: WGPUTextureView
) : GPUBindingResource, GPUObjectBase {
    actual override var label: String
        get() = TODO("Not yet implemented")
        set(value) {
            unsafeScope { wgpuTextureViewSetLabel(view, value.into()) }
        }


    public fun into(): WGPUTextureView = view
}