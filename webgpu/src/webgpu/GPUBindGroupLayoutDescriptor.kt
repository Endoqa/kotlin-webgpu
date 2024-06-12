package webgpu

import java.lang.foreign.Arena

public data class GPUBindGroupLayoutDescriptor(
    override val label: String = "",
    public val entries: List<GPUBindGroupLayoutEntry>,
) : GPUObjectDescriptorBase {
    public companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(
            interop: GPUBindGroupLayoutDescriptor,
            native: WGPUBindGroupLayoutDescriptor
        ) {
            TODO()
        }
    }
}
