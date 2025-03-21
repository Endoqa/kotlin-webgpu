package wgpu

public expect class GPUAdapterInfo {
    public val vendor: String

    public val architecture: String

    public val device: String

    public val description: String

    public val subgroupMinSize: UInt

    public val subgroupMaxSize: UInt
}
