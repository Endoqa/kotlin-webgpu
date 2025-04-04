package wgpu

import lib.wgpu.WGPUCommandBuffer
import lib.wgpu.wgpuCommandBufferSetLabel

public actual class GPUCommandBuffer(
    private val cmdBuffer: WGPUCommandBuffer
) : GPUObjectBase {
    actual override var label: String
        get() = TODO("Not yet implemented")
        set(value) {
            unsafeScope { wgpuCommandBufferSetLabel(cmdBuffer, value.into()) }
        }

    public fun into(): WGPUCommandBuffer = cmdBuffer
}
