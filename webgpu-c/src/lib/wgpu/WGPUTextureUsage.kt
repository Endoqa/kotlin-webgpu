package lib.wgpu

/**
 * TODO
 */
public object WGPUTextureUsage {
    /**
     * TODO
     */
    public const val None: WGPUFlags = 0x0000000000000000u

    /**
     * TODO
     */
    public const val CopySrc: WGPUFlags = 0x0000000000000001u

    /**
     * TODO
     */
    public const val CopyDst: WGPUFlags = 0x0000000000000002u

    /**
     * TODO
     */
    public const val TextureBinding: WGPUFlags = 0x0000000000000004u

    /**
     * TODO
     */
    public const val StorageBinding: WGPUFlags = 0x0000000000000008u

    /**
     * TODO
     */
    public const val RenderAttachment: WGPUFlags = 0x0000000000000010u
}
