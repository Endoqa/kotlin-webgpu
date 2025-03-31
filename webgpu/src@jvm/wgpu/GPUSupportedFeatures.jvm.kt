package wgpu

import lib.wgpu.WGPUSupportedFeatures
import java.lang.foreign.MemorySegment
import java.lang.foreign.ValueLayout

public fun GPUSupportedFeatures(
    action: (MemorySegment) -> Unit
): GPUSupportedFeatures {
    return unsafe { temp ->
        val featuresPtr = temp.allocate(ValueLayout.ADDRESS)
        action(featuresPtr)
        val features = WGPUSupportedFeatures(featuresPtr)

        List(features.featureCount.toInt()) {
            features.features.getAtIndex(ValueLayout.ADDRESS, it.toLong()).getString(0)
        }.toSet()
    }
}