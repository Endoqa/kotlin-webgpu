package webgpu

import Converter
import webgpu.c.WGPUDepthStencilState
import webgpu.c.WGPUFragmentState
import webgpu.c.WGPURenderPipelineDescriptor
import java.lang.foreign.Arena
import java.lang.foreign.MemorySegment

data class GPURenderPipelineDescriptor(
    override val label: String = "",
    override val layout: GPUPipelineLayout? = null, // null for auto layout
    val vertex: GPUVertexState,
    val primitive: GPUPrimitiveState = GPUPrimitiveState(),
    val depthStencil: GPUDepthStencilState? = null,
    val multisample: GPUMultisampleState = GPUMultisampleState(),
    val fragment: GPUFragmentState? = null,
) : GPUPipelineDescriptorBase {
    companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(
            interop: GPURenderPipelineDescriptor,
            native: WGPURenderPipelineDescriptor
        ) {
            Converter.convert(this@Arena, interop.label) { native.label = it }
            native.layout = interop.layout?.layout_ ?: MemorySegment.NULL
            GPUVertexState.convert(interop.vertex, native.vertex)
            GPUPrimitiveState.convert(interop.primitive, native.primitive)

            if (interop.depthStencil != null) {
                val depthStencil = WGPUDepthStencilState.allocate(this@Arena)
                GPUDepthStencilState.convert(interop.depthStencil, depthStencil)
                native.depthStencil = depthStencil.`$mem`
            }

            GPUMultisampleState.convert(interop.multisample, native.multisample)

            if (interop.fragment != null) {
                val fragment = WGPUFragmentState.allocate(this@Arena)
                GPUFragmentState.convert(interop.fragment, fragment)
                native.fragment = fragment.`$mem`
            }
        }
    }
}
