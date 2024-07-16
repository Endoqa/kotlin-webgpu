package webgpu

interface GPUImageDataLayout {
    val offset: GPUSize64

    val bytesPerRow: GPUSize32

    val rowsPerImage: GPUSize32
}
