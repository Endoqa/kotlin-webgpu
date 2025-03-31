package wgpu

import lib.wgpu.WGPUAdapterInfo
import lib.wgpu.WGPUAdapterType
import lib.wgpu.WGPUStatus
import java.lang.foreign.MemorySegment
import java.lang.foreign.ValueLayout

public actual data class GPUAdapterInfo(
    actual val vendor: String,
    actual val architecture: String,
    actual val device: String,
    actual val description: String,
    actual val subgroupMinSize: UInt,
    actual val subgroupMaxSize: UInt,
    actual val isFallbackAdapter: Boolean,
) {

    public constructor(func: (MemorySegment) -> WGPUStatus) : this(
        unsafe { temp ->
            val infoPtr = temp.allocate(ValueLayout.ADDRESS)
            when (val status = func(infoPtr)) {
                WGPUStatus.Success -> WGPUAdapterInfo(infoPtr)
                else -> error("Failed to get info for adapter. Status: $status")
            }
        }
    )


    public constructor(info: WGPUAdapterInfo) : this(
        vendor = String.from(info.vendor),
        architecture = String.from(info.architecture),
        device = String.from(info.device),
        description = String.from(info.description),
        subgroupMinSize = info.subgroupMinSize,
        subgroupMaxSize = info.subgroupMaxSize,
        isFallbackAdapter = info.adapterType == WGPUAdapterType.CPU,
    )

}