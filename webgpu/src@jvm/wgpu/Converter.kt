package wgpu

import lib.wgpu.*
import java.lang.foreign.Arena
import java.lang.foreign.MemorySegment
import java.lang.foreign.ValueLayout

internal typealias NativeGPURequestAdapterOptions = WGPURequestAdapterOptions

context(Arena)
internal fun GPURequestAdapterOptions.into(`out`: Pointer<NativeGPURequestAdapterOptions>): NativeGPURequestAdapterOptions = into()

context(Arena)
internal fun GPURequestAdapterOptions.into(`out`: NativeGPURequestAdapterOptions = NativeGPURequestAdapterOptions.allocate(this@Arena)): NativeGPURequestAdapterOptions {
    out.featureLevel = this.featureLevel.into(out.featureLevel)
    out.powerPreference = this.powerPreference?.into() ?: WGPUPowerPreference.Undefined
    this.forceFallbackAdapter.into(out.forceFallbackAdapter)
    // todo: no interop for this.xrCompatible
    return out
}

internal typealias NativeGPUDeviceDescriptor = WGPUDeviceDescriptor

context(Arena)
internal fun GPUDeviceDescriptor.into(`out`: Pointer<NativeGPUDeviceDescriptor>): NativeGPUDeviceDescriptor = into()

context(Arena)
internal fun GPUDeviceDescriptor.into(`out`: NativeGPUDeviceDescriptor = NativeGPUDeviceDescriptor.allocate(this@Arena)): NativeGPUDeviceDescriptor {
    this.label.into(out.label)
    out.requiredFeatureCount = this.requiredFeatures.size.toULong()
    out.requiredFeatures = allocateFrom(ValueLayout.JAVA_INT, *this.requiredFeatures.map { it.interop.value }.toIntArray())
    out.requiredLimits = this.requiredLimits.into(out.requiredLimits).`$mem`
    this.defaultQueue.into(out.defaultQueue)
    return out
}

internal typealias NativeGPUBufferDescriptor = WGPUBufferDescriptor

context(Arena)
internal fun GPUBufferDescriptor.into(`out`: Pointer<NativeGPUBufferDescriptor>): NativeGPUBufferDescriptor = into()

context(Arena)
internal fun GPUBufferDescriptor.into(`out`: NativeGPUBufferDescriptor = NativeGPUBufferDescriptor.allocate(this@Arena)): NativeGPUBufferDescriptor {
    this.label.into(out.label)
    out.size = this.size
    out.usage = this.usage.toULong()
    this.mappedAtCreation.into(out.mappedAtCreation)
    return out
}

internal typealias NativeGPUTextureDescriptor = WGPUTextureDescriptor

context(Arena)
internal fun GPUTextureDescriptor.into(`out`: Pointer<NativeGPUTextureDescriptor>): NativeGPUTextureDescriptor = into()

context(Arena)
internal fun GPUTextureDescriptor.into(`out`: NativeGPUTextureDescriptor = NativeGPUTextureDescriptor.allocate(this@Arena)): NativeGPUTextureDescriptor {
    this.label.into(out.label)
    this.size.into(out.size)
    out.mipLevelCount = this.mipLevelCount
    out.sampleCount = this.sampleCount
    out.dimension = this.dimension.into()
    out.format = this.format.into()
    out.usage = this.usage.toULong()
    out.viewFormatCount = this.viewFormats.size.toULong()
    out.viewFormats = allocateFrom(ValueLayout.JAVA_INT, *this.viewFormats.map { it.interop.value }.toIntArray())
    return out
}

internal typealias NativeGPUTextureViewDescriptor = WGPUTextureViewDescriptor

context(Arena)
internal fun GPUTextureViewDescriptor.into(`out`: Pointer<NativeGPUTextureViewDescriptor>): NativeGPUTextureViewDescriptor = into()

context(Arena)
internal fun GPUTextureViewDescriptor.into(`out`: NativeGPUTextureViewDescriptor = NativeGPUTextureViewDescriptor.allocate(this@Arena)): NativeGPUTextureViewDescriptor {
    this.label.into(out.label)
    out.format = this.format?.into() ?: WGPUTextureFormat.Undefined
    out.dimension = this.dimension?.into() ?: WGPUTextureViewDimension.Undefined
    out.usage = this.usage.toULong()
    out.aspect = this.aspect.into()
    out.baseMipLevel = this.baseMipLevel
    out.mipLevelCount = this.mipLevelCount ?: 0u
    out.baseArrayLayer = this.baseArrayLayer
    out.arrayLayerCount = this.arrayLayerCount ?: 0u
    return out
}

