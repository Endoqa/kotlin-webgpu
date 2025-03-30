package wgpu

import lib.wgpu.WGPUCommandBuffer

public actual class GPUCommandBuffer(
    private val cmdBuffer: WGPUCommandBuffer
) : GPUObjectBase {
    actual override var label: String
        get() = TODO("Not yet implemented")
        set(value) {}


    public fun into(): WGPUCommandBuffer = cmdBuffer
}