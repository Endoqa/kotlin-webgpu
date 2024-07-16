package webgpu

import webgpu.c.WGPUQuerySet
import webgpu.c.wgpuQuerySetDestroy
import webgpu.c.wgpuQuerySetGetCount
import webgpu.c.wgpuQuerySetGetType

class GPUQuerySet(
    internal val set_: WGPUQuerySet,
    internal val desc_: GPUQuerySetDescriptor,
) {

    val type: GPUQueryType get() = wgpuQuerySetGetType(set_)
    val count: GPUSize32 get() = wgpuQuerySetGetCount(set_)

    fun destroy() {
        wgpuQuerySetDestroy(set_)
    }

}