internal typealias NativeGPUSamplerDescriptor = WGPUSamplerDescriptor

context(Arena)
internal fun GPUSamplerDescriptor.into(`out`: Pointer<NativeGPUSamplerDescriptor>): NativeGPUSamplerDescriptor = into()

context(Arena)
internal fun GPUSamplerDescriptor.into(`out`: NativeGPUSamplerDescriptor = NativeGPUSamplerDescriptor.allocate(this@Arena)): NativeGPUSamplerDescriptor {
    this.label.into(out.label)
    out.addressModeU = this.addressModeU.into()
    out.addressModeV = this.addressModeV.into()
    out.addressModeW = this.addressModeW.into()
    out.magFilter = this.magFilter.into()
    out.minFilter = this.minFilter.into()
    out.mipmapFilter = this.mipmapFilter.into()
    out.lodMinClamp = this.lodMinClamp
    out.lodMaxClamp = this.lodMaxClamp
    out.compare = this.compare?.into() ?: WGPUCompareFunction.Undefined
    out.maxAnisotropy = this.maxAnisotropy
    return out
}

internal typealias NativeGPUBindGroupLayoutDescriptor = WGPUBindGroupLayoutDescriptor

context(Arena)
internal fun GPUBindGroupLayoutDescriptor.into(`out`: Pointer<NativeGPUBindGroupLayoutDescriptor>): NativeGPUBindGroupLayoutDescriptor = into()

context(Arena)
internal fun GPUBindGroupLayoutDescriptor.into(`out`: NativeGPUBindGroupLayoutDescriptor = NativeGPUBindGroupLayoutDescriptor.allocate(this@Arena)): NativeGPUBindGroupLayoutDescriptor {
    this.label.into(out.label)
    out.entryCount = this.entries.size.toULong()
    out.entries = allocateList(this.entries, WGPUBindGroupLayoutEntry.layout, ::WGPUBindGroupLayoutEntry, { src, out -> src.into(out) })
    return out
}

internal typealias NativeGPUBindGroupLayoutEntry = WGPUBindGroupLayoutEntry

context(Arena)
internal fun GPUBindGroupLayoutEntry.into(`out`: Pointer<NativeGPUBindGroupLayoutEntry>): NativeGPUBindGroupLayoutEntry = into()

context(Arena)
internal fun GPUBindGroupLayoutEntry.into(`out`: NativeGPUBindGroupLayoutEntry = NativeGPUBindGroupLayoutEntry.allocate(this@Arena)): NativeGPUBindGroupLayoutEntry {
    out.binding = this.binding
    out.visibility = this.visibility.toULong()
    this.buffer?.into(out.buffer)
    this.sampler?.into(out.sampler)
    this.texture?.into(out.texture)
    this.storageTexture?.into(out.storageTexture)
    return out
}

internal typealias NativeGPUBufferBindingLayout = WGPUBufferBindingLayout

context(Arena)
internal fun GPUBufferBindingLayout.into(`out`: Pointer<NativeGPUBufferBindingLayout>): NativeGPUBufferBindingLayout = into()

context(Arena)
internal fun GPUBufferBindingLayout.into(`out`: NativeGPUBufferBindingLayout = NativeGPUBufferBindingLayout.allocate(this@Arena)): NativeGPUBufferBindingLayout {
    out.type = this.type.into()
    this.hasDynamicOffset.into(out.hasDynamicOffset)
    out.minBindingSize = this.minBindingSize
    return out
}

internal typealias NativeGPUSamplerBindingLayout = WGPUSamplerBindingLayout

context(Arena)
internal fun GPUSamplerBindingLayout.into(`out`: Pointer<NativeGPUSamplerBindingLayout>): NativeGPUSamplerBindingLayout = into()

context(Arena)
internal fun GPUSamplerBindingLayout.into(`out`: NativeGPUSamplerBindingLayout = NativeGPUSamplerBindingLayout.allocate(this@Arena)): NativeGPUSamplerBindingLayout {
    out.type = this.type.into()
    return out
}

internal typealias NativeGPUTextureBindingLayout = WGPUTextureBindingLayout

context(Arena)
internal fun GPUTextureBindingLayout.into(`out`: Pointer<NativeGPUTextureBindingLayout>): NativeGPUTextureBindingLayout = into()

