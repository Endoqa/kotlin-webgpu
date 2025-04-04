package wgpu

import lib.wgpu.WGPURenderBundle
import lib.wgpu.wgpuRenderBundleSetLabel

public actual class GPURenderBundle(
    private val renderBundle: WGPURenderBundle
) : GPUObjectBase {
    actual override var label: String
        get() = TODO()
        set(value) {
            unsafeScope { wgpuRenderBundleSetLabel(renderBundle, value.into()) }
        }

    public fun into(): WGPURenderBundle = renderBundle
}
