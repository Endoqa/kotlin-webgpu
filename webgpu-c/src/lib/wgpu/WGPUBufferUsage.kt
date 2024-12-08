package lib.wgpu

/**
 * TODO
 */
public object WGPUBufferUsage {
    /**
     * TODO
     */
    public const val None: WGPUFlags = 0x0000000000000000u

    /**
     * TODO
     */
    public const val MapRead: WGPUFlags = 0x0000000000000001u

    /**
     * TODO
     */
    public const val MapWrite: WGPUFlags = 0x0000000000000002u

    /**
     * TODO
     */
    public const val CopySrc: WGPUFlags = 0x0000000000000004u

    /**
     * TODO
     */
    public const val CopyDst: WGPUFlags = 0x0000000000000008u

    /**
     * TODO
     */
    public const val Index: WGPUFlags = 0x0000000000000010u

    /**
     * TODO
     */
    public const val Vertex: WGPUFlags = 0x0000000000000020u

    /**
     * TODO
     */
    public const val Uniform: WGPUFlags = 0x0000000000000040u

    /**
     * TODO
     */
    public const val Storage: WGPUFlags = 0x0000000000000080u

    /**
     * TODO
     */
    public const val Indirect: WGPUFlags = 0x0000000000000100u

    /**
     * TODO
     */
    public const val QueryResolve: WGPUFlags = 0x0000000000000200u
}
