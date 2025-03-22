package wgpu

public object GPUBufferUsage {
    public const val MAP_READ: GPUFlagsConstant = 1U

    public const val MAP_WRITE: GPUFlagsConstant = 2U

    public const val COPY_SRC: GPUFlagsConstant = 4U

    public const val COPY_DST: GPUFlagsConstant = 8U

    public const val INDEX: GPUFlagsConstant = 16U

    public const val VERTEX: GPUFlagsConstant = 32U

    public const val UNIFORM: GPUFlagsConstant = 64U

    public const val STORAGE: GPUFlagsConstant = 128U

    public const val INDIRECT: GPUFlagsConstant = 256U

    public const val QUERY_RESOLVE: GPUFlagsConstant = 512U
}
