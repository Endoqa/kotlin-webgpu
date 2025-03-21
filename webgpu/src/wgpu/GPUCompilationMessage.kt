package wgpu

public expect class GPUCompilationMessage {
    public val message: String

    public val type: GPUCompilationMessageType

    public val lineNum: ULong

    public val linePos: ULong

    public val offset: ULong

    public val length: ULong
}