context(Arena)
internal fun GPUTextureBindingLayout.into(`out`: NativeGPUTextureBindingLayout = NativeGPUTextureBindingLayout.allocate(this@Arena)): NativeGPUTextureBindingLayout {
    out.sampleType = this.sampleType.into()
    out.viewDimension = this.viewDimension.into()
    this.multisampled.into(out.multisampled)
    return out
}

internal typealias NativeGPUStorageTextureBindingLayout = WGPUStorageTextureBindingLayout

context(Arena)
internal fun GPUStorageTextureBindingLayout.into(`out`: Pointer<NativeGPUStorageTextureBindingLayout>): NativeGPUStorageTextureBindingLayout = into()

context(Arena)
internal fun GPUStorageTextureBindingLayout.into(`out`: NativeGPUStorageTextureBindingLayout = NativeGPUStorageTextureBindingLayout.allocate(this@Arena)): NativeGPUStorageTextureBindingLayout {
    out.access = this.access.into()
    out.format = this.format.into()
    out.viewDimension = this.viewDimension.into()
    return out
}

internal typealias NativeGPUBindGroupDescriptor = WGPUBindGroupDescriptor

context(Arena)
internal fun GPUBindGroupDescriptor.into(`out`: Pointer<NativeGPUBindGroupDescriptor>): NativeGPUBindGroupDescriptor = into()

context(Arena)
internal fun GPUBindGroupDescriptor.into(`out`: NativeGPUBindGroupDescriptor = NativeGPUBindGroupDescriptor.allocate(this@Arena)): NativeGPUBindGroupDescriptor {
    this.label.into(out.label)
    out.layout = this.layout.into()
    out.entryCount = this.entries.size.toULong()
    out.entries = allocateList(this.entries, WGPUBindGroupEntry.layout, ::WGPUBindGroupEntry, { src, out -> src.into(out) })
    return out
}

internal typealias NativeGPUBindGroupEntry = WGPUBindGroupEntry

context(Arena)
internal fun GPUBindGroupEntry.into(`out`: Pointer<NativeGPUBindGroupEntry>): NativeGPUBindGroupEntry = into()

context(Arena)
internal fun GPUBindGroupEntry.into(`out`: NativeGPUBindGroupEntry = NativeGPUBindGroupEntry.allocate(this@Arena)): NativeGPUBindGroupEntry {
    out.binding = this.binding
    this.resource.into(out)
    return out
}

internal typealias NativeGPUPipelineLayoutDescriptor = WGPUPipelineLayoutDescriptor

context(Arena)
internal fun GPUPipelineLayoutDescriptor.into(`out`: Pointer<NativeGPUPipelineLayoutDescriptor>): NativeGPUPipelineLayoutDescriptor = into()

context(Arena)
internal fun GPUPipelineLayoutDescriptor.into(`out`: NativeGPUPipelineLayoutDescriptor = NativeGPUPipelineLayoutDescriptor.allocate(this@Arena)): NativeGPUPipelineLayoutDescriptor {
    this.label.into(out.label)
    out.bindGroupLayoutCount = this.bindGroupLayouts.size.toULong()
    out.bindGroupLayouts = allocateList(this.bindGroupLayouts) { it?.into() ?: MemorySegment.NULL }
    return out
}

internal typealias NativeGPUShaderModuleDescriptor = WGPUShaderModuleDescriptor

context(Arena)
internal fun GPUShaderModuleDescriptor.into(`out`: Pointer<NativeGPUShaderModuleDescriptor>): NativeGPUShaderModuleDescriptor = into()

context(Arena)
internal fun GPUShaderModuleDescriptor.into(`out`: NativeGPUShaderModuleDescriptor = NativeGPUShaderModuleDescriptor.allocate(this@Arena)): NativeGPUShaderModuleDescriptor {
    this.label.into(out.label)
    // todo: no interop for this.code
    // todo: no interop for this.compilationHints
    return out
}


internal typealias NativeGPUComputePipelineDescriptor = WGPUComputePipelineDescriptor

context(Arena)
internal fun GPUComputePipelineDescriptor.into(`out`: Pointer<NativeGPUComputePipelineDescriptor>): NativeGPUComputePipelineDescriptor = into()

context(Arena)
internal fun GPUComputePipelineDescriptor.into(`out`: NativeGPUComputePipelineDescriptor = NativeGPUComputePipelineDescriptor.allocate(this@Arena)): NativeGPUComputePipelineDescriptor {
    this.label.into(out.label)
    out.layout = this.layout?.into() ?: MemorySegment.NULL
    this.compute.into(out.compute)
    return out
}

