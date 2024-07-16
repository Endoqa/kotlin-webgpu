package webgpu

data class GPURequestAdapterOptions(
    val powerPreference: GPUPowerPreference = GPUPowerPreference.Undefined,
    val forceFallbackAdapter: Boolean = false,
)