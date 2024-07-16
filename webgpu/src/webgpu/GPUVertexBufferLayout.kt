package webgpu

import Converter
import webgpu.c.WGPUVertexAttribute
import webgpu.c.WGPUVertexBufferLayout
import java.lang.foreign.Arena

data class GPUVertexBufferLayout(
    val arrayStride: GPUSize64,
    val stepMode: GPUVertexStepMode = GPUVertexStepMode.Vertex,
    val attributes: List<GPUVertexAttribute>,
) {
    companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPUVertexBufferLayout, native: WGPUVertexBufferLayout) {
            native.arrayStride = interop.arrayStride
            native.stepMode = interop.stepMode

            native.attributeCount = Converter.convert(
                this@Arena,
                { native.attributes = it },
                interop.attributes,
                WGPUVertexAttribute.layout,
            ) { attribute, nativeAttribute ->
                GPUVertexAttribute.convert(attribute, WGPUVertexAttribute(nativeAttribute))
            }.toULong()
        }
    }
}
