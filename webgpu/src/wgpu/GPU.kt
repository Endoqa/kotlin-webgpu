package wgpu

public expect class GPU {
    public val wgslLanguageFeatures: WGSLLanguageFeatures

    public suspend fun requestAdapter(options: GPURequestAdapterOptions = GPURequestAdapterOptions()): GPUAdapter?

    public fun getPreferredCanvasFormat(): GPUTextureFormat
}
