package wgpu

import lib.wgpu.*
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

public actual class GPUAdapter(
    private val adapter: WGPUAdapter
) {
    public actual val features: GPUSupportedFeatures by lazy {
        GPUSupportedFeatures { ptr -> wgpuAdapterGetFeatures(adapter, ptr) }
    }
    public actual val limits: GPUSupportedLimits by lazy {
        GPUSupportedLimits.from { ptr -> wgpuAdapterGetLimits(adapter, ptr) }
    }
    public actual val info: GPUAdapterInfo by lazy {
        GPUAdapterInfo.from { ptr -> wgpuAdapterGetInfo(adapter, ptr) }
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