internal typealias NativeGPURenderPipelineDescriptor = WGPURenderPipelineDescriptor

context(Arena)
internal fun GPURenderPipelineDescriptor.into(`out`: Pointer<NativeGPURenderPipelineDescriptor>): NativeGPURenderPipelineDescriptor = into()

context(Arena)
internal fun GPURenderPipelineDescriptor.into(`out`: NativeGPURenderPipelineDescriptor = NativeGPURenderPipelineDescriptor.allocate(this@Arena)): NativeGPURenderPipelineDescriptor {
    this.label.into(out.label)
    out.layout = this.layout?.into() ?: MemorySegment.NULL
    this.vertex.into(out.vertex)
    this.primitive.into(out.primitive)
    out.depthStencil = this.depthStencil?.into(out.depthStencil)?.`$mem` ?: MemorySegment.NULL
    this.multisample.into(out.multisample)
    out.fragment = this.fragment?.into(out.fragment)?.`$mem` ?: MemorySegment.NULL
    return out
}

internal typealias NativeGPUPrimitiveState = WGPUPrimitiveState

context(Arena)
internal fun GPUPrimitiveState.into(`out`: Pointer<NativeGPUPrimitiveState>): NativeGPUPrimitiveState = into()

context(Arena)
internal fun GPUPrimitiveState.into(`out`: NativeGPUPrimitiveState = NativeGPUPrimitiveState.allocate(this@Arena)): NativeGPUPrimitiveState {
    out.topology = this.topology.into()
    out.stripIndexFormat = this.stripIndexFormat?.into() ?: WGPUIndexFormat.Undefined
    out.frontFace = this.frontFace.into()
    out.cullMode = this.cullMode.into()
    this.unclippedDepth.into(out.unclippedDepth)
    return out
}

internal typealias NativeGPUMultisampleState = WGPUMultisampleState

context(Arena)
internal fun GPUMultisampleState.into(`out`: Pointer<NativeGPUMultisampleState>): NativeGPUMultisampleState = into()

context(Arena)
internal fun GPUMultisampleState.into(`out`: NativeGPUMultisampleState = NativeGPUMultisampleState.allocate(this@Arena)): NativeGPUMultisampleState {
    out.count = this.count
    out.mask = this.mask
    this.alphaToCoverageEnabled.into(out.alphaToCoverageEnabled)
    return out
}

internal typealias NativeGPUFragmentState = WGPUFragmentState

context(Arena)
internal fun GPUFragmentState.into(`out`: Pointer<NativeGPUFragmentState>): NativeGPUFragmentState = into()

context(Arena)
internal fun GPUFragmentState.into(`out`: NativeGPUFragmentState = NativeGPUFragmentState.allocate(this@Arena)): NativeGPUFragmentState {
    out.module = this.module.into()
    this.entryPoint?.into(out.entryPoint)
    out.constantCount = this.constants.size.toULong()
    out.constants = allocateList(this.constants, WGPUConstantEntry.layout, ::WGPUConstantEntry, { src, out -> src.into(out) })
    out.targetCount = this.targets.size.toULong()
    out.targets = allocateList(this.targets, WGPUColorTargetState.layout, ::WGPUColorTargetState, { src, out -> src?.into(out) })
    return out
}

internal typealias NativeGPUColorTargetState = WGPUColorTargetState

context(Arena)
internal fun GPUColorTargetState.into(`out`: Pointer<NativeGPUColorTargetState>): NativeGPUColorTargetState = into()

context(Arena)
internal fun GPUColorTargetState.into(`out`: NativeGPUColorTargetState = NativeGPUColorTargetState.allocate(this@Arena)): NativeGPUColorTargetState {
    out.format = this.format.into()
    out.blend = this.blend?.into(out.blend)?.`$mem` ?: MemorySegment.NULL
    out.writeMask = this.writeMask.toULong()
    return out
}

internal typealias NativeGPUBlendState = WGPUBlendState

context(Arena)
internal fun GPUBlendState.into(`out`: Pointer<NativeGPUBlendState>): NativeGPUBlendState = into()

context(Arena)
internal fun GPUBlendState.into(`out`: NativeGPUBlendState = NativeGPUBlendState.allocate(this@Arena)): NativeGPUBlendState {
    this.color.into(out.color)
    this.alpha.into(out.alpha)
    return out
}

internal typealias NativeGPUBlendComponent = WGPUBlendComponent

context(Arena)
internal fun GPUBlendComponent.into(`out`: Pointer<NativeGPUBlendComponent>): NativeGPUBlendComponent = into()

