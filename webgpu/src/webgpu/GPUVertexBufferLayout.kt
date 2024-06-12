package webgpu

import Converter
import java.lang.foreign.Arena

public data class GPUVertexBufferLayout(
    public val arrayStride: GPUSize64,
    public val stepMode: GPUVertexStepMode = GPUVertexStepMode.Vertex,
    public val attributes: List<GPUVertexAttribute>,
) {
    public companion object {
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
