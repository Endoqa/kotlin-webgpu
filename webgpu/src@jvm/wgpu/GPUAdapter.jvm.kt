package wgpu

import lib.wgpu.*
import java.lang.foreign.ValueLayout
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

public actual class GPUAdapter(
    private val adapter: WGPUAdapter
) {
    public actual val features: GPUSupportedFeatures by lazy {
        unsafe { temp ->
            val featuresPtr = temp.allocate(ValueLayout.ADDRESS)
            wgpuAdapterGetFeatures(adapter, featuresPtr)
            val features = WGPUSupportedFeatures(featuresPtr)

            List(features.featureCount.toInt()) {
                features.features.getAtIndex(ValueLayout.ADDRESS, it.toLong()).getString(0)
            }.toSet()
        }
    }
    public actual val limits: GPUSupportedLimits by lazy {
        unsafe { temp ->
            val limitsPtr = temp.allocate(ValueLayout.ADDRESS)
            val limits = when (val status = wgpuAdapterGetLimits(adapter, limitsPtr)) {
                WGPUStatus.Success -> WGPULimits(limitsPtr)
                else -> error("Failed to get limits for adapter. Status: $status")
            }
            GPUSupportedLimits(limits)
        }
    }
    public actual val info: GPUAdapterInfo by lazy {
        unsafe { temp ->
            val infoPtr = temp.allocate(ValueLayout.ADDRESS)
            val info = when (val status = wgpuAdapterGetInfo(adapter, infoPtr)) {
                WGPUStatus.Success -> WGPUAdapterInfo(infoPtr)
                else -> error("Failed to get info for adapter. Status: $status")
            }
            GPUAdapterInfo(info)
        }
    }

    // TODO 1
    // The adapter becomes invalid after the first successful requestDevice and all subsequent
    // requestDevice calls will return an already lost device.
    public actual suspend fun requestDevice(descriptor: GPUDeviceDescriptor): GPUDevice {
        return unsafeScope {
            val desc = descriptor.into()

            suspendCoroutine<GPUDevice> { cont ->
                val cb = createRequestDeviceCallback { status, device, message, _, _ ->
                    when (status) {
                        WGPURequestDeviceStatus.Success -> cont.resume(GPUDevice(device))
                        else -> cont.resumeWithException(Exception(String.from(message)))
                    }
                }
                wgpuAdapterRequestDevice(adapter, desc.`$mem`, cb)
            }
        }
    }

    public fun into(): WGPUAdapter = adapter

}