context(Arena)
internal fun GPUBlendComponent.into(`out`: NativeGPUBlendComponent = NativeGPUBlendComponent.allocate(this@Arena)): NativeGPUBlendComponent {
    out.operation = this.operation.into()
    out.srcFactor = this.srcFactor.into()
    out.dstFactor = this.dstFactor.into()
    return out
}

internal typealias NativeGPUDepthStencilState = WGPUDepthStencilState

context(Arena)
internal fun GPUDepthStencilState.into(`out`: Pointer<NativeGPUDepthStencilState>): NativeGPUDepthStencilState = into()

context(Arena)
internal fun GPUDepthStencilState.into(`out`: NativeGPUDepthStencilState = NativeGPUDepthStencilState.allocate(this@Arena)): NativeGPUDepthStencilState {
    out.format = this.format.into()
    out.depthWriteEnabled = this.depthWriteEnabled.into()
    out.depthCompare = this.depthCompare?.into() ?: WGPUCompareFunction.Undefined
    this.stencilFront.into(out.stencilFront)
    this.stencilBack.into(out.stencilBack)
    out.stencilReadMask = this.stencilReadMask
    out.stencilWriteMask = this.stencilWriteMask
    out.depthBias = this.depthBias
    out.depthBiasSlopeScale = this.depthBiasSlopeScale
    out.depthBiasClamp = this.depthBiasClamp
    return out
}

internal typealias NativeGPUStencilFaceState = WGPUStencilFaceState

context(Arena)
internal fun GPUStencilFaceState.into(`out`: Pointer<NativeGPUStencilFaceState>): NativeGPUStencilFaceState = into()

context(Arena)
internal fun GPUStencilFaceState.into(`out`: NativeGPUStencilFaceState = NativeGPUStencilFaceState.allocate(this@Arena)): NativeGPUStencilFaceState {
    out.compare = this.compare.into()
    out.failOp = this.failOp.into()
    out.depthFailOp = this.depthFailOp.into()
    out.passOp = this.passOp.into()
    return out
}

internal typealias NativeGPUVertexState = WGPUVertexState

context(Arena)
internal fun GPUVertexState.into(`out`: Pointer<NativeGPUVertexState>): NativeGPUVertexState = into()

context(Arena)
internal fun GPUVertexState.into(`out`: NativeGPUVertexState = NativeGPUVertexState.allocate(this@Arena)): NativeGPUVertexState {
    out.module = this.module.into()
    this.entryPoint?.into(out.entryPoint)
    out.constantCount = this.constants.size.toULong()
    out.constants = allocateList(this.constants, WGPUConstantEntry.layout, ::WGPUConstantEntry, { src, out -> src.into(out) })
    out.bufferCount = this.buffers.size.toULong()
    out.buffers = allocateList(this.buffers, WGPUVertexBufferLayout.layout, ::WGPUVertexBufferLayout, { src, out -> src?.into(out) })
    return out
}

internal typealias NativeGPUVertexBufferLayout = WGPUVertexBufferLayout

context(Arena)
internal fun GPUVertexBufferLayout.into(`out`: Pointer<NativeGPUVertexBufferLayout>): NativeGPUVertexBufferLayout = into()

context(Arena)
internal fun GPUVertexBufferLayout.into(`out`: NativeGPUVertexBufferLayout = NativeGPUVertexBufferLayout.allocate(this@Arena)): NativeGPUVertexBufferLayout {
    out.arrayStride = this.arrayStride
    out.stepMode = this.stepMode.into()
    out.attributeCount = this.attributes.size.toULong()
    out.attributes = allocateList(this.attributes, WGPUVertexAttribute.layout, ::WGPUVertexAttribute, { src, out -> src.into(out) })
    return out
}

internal typealias NativeGPUVertexAttribute = WGPUVertexAttribute

context(Arena)
internal fun GPUVertexAttribute.into(`out`: Pointer<NativeGPUVertexAttribute>): NativeGPUVertexAttribute = into()

context(Arena)
internal fun GPUVertexAttribute.into(`out`: NativeGPUVertexAttribute = NativeGPUVertexAttribute.allocate(this@Arena)): NativeGPUVertexAttribute {
    out.format = this.format.into()
    out.offset = this.offset
    out.shaderLocation = this.shaderLocation
    return out
}


internal typealias NativeGPUTexelCopyTextureInfo = WGPUTexelCopyTextureInfo

