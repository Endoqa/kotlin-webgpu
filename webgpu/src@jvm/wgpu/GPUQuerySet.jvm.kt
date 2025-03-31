package wgpu

import lib.wgpu.WGPUQuerySet
import lib.wgpu.wgpuQuerySetDestroy
import lib.wgpu.wgpuQuerySetGetCount
import lib.wgpu.wgpuQuerySetGetType

public actual class GPUQuerySet(
    private val set: WGPUQuerySet
) : GPUObjectBase {
    actual override var label: String
        get() = TODO()
        set(value) {

        }

    public actual val type: GPUQueryType get() = GPUQueryType.from(wgpuQuerySetGetType(set))

    public actual val count: GPUSize32Out get() = wgpuQuerySetGetCount(set)

    public actual fun destroy() {
        wgpuQuerySetDestroy(set)
    }

    public fun into(): WGPUQuerySet = set
}