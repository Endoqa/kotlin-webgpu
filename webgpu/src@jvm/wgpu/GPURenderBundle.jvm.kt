package wgpu

import lib.wgpu.WGPURenderBundle

public actual class GPURenderBundle(
    private val renderBundle: WGPURenderBundle
) : GPUObjectBase {
    actual override var label: String
        get() = TODO()
        set(value) {}


    public fun into(): WGPURenderBundle = renderBundle

}