context(Arena)
internal fun GPUTexelCopyTextureInfo.into(`out`: Pointer<NativeGPUTexelCopyTextureInfo>): NativeGPUTexelCopyTextureInfo = into()

context(Arena)
internal fun GPUTexelCopyTextureInfo.into(`out`: NativeGPUTexelCopyTextureInfo = NativeGPUTexelCopyTextureInfo.allocate(this@Arena)): NativeGPUTexelCopyTextureInfo {
    out.texture = this.texture.into()
    out.mipLevel = this.mipLevel
    this.origin.into(out.origin)
    out.aspect = this.aspect.into()
    return out
}

internal typealias NativeGPUCommandBufferDescriptor = WGPUCommandBufferDescriptor

context(Arena)
internal fun GPUCommandBufferDescriptor.into(`out`: Pointer<NativeGPUCommandBufferDescriptor>): NativeGPUCommandBufferDescriptor = into()

context(Arena)
internal fun GPUCommandBufferDescriptor.into(`out`: NativeGPUCommandBufferDescriptor = NativeGPUCommandBufferDescriptor.allocate(this@Arena)): NativeGPUCommandBufferDescriptor {
    this.label.into(out.label)
    return out
}

internal typealias NativeGPUCommandEncoderDescriptor = WGPUCommandEncoderDescriptor

context(Arena)
internal fun GPUCommandEncoderDescriptor.into(`out`: Pointer<NativeGPUCommandEncoderDescriptor>): NativeGPUCommandEncoderDescriptor = into()

context(Arena)
internal fun GPUCommandEncoderDescriptor.into(`out`: NativeGPUCommandEncoderDescriptor = NativeGPUCommandEncoderDescriptor.allocate(this@Arena)): NativeGPUCommandEncoderDescriptor {
    this.label.into(out.label)
    return out
}


internal typealias NativeGPUComputePassDescriptor = WGPUComputePassDescriptor

context(Arena)
internal fun GPUComputePassDescriptor.into(`out`: Pointer<NativeGPUComputePassDescriptor>): NativeGPUComputePassDescriptor = into()

context(Arena)
internal fun GPUComputePassDescriptor.into(`out`: NativeGPUComputePassDescriptor = NativeGPUComputePassDescriptor.allocate(this@Arena)): NativeGPUComputePassDescriptor {
    this.label.into(out.label)
    out.timestampWrites = this.timestampWrites?.into()?.`$mem` ?: MemorySegment.NULL
    return out
}


internal typealias NativeGPURenderPassDescriptor = WGPURenderPassDescriptor

context(Arena)
internal fun GPURenderPassDescriptor.into(`out`: Pointer<NativeGPURenderPassDescriptor>): NativeGPURenderPassDescriptor = into()

context(Arena)
internal fun GPURenderPassDescriptor.into(`out`: NativeGPURenderPassDescriptor = NativeGPURenderPassDescriptor.allocate(this@Arena)): NativeGPURenderPassDescriptor {
    this.label.into(out.label)
    out.colorAttachmentCount = this.colorAttachments.size.toULong()
    out.colorAttachments =
        allocateList(this.colorAttachments, WGPURenderPassColorAttachment.layout, ::WGPURenderPassColorAttachment, { src, out -> src?.into(out) })
    out.depthStencilAttachment = this.depthStencilAttachment?.into(out.depthStencilAttachment)?.`$mem` ?: MemorySegment.NULL
    out.occlusionQuerySet = this.occlusionQuerySet?.into() ?: MemorySegment.NULL
    out.timestampWrites = this.timestampWrites?.into()?.`$mem` ?: MemorySegment.NULL

    val maxDrawCountDesc = WGPURenderPassMaxDrawCount.allocate(this@Arena)
    maxDrawCountDesc.chain.sType = WGPUSType.RenderPassMaxDrawCount
    maxDrawCountDesc.maxDrawCount = this.maxDrawCount
    out.nextInChain = maxDrawCountDesc.`$mem`

    return out
}

internal typealias NativeGPURenderPassColorAttachment = WGPURenderPassColorAttachment

context(Arena)
internal fun GPURenderPassColorAttachment.into(`out`: Pointer<NativeGPURenderPassColorAttachment>): NativeGPURenderPassColorAttachment = into()

context(Arena)
internal fun GPURenderPassColorAttachment.into(`out`: NativeGPURenderPassColorAttachment = NativeGPURenderPassColorAttachment.allocate(this@Arena)): NativeGPURenderPassColorAttachment {
    out.view = this.view.into()
    out.depthSlice = this.depthSlice ?: 0u
    out.resolveTarget = this.resolveTarget?.into() ?: MemorySegment.NULL
    this.clearValue?.into(out.clearValue)
    out.loadOp = this.loadOp.into()
    out.storeOp = this.storeOp.into()
    return out
}

