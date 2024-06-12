package webgpu

public interface GPUImageDataLayout {
    public val offset: GPUSize64

    public val bytesPerRow: GPUSize32

    public val rowsPerImage: GPUSize32
}
