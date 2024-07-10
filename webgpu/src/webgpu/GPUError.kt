package webgpu

abstract class GPUError(message: String) : RuntimeException(message)


data class GPUValidationError(override val message: String) : GPUError(message)
data class GPUOutOfMemoryError(override val message: String) : GPUError(message)
data class GPUInternalError(override val message: String) : GPUError(message)