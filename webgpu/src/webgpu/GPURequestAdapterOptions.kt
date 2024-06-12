package webgpu

public data class GPURequestAdapterOptions(
    public val powerPreference: GPUPowerPreference = GPUPowerPreference.Undefined,
    public val forceFallbackAdapter: Boolean = false,
)