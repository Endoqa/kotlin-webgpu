package webgpu

import java.lang.foreign.Arena

public data class GPURenderBundleDescriptor(
    override val label: String = "",
) : GPUObjectDescriptorBase 