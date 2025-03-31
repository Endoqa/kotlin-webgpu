package wgpu

import lib.wgpu.WGPUAdapterInfo
import lib.wgpu.WGPUAdapterType
import lib.wgpu.WGPUStatus
import java.lang.foreign.MemorySegment

public actual data class GPUAdapterInfo(
    actual val vendor: String,
    actual val architecture: String,
    actual val device: String,
    actual val description: String,
    actual val subgroupMinSize: UInt,
    actual val subgroupMaxSize: UInt,
    actual val isFallbackAdapter: Boolean,
) {


    public companion object {
        public fun from(func: (MemorySegment) -> WGPUStatus): GPUAdapterInfo {
            unsafe { temp ->
                val info = WGPUAdapterInfo.allocate(temp)
                val status = func(info.`$mem`)
                when (status) {
                    WGPUStatus.Success -> {}
                    else -> error("Failed to get info for adapter. Status: $status")
                }

                return GPUAdapterInfo(
                    vendor = String.from(info.vendor),
                    architecture = String.from(info.architecture),
                    device = String.from(info.device),
                    description = String.from(info.description),
                    subgroupMinSize = info.subgroupMinSize,
                    subgroupMaxSize = info.subgroupMaxSize,
                    isFallbackAdapter = info.adapterType == WGPUAdapterType.CPU,
                )
            }
        }
    }


}