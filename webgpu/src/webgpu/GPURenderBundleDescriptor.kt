package webgpu

import java.lang.foreign.Arena

public data class GPURenderBundleDescriptor(
    override val label: String = "",
) : GPUObjectDescriptorBase {
    public companion object {
        context(Arena)
        @JvmStatic
        internal fun convert(interop: GPURenderBundleDescriptor, native: WGPURenderBundleDescriptor) {
            TODO()
        }
    }
}
