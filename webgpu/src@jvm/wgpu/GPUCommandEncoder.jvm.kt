package wgpu

import lib.wgpu.*

public actual class GPUCommandEncoder(
    private val encoder: WGPUCommandEncoder,
) : GPUObjectBase, GPUCommandsMixin, GPUDebugCommandsMixin {
    actual override var label: String
        get() = TODO()
        set(value) {
            TODO()
        }

    actual override fun pushDebugGroup(groupLabel: String) {
        unsafeScope {
            wgpuCommandEncoderPushDebugGroup(encoder, groupLabel.into())
        }
    }

    actual override fun popDebugGroup() {
        wgpuCommandEncoderPopDebugGroup(encoder)
    }


    actual override fun insertDebugMarker(markerLabel: String) {
        unsafeScope {
            wgpuCommandEncoderInsertDebugMarker(encoder, markerLabel.into())
        }
    }

    public actual fun beginRenderPass(descriptor: GPURenderPassDescriptor): GPURenderPassEncoder {

    }

    public actual fun beginComputePass(descriptor: GPUComputePassDescriptor): GPUComputePassEncoder {

    }

    public actual fun copyBufferToBuffer(
        source: GPUBuffer,
        destination: GPUBuffer,
        size: GPUSize64,
    ) {

    }

    public actual fun copyBufferToBuffer(
        source: GPUBuffer,
        sourceOffset: GPUSize64,
        destination: GPUBuffer,
        destinationOffset: GPUSize64,
        size: GPUSize64,
    ) {

    }

    public actual fun copyBufferToTexture(
        source: GPUTexelCopyBufferInfo,
        destination: GPUTexelCopyTextureInfo,
        copySize: GPUExtent3D,
    ) {

    }

    public actual fun copyTextureToBuffer(
        source: GPUTexelCopyTextureInfo,
        destination: GPUTexelCopyBufferInfo,
        copySize: GPUExtent3D,
    ) {

    }

    public actual fun copyTextureToTexture(
        source: GPUTexelCopyTextureInfo,
        destination: GPUTexelCopyTextureInfo,
        copySize: GPUExtent3D,
    ) {

    }

    public actual fun clearBuffer(
        buffer: GPUBuffer,
        offset: GPUSize64,
        size: GPUSize64,
    ) {

    }

    public actual fun resolveQuerySet(
        querySet: GPUQuerySet,
        firstQuery: GPUSize32,
        queryCount: GPUSize32,
        destination: GPUBuffer,
        destinationOffset: GPUSize64,
    ) {

    }

    public actual fun finish(descriptor: GPUCommandBufferDescriptor): GPUCommandBuffer {
        return unsafeScope {
            GPUCommandBuffer(wgpuCommandEncoderFinish(encoder, descriptor.into().`$mem`))
        }
    }

    public fun into(): WGPUCommandEncoder = encoder
}
