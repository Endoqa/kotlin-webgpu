package webgpu

import Converter
import webgpu.c.*
import java.lang.foreign.Arena
import java.lang.foreign.ValueLayout
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class GPUAdapter(
    internal val adapter_: WGPUAdapter,
    internal val arena: Arena,
) {


    suspend fun requestDevice(descriptor: GPUDeviceDescriptor = GPUDeviceDescriptor()): GPUDevice {

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

        return Arena.ofConfined().use { temp ->
            suspendCoroutine<GPUDevice> { cont ->
                val callback = webgpu.c.callback.WGPURequestDeviceCallback2 { status, device, message, _, _ ->
                    when (status) {
                        WGPURequestDeviceStatus.Success -> {
                            //TODO: user defined error callback
//                            val errCallback = webgpu.c.callback.WGPUErrorCallback { type, errMsg, _ ->
//                                val msg = if (!errMsg) {
//                                    "$type: Unknown error"
//                                } else {
//                                    "$type: ${errMsg.getString(0)}"
//                                }
//                                System.err.println(msg)
//                            }
//                            wgpuDeviceSetUncapturedErrorCallback(
//                                device,
//                                errCallback.allocate(Arena.ofAuto()),
//                                MemorySegment.NULL
//                            )
                            cont.resume(GPUDevice(device, descriptor, arena))
                        }

                        else -> cont.resumeWithException(wgpuError(status, message))
                    }
                }

                val cb = WGPURequestDeviceCallbackInfo2.allocate(temp)
                cb.callback = callback.allocate(temp)
                cb.mode = WGPUCallbackMode.AllowSpontaneous

                with(temp) {
                    wgpuAdapterRequestDevice2(
                        adapter_,
                        desc.`$mem`,
                        cb,
                    )
                }
            }
        }
    }

    fun _internalAdapter(): WGPUAdapter {
        return adapter_
    }

}