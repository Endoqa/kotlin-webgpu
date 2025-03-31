package wgpu

import lib.wgpu.WGPUCompilationMessage

public actual data class GPUCompilationMessage(
    public actual val message: String,
    public actual val type: GPUCompilationMessageType,
    public actual val lineNum: ULong,
    public actual val linePos: ULong,
    public actual val offset: ULong,
    public actual val length: ULong,
) {
    public constructor(message: WGPUCompilationMessage) : this(
        message = String.from(message.message),
        type = GPUCompilationMessageType.from(message.type),
        lineNum = message.lineNum,
        linePos = message.linePos,
        offset = message.offset,
        length = message.length,
    )
}
