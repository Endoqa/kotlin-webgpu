package wgpu

import lib.wgpu.WGPUErrorType

public actual class GPUError(
    public val errorType: WGPUErrorType,
    actual override val message: String,
) : Error(message)