package wgpu

import lib.wgpu.WGPUCompositeAlphaMode
import lib.wgpu.WGPUPresentMode
import java.lang.foreign.ValueLayout

public typealias GPUPresentMode = WGPUPresentMode //todo, wrap? but it is jvm only, prob no need
public typealias GPUCompositeAlphaMode = WGPUCompositeAlphaMode

public data class GPUSurfaceCapabilities(
    val usages: ULong,
    val formats: List<GPUTextureFormat>,
    val presentModes: List<WGPUPresentMode>,
    val alphaModes: List<GPUCompositeAlphaMode>
) {


    public companion object {
        public fun from(src: lib.wgpu.WGPUSurfaceCapabilities): GPUSurfaceCapabilities = GPUSurfaceCapabilities(
            src.usages,
            List(src.formatCount.toInt()) {
                GPUTextureFormat.from(
                    GPUTextureFormatInterop.fromInt(src.formats.getAtIndex(ValueLayout.JAVA_INT, it.toLong()))
                )
            },
            List(src.presentModeCount.toInt()) {
                GPUPresentMode.fromInt(src.presentModes.getAtIndex(ValueLayout.JAVA_INT, it.toLong()))
            },
            List(src.alphaModeCount.toInt()) {
                GPUCompositeAlphaMode.fromInt(src.alphaModes.getAtIndex(ValueLayout.JAVA_INT, it.toLong()))
            }
        )
    }

}