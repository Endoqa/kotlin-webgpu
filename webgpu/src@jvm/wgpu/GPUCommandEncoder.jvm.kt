package wgpu

import lib.wgpu.*

public actual class GPUCommandEncoder(
    private val encoder: WGPUCommandEncoder,
) : GPUObjectBase, GPUCommandsMixin, GPUDebugCommandsMixin {
    actual override var label: String
        get() = TODO()
        set(value) {
            unsafeScope { wgpuCommandEncoderSetLabel(encoder, value.into()) }
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
        return unsafeScope {
            GPURenderPassEncoder(wgpuCommandEncoderBeginRenderPass(encoder, descriptor.into().`$mem`))
        }
    }

    public actual fun beginComputePass(descriptor: GPUComputePassDescriptor): GPUComputePassEncoder {
        return unsafeScope {
            GPUComputePassEncoder(wgpuCommandEncoderBeginComputePass(encoder, descriptor.into().`$mem`))
        }
    }

    public actual fun copyBufferToBuffer(
        source: GPUBuffer,
        destination: GPUBuffer,
        size: GPUSize64,
    ) {
        return copyBufferToBuffer(source, 0UL, destination, 0UL, size)
    }

    public actual fun copyBufferToBuffer(
        source: GPUBuffer,
        sourceOffset: GPUSize64,
        destination: GPUBuffer,
        destinationOffset: GPUSize64,
        size: GPUSize64,
    ) {
        wgpuCommandEncoderCopyBufferToBuffer(
            encoder,
            source.into(),
            sourceOffset,
            destination.into(),
            destinationOffset,
            size
        )
    }

    public actual fun copyBufferToTexture(
        source: GPUTexelCopyBufferInfo,
        destination: GPUTexelCopyTextureInfo,
        copySize: GPUExtent3D,
    ) {
        return unsafeScope {
            wgpuCommandEncoderCopyBufferToTexture(
                encoder,
                source.into().`$mem`,
                destination.into().`$mem`,
                copySize.into().`$mem`
            )
        }
    }

    public actual fun copyTextureToBuffer(
        source: GPUTexelCopyTextureInfo,
        destination: GPUTexelCopyBufferInfo,
        copySize: GPUExtent3D,
    ) {
        return unsafeScope {
            wgpuCommandEncoderCopyTextureToBuffer(
                encoder,
                source.into().`$mem`,
                destination.into().`$mem`,
                copySize.into().`$mem`
            )
        }
    }

    public actual fun copyTextureToTexture(
        source: GPUTexelCopyTextureInfo,
        destination: GPUTexelCopyTextureInfo,
        copySize: GPUExtent3D,
    ) {
        return unsafeScope {
            wgpuCommandEncoderCopyTextureToTexture(
                encoder,
                source.into().`$mem`,
                destination.into().`$mem`,
                copySize.into().`$mem`
            )
        }
    }

    public actual fun clearBuffer(
        buffer: GPUBuffer,
        offset: GPUSize64,
        size: GPUSize64,
    ) {
        wgpuCommandEncoderClearBuffer(encoder, buffer.into(), offset, size)
    }

    public actual fun resolveQuerySet(
        querySet: GPUQuerySet,
        firstQuery: GPUSize32,
        queryCount: GPUSize32,
        destination: GPUBuffer,
        destinationOffset: GPUSize64,
    ) {
        wgpuCommandEncoderResolveQuerySet(
            encoder,
            querySet.into(),
            firstQuery,
            queryCount,
            destination.into(),
            destinationOffset,
        )
    }

    public actual fun finish(descriptor: GPUCommandBufferDescriptor): GPUCommandBuffer {
        return unsafeScope {
            GPUCommandBuffer(wgpuCommandEncoderFinish(encoder, descriptor.into().`$mem`))
        }
    }

    public fun into(): WGPUCommandEncoder = encoder
}
