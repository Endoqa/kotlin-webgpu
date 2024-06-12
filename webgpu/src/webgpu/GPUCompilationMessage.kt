package webgpu

data class GPUCompilationMessage(
    val message: String,
    val type: GPUCompilationMessageType,
    val lineNum: uint64_t,
    val linePos: uint64_t,
    val offset: uint64_t,
    val length: uint64_t,
)