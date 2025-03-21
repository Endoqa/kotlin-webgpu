package wgpu

public data class GPURequestAdapterOptions(
    public var featureLevel: String = "core",
    public var powerPreference: GPUPowerPreference? = null,
    public var forceFallbackAdapter: Boolean = false,
    public var xrCompatible: Boolean = false,
)
