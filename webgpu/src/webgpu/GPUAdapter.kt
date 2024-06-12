package webgpu

import Converter
import not
import java.lang.foreign.Arena
import java.lang.foreign.MemorySegment
import java.lang.foreign.ValueLayout

class GPUAdapter(
    internal val adapter_: WGPUAdapter,
    internal val arena: Arena,
) {


    fun requestDevice(descriptor: GPUDeviceDescriptor = GPUDeviceDescriptor()): GPUDevice {

        val desc = WGPUDeviceDescriptor.allocate(arena)
        Converter.convert(arena, descriptor.label) { desc.label = it }
        desc.requiredFeatureCount = Converter.convert(
            arena,
            { desc.requiredFeatures = it },
            descriptor.requiredFeatures,
            ValueLayout.JAVA_INT,
            { value, segment -> segment.setAtIndex(ValueLayout.JAVA_INT, 0L, value.value) }
        )
        Converter.convert(arena, descriptor.defaultQueue.label) { desc.defaultQueue.label = it }

        if (descriptor.requiredLimits != null) {
            val limit = WGPURequiredLimits.allocate(arena)
            limit.limits = descriptor.requiredLimits
            desc.requiredLimits = limit.`$mem`
        }

        var result: GPUDevice? = null

        val callback = webgpu.callback.WGPURequestDeviceCallback { status, device, message, _ ->
            when (status) {
                WGPURequestDeviceStatus.Success -> {
                    val errCallback = webgpu.callback.WGPUErrorCallback { type, errMsg, _ ->
                        val msg = if (!errMsg) {
                            "$type: Unknown error"
                        } else {
                            "$type: ${errMsg.getString(0)}"
                        }
                        System.err.println(msg)
                    }
                    wgpuDeviceSetUncapturedErrorCallback(
                        device,
                        errCallback.allocate(Arena.ofAuto()),
                        MemorySegment.NULL
                    )
                    result = (GPUDevice(device, descriptor, arena))
                }

                else -> {
//                    if (!message) {
//                        it.resumeWithException(IllegalStateException(status.toString()))
//                    } else {
//                        it.resumeWithException(IllegalStateException("$status: ${message.getString(0)}"))
//                    }
                }
            }
        }



        wgpuAdapterRequestDevice(
            adapter_,
            desc.`$mem`,
            callback.allocate(arena),
            MemorySegment.NULL
        )

        return result ?: throw IllegalStateException("Failed to request device")

    }

    fun _internalAdapter(): WGPUAdapter {
        return adapter_
    }

}