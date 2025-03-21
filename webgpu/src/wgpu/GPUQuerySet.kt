package wgpu

public expect class GPUQuerySet : GPUObjectBase {
    override var label: String

    public val type: GPUQueryType

    public val count: GPUSize32Out

    public fun destroy()
}
