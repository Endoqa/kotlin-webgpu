package wgpu

import lib.wgpu.WGPUSupportedFeatures
import java.lang.foreign.MemorySegment
import java.lang.foreign.ValueLayout

public fun GPUSupportedFeatures(
    action: (MemorySegment) -> Unit
): GPUSupportedFeatures {
    return unsafe { temp ->
        val features = WGPUSupportedFeatures.allocate(temp)
        action(features.`$mem`)
        List(features.featureCount.toInt()) {
            try {
                GPUFeatureName.from(
                    GPUFeatureNameInterop.fromInt(
                        features.features.getAtIndex(ValueLayout.JAVA_INT, it.toLong())
                    )
                )
            } catch (_: IllegalStateException) {
                // Ignore unknown features
                null
            }
        }.filterNotNull()
            .toSet()
    }
}