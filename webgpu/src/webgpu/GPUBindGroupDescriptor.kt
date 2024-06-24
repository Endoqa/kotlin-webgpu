package webgpu

import java.lang.foreign.Arena

public data class GPUBindGroupDescriptor(
    override val label: String = "",
    public val layout: GPUBindGroupLayout,
    public val entries: List<GPUBindGroupEntry>,
) : GPUObjectDescriptorBase
