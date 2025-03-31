package lib.wgpu

import lib.wgpu.WGPUColorWriteMask.Alpha
import lib.wgpu.WGPUColorWriteMask.Blue
import lib.wgpu.WGPUColorWriteMask.Green
import lib.wgpu.WGPUColorWriteMask.Red


/**
 * TODO
 */
public object WGPUColorWriteMask {
    /**
     * TODO
     */
    public const val None: WGPUFlags = 0x0000000000000000u

    /**
     * TODO
     */
    public const val Red: WGPUFlags = 0x0000000000000001u

    /**
     * TODO
     */
    public const val Green: WGPUFlags = 0x0000000000000002u

    /**
     * TODO
     */
    public const val Blue: WGPUFlags = 0x0000000000000004u

    /**
     * TODO
     */
    public const val Alpha: WGPUFlags = 0x0000000000000008u

    /**
     * TODO
     * [Red] | [Green] | [Blue] | [Alpha]
     */
    public const val All: WGPUFlags = 0x000000000000000Fu
}
