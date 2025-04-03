package wgpu

import lib.wgpu.Pointer
import lib.wgpu.WGPUSurfaceConfiguration
import java.lang.foreign.Arena
import java.lang.foreign.ValueLayout

public data class GPUSurfaceConfiguration(
    public var device: GPUDevice,
    public var format: GPUTextureFormat,
    public var usage: UInt,
    public var width: UInt,
    public var height: UInt,
    public var viewFormats: List<GPUTextureFormat>,
    public var alphaMode: GPUCompositeAlphaMode,
    public var presentMode: GPUPresentMode,
)


internal typealias NativeGPUSurfaceConfiguration = WGPUSurfaceConfiguration

context(Arena)
internal fun GPUSurfaceConfiguration.into(`out`: Pointer<NativeGPUSurfaceConfiguration>): NativeGPUSurfaceConfiguration = into()

context(Arena)
internal fun GPUSurfaceConfiguration.into(`out`: NativeGPUSurfaceConfiguration = NativeGPUSurfaceConfiguration.allocate(this@Arena)): NativeGPUSurfaceConfiguration {
    out.device = this.device.into()
    out.format = this.format.into()
    out.usage = this.usage.toULong()
    out.width = this.width
    out.height = this.height
    out.viewFormatCount = this.viewFormats.size.toULong()
    out.viewFormats = allocateFrom(ValueLayout.JAVA_INT, *this.viewFormats.map { it.interop.value }.toIntArray())
    out.alphaMode = this.alphaMode
    out.presentMode = this.presentMode
    return out
}