internal typealias NativeGPURenderPassDepthStencilAttachment = WGPURenderPassDepthStencilAttachment

context(Arena)
internal fun GPURenderPassDepthStencilAttachment.into(`out`: Pointer<NativeGPURenderPassDepthStencilAttachment>): NativeGPURenderPassDepthStencilAttachment =
    into()

context(Arena)
internal fun GPURenderPassDepthStencilAttachment.into(`out`: NativeGPURenderPassDepthStencilAttachment = NativeGPURenderPassDepthStencilAttachment.allocate(this@Arena)): NativeGPURenderPassDepthStencilAttachment {
    out.view = this.view.into()
    out.depthClearValue = this.depthClearValue ?: Float.NaN
    out.depthLoadOp = this.depthLoadOp?.into() ?: WGPULoadOp.Undefined
    out.depthStoreOp = this.depthStoreOp?.into() ?: WGPUStoreOp.Undefined
    this.depthReadOnly.into(out.depthReadOnly)
    out.stencilClearValue = this.stencilClearValue
    out.stencilLoadOp = this.stencilLoadOp?.into() ?: WGPULoadOp.Undefined
    out.stencilStoreOp = this.stencilStoreOp?.into() ?: WGPUStoreOp.Undefined
    this.stencilReadOnly.into(out.stencilReadOnly)
    return out
}

internal typealias NativeGPURenderBundleDescriptor = WGPURenderBundleDescriptor

context(Arena)
internal fun GPURenderBundleDescriptor.into(`out`: Pointer<NativeGPURenderBundleDescriptor>): NativeGPURenderBundleDescriptor = into()

context(Arena)
internal fun GPURenderBundleDescriptor.into(`out`: NativeGPURenderBundleDescriptor = NativeGPURenderBundleDescriptor.allocate(this@Arena)): NativeGPURenderBundleDescriptor {
    this.label.into(out.label)
    return out
}

internal typealias NativeGPURenderBundleEncoderDescriptor = WGPURenderBundleEncoderDescriptor

context(Arena)
internal fun GPURenderBundleEncoderDescriptor.into(`out`: Pointer<NativeGPURenderBundleEncoderDescriptor>): NativeGPURenderBundleEncoderDescriptor = into()

context(Arena)
internal fun GPURenderBundleEncoderDescriptor.into(`out`: NativeGPURenderBundleEncoderDescriptor = NativeGPURenderBundleEncoderDescriptor.allocate(this@Arena)): NativeGPURenderBundleEncoderDescriptor {
    this.label.into(out.label)
    out.colorFormatCount = this.colorFormats.size.toULong()
    out.colorFormats = allocateFrom(ValueLayout.JAVA_INT, *this.colorFormats.map { it?.interop?.value ?: 0 }.toIntArray())
    out.depthStencilFormat = this.depthStencilFormat?.into() ?: WGPUTextureFormat.Undefined
    out.sampleCount = this.sampleCount
    this.depthReadOnly.into(out.depthReadOnly)
    this.stencilReadOnly.into(out.stencilReadOnly)
    return out
}

internal typealias NativeGPUQueueDescriptor = WGPUQueueDescriptor

context(Arena)
internal fun GPUQueueDescriptor.into(`out`: Pointer<NativeGPUQueueDescriptor>): NativeGPUQueueDescriptor = into()

context(Arena)
internal fun GPUQueueDescriptor.into(`out`: NativeGPUQueueDescriptor = NativeGPUQueueDescriptor.allocate(this@Arena)): NativeGPUQueueDescriptor {
    this.label.into(out.label)
    return out
}

internal typealias NativeGPUQuerySetDescriptor = WGPUQuerySetDescriptor

context(Arena)
internal fun GPUQuerySetDescriptor.into(`out`: Pointer<NativeGPUQuerySetDescriptor>): NativeGPUQuerySetDescriptor = into()

context(Arena)
internal fun GPUQuerySetDescriptor.into(`out`: NativeGPUQuerySetDescriptor = NativeGPUQuerySetDescriptor.allocate(this@Arena)): NativeGPUQuerySetDescriptor {
    this.label.into(out.label)
    out.type = this.type.into()
    out.count = this.count
    return out
}

internal typealias NativeGPUColor = WGPUColor

context(Arena)
internal fun GPUColor.into(`out`: Pointer<NativeGPUColor>): NativeGPUColor = into()

context(Arena)
internal fun GPUColor.into(`out`: NativeGPUColor = NativeGPUColor.allocate(this@Arena)): NativeGPUColor {
    out.r = this.r
    out.g = this.g
    out.b = this.b
    out.a = this.a
    return out
}


internal typealias NativeGPUOrigin3D = WGPUOrigin3D

context(Arena)
internal fun GPUOrigin3D.into(`out`: Pointer<NativeGPUOrigin3D>): NativeGPUOrigin3D = into()

context(Arena)
internal fun GPUOrigin3D.into(`out`: NativeGPUOrigin3D = NativeGPUOrigin3D.allocate(this@Arena)): NativeGPUOrigin3D {
    out.x = this.x
    out.y = this.y
    out.z = this.z
    return out
}

internal typealias NativeGPUExtent3D = WGPUExtent3D

context(Arena)
internal fun GPUExtent3D.into(`out`: Pointer<NativeGPUExtent3D>): NativeGPUExtent3D = into()

context(Arena)
internal fun GPUExtent3D.into(`out`: NativeGPUExtent3D = NativeGPUExtent3D.allocate(this@Arena)): NativeGPUExtent3D {
    out.width = this.width
    out.height = this.height
    out.depthOrArrayLayers = this.depthOrArrayLayers
    return out
}

internal typealias NativeGPULimits = WGPULimits

context(Arena)
internal fun GPULimits.into(`out`: Pointer<NativeGPULimits>): NativeGPULimits = into()

context(Arena)
internal fun GPULimits.into(`out`: NativeGPULimits = NativeGPULimits.allocate(this@Arena)): NativeGPULimits {
    out.maxTextureDimension1D = this.maxTextureDimension1D
    out.maxTextureDimension2D = this.maxTextureDimension2D
    out.maxTextureDimension3D = this.maxTextureDimension3D
    out.maxTextureArrayLayers = this.maxTextureArrayLayers
    out.maxBindGroups = this.maxBindGroups
    out.maxBindGroupsPlusVertexBuffers = this.maxBindGroupsPlusVertexBuffers
    out.maxBindingsPerBindGroup = this.maxBindingsPerBindGroup
    out.maxDynamicUniformBuffersPerPipelineLayout = this.maxDynamicUniformBuffersPerPipelineLayout
    out.maxDynamicStorageBuffersPerPipelineLayout = this.maxDynamicStorageBuffersPerPipelineLayout
    out.maxSampledTexturesPerShaderStage = this.maxSampledTexturesPerShaderStage
    out.maxSamplersPerShaderStage = this.maxSamplersPerShaderStage
    out.maxStorageBuffersPerShaderStage = this.maxStorageBuffersPerShaderStage
    out.maxStorageTexturesPerShaderStage = this.maxStorageTexturesPerShaderStage
    out.maxUniformBuffersPerShaderStage = this.maxUniformBuffersPerShaderStage
    out.maxUniformBufferBindingSize = this.maxUniformBufferBindingSize
    out.maxStorageBufferBindingSize = this.maxStorageBufferBindingSize
    out.minUniformBufferOffsetAlignment = this.minUniformBufferOffsetAlignment
    out.minStorageBufferOffsetAlignment = this.minStorageBufferOffsetAlignment
    out.maxVertexBuffers = this.maxVertexBuffers
    out.maxBufferSize = this.maxBufferSize
    out.maxVertexAttributes = this.maxVertexAttributes
    out.maxVertexBufferArrayStride = this.maxVertexBufferArrayStride
    out.maxInterStageShaderVariables = this.maxInterStageShaderVariables
    out.maxColorAttachments = this.maxColorAttachments
    out.maxColorAttachmentBytesPerSample = this.maxColorAttachmentBytesPerSample
    out.maxComputeWorkgroupStorageSize = this.maxComputeWorkgroupStorageSize
    out.maxComputeInvocationsPerWorkgroup = this.maxComputeInvocationsPerWorkgroup
    out.maxComputeWorkgroupSizeX = this.maxComputeWorkgroupSizeX
    out.maxComputeWorkgroupSizeY = this.maxComputeWorkgroupSizeY
    out.maxComputeWorkgroupSizeZ = this.maxComputeWorkgroupSizeZ
    out.maxComputeWorkgroupsPerDimension = this.maxComputeWorkgroupsPerDimension
    return out
}
