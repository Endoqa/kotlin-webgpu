package wgpu

import lib.wgpu.*
import java.lang.foreign.Arena
import java.lang.foreign.MemorySegment
import java.lang.foreign.ValueLayout

public typealias NativeGPURequestAdapterOptions = WGPURequestAdapterOptions

context(Arena)
public fun GPURequestAdapterOptions.into(`out`: Pointer<NativeGPURequestAdapterOptions>): Pointer<NativeGPURequestAdapterOptions> =
    into(NativeGPURequestAdapterOptions(out)).`$mem`

context(Arena)
public fun GPURequestAdapterOptions.into(
    `out`: NativeGPURequestAdapterOptions = NativeGPURequestAdapterOptions.allocate(
        this@Arena
    )
): NativeGPURequestAdapterOptions {
    out.featureLevel = this.featureLevel.into(out.featureLevel)
    out.powerPreference = this.powerPreference?.into() ?: WGPUPowerPreference.Undefined
    this.forceFallbackAdapter.into(out.forceFallbackAdapter)
    // todo: no interop for this.xrCompatible
    return out
}

public typealias NativeGPUDeviceDescriptor = WGPUDeviceDescriptor

context(Arena)
public fun GPUDeviceDescriptor.into(`out`: Pointer<NativeGPUDeviceDescriptor>): Pointer<NativeGPUDeviceDescriptor> =
    into(NativeGPUDeviceDescriptor(out)).`$mem`

context(Arena)
public fun GPUDeviceDescriptor.into(`out`: NativeGPUDeviceDescriptor = NativeGPUDeviceDescriptor.allocate(this@Arena)): NativeGPUDeviceDescriptor {
    this.label.into(out.label)
    out.requiredFeatureCount = this.requiredFeatures.size.toULong()
    out.requiredFeatures =
        allocateFrom(ValueLayout.JAVA_INT, *this.requiredFeatures.map { it.interop.value }.toIntArray())
    this.requiredLimits.into(out.requiredLimits)
    this.defaultQueue.into(out.defaultQueue)
    return out
}

public typealias NativeGPUBufferDescriptor = WGPUBufferDescriptor

context(Arena)
public fun GPUBufferDescriptor.into(`out`: Pointer<NativeGPUBufferDescriptor>): Pointer<NativeGPUBufferDescriptor> =
    into(NativeGPUBufferDescriptor(out)).`$mem`

context(Arena)
public fun GPUBufferDescriptor.into(`out`: NativeGPUBufferDescriptor = NativeGPUBufferDescriptor.allocate(this@Arena)): NativeGPUBufferDescriptor {
    this.label.into(out.label)
    out.size = this.size
    out.usage = this.usage.toULong()
    this.mappedAtCreation.into(out.mappedAtCreation)
    return out
}

public typealias NativeGPUTextureDescriptor = WGPUTextureDescriptor

context(Arena)
public fun GPUTextureDescriptor.into(`out`: Pointer<NativeGPUTextureDescriptor>): Pointer<NativeGPUTextureDescriptor> =
    into(NativeGPUTextureDescriptor(out)).`$mem`

context(Arena)
public fun GPUTextureDescriptor.into(`out`: NativeGPUTextureDescriptor = NativeGPUTextureDescriptor.allocate(this@Arena)): NativeGPUTextureDescriptor {
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

public typealias NativeGPUTextureViewDescriptor = WGPUTextureViewDescriptor

context(Arena)
public fun GPUTextureViewDescriptor.into(`out`: Pointer<NativeGPUTextureViewDescriptor>): Pointer<NativeGPUTextureViewDescriptor> =
    into(NativeGPUTextureViewDescriptor(out)).`$mem`

context(Arena)
public fun GPUTextureViewDescriptor.into(
    `out`: NativeGPUTextureViewDescriptor = NativeGPUTextureViewDescriptor.allocate(
        this@Arena
    )
): NativeGPUTextureViewDescriptor {
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

public typealias NativeGPUSamplerDescriptor = WGPUSamplerDescriptor

context(Arena)
public fun GPUSamplerDescriptor.into(`out`: Pointer<NativeGPUSamplerDescriptor>): Pointer<NativeGPUSamplerDescriptor> =
    into(NativeGPUSamplerDescriptor(out)).`$mem`

context(Arena)
public fun GPUSamplerDescriptor.into(`out`: NativeGPUSamplerDescriptor = NativeGPUSamplerDescriptor.allocate(this@Arena)): NativeGPUSamplerDescriptor {
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

public typealias NativeGPUBindGroupLayoutDescriptor = WGPUBindGroupLayoutDescriptor

context(Arena)
public fun GPUBindGroupLayoutDescriptor.into(`out`: Pointer<NativeGPUBindGroupLayoutDescriptor>): Pointer<NativeGPUBindGroupLayoutDescriptor> =
    into(NativeGPUBindGroupLayoutDescriptor(out)).`$mem`

context(Arena)
public fun GPUBindGroupLayoutDescriptor.into(
    `out`: NativeGPUBindGroupLayoutDescriptor = NativeGPUBindGroupLayoutDescriptor.allocate(
        this@Arena
    )
): NativeGPUBindGroupLayoutDescriptor {
    this.label.into(out.label)
    out.entryCount = this.entries.size.toULong()
    out.entries = allocateList(this.entries) { it.into().`$mem` }
    return out
}

public typealias NativeGPUBindGroupLayoutEntry = WGPUBindGroupLayoutEntry

context(Arena)
public fun GPUBindGroupLayoutEntry.into(`out`: Pointer<NativeGPUBindGroupLayoutEntry>): Pointer<NativeGPUBindGroupLayoutEntry> =
    into(NativeGPUBindGroupLayoutEntry(out)).`$mem`

context(Arena)
public fun GPUBindGroupLayoutEntry.into(
    `out`: NativeGPUBindGroupLayoutEntry = NativeGPUBindGroupLayoutEntry.allocate(
        this@Arena
    )
): NativeGPUBindGroupLayoutEntry {
    out.binding = this.binding
    out.visibility = this.visibility.toULong()
    this.buffer?.into(out.buffer)
    this.sampler?.into(out.sampler)
    this.texture?.into(out.texture)
    this.storageTexture?.into(out.storageTexture)
    return out
}

public typealias NativeGPUBufferBindingLayout = WGPUBufferBindingLayout

context(Arena)
public fun GPUBufferBindingLayout.into(`out`: Pointer<NativeGPUBufferBindingLayout>): Pointer<NativeGPUBufferBindingLayout> =
    into(NativeGPUBufferBindingLayout(out)).`$mem`

context(Arena)
public fun GPUBufferBindingLayout.into(`out`: NativeGPUBufferBindingLayout = NativeGPUBufferBindingLayout.allocate(this@Arena)): NativeGPUBufferBindingLayout {
    out.type = this.type.into()
    this.hasDynamicOffset.into(out.hasDynamicOffset)
    out.minBindingSize = this.minBindingSize
    return out
}

public typealias NativeGPUSamplerBindingLayout = WGPUSamplerBindingLayout

context(Arena)
public fun GPUSamplerBindingLayout.into(`out`: Pointer<NativeGPUSamplerBindingLayout>): Pointer<NativeGPUSamplerBindingLayout> =
    into(NativeGPUSamplerBindingLayout(out)).`$mem`

context(Arena)
public fun GPUSamplerBindingLayout.into(
    `out`: NativeGPUSamplerBindingLayout = NativeGPUSamplerBindingLayout.allocate(
        this@Arena
    )
): NativeGPUSamplerBindingLayout {
    out.type = this.type.into()
    return out
}

public typealias NativeGPUTextureBindingLayout = WGPUTextureBindingLayout

context(Arena)
public fun GPUTextureBindingLayout.into(`out`: Pointer<NativeGPUTextureBindingLayout>): Pointer<NativeGPUTextureBindingLayout> =
    into(NativeGPUTextureBindingLayout(out)).`$mem`

context(Arena)
public fun GPUTextureBindingLayout.into(
    `out`: NativeGPUTextureBindingLayout = NativeGPUTextureBindingLayout.allocate(
        this@Arena
    )
): NativeGPUTextureBindingLayout {
    out.sampleType = this.sampleType.into()
    out.viewDimension = this.viewDimension.into()
    this.multisampled.into(out.multisampled)
    return out
}

public typealias NativeGPUStorageTextureBindingLayout = WGPUStorageTextureBindingLayout

context(Arena)
public fun GPUStorageTextureBindingLayout.into(`out`: Pointer<NativeGPUStorageTextureBindingLayout>): Pointer<NativeGPUStorageTextureBindingLayout> =
    into(NativeGPUStorageTextureBindingLayout(out)).`$mem`

context(Arena)
public fun GPUStorageTextureBindingLayout.into(
    `out`: NativeGPUStorageTextureBindingLayout = NativeGPUStorageTextureBindingLayout.allocate(
        this@Arena
    )
): NativeGPUStorageTextureBindingLayout {
    out.access = this.access.into()
    out.format = this.format.into()
    out.viewDimension = this.viewDimension.into()
    return out
}

public typealias NativeGPUBindGroupDescriptor = WGPUBindGroupDescriptor

context(Arena)
public fun GPUBindGroupDescriptor.into(`out`: Pointer<NativeGPUBindGroupDescriptor>): Pointer<NativeGPUBindGroupDescriptor> =
    into(NativeGPUBindGroupDescriptor(out)).`$mem`

context(Arena)
public fun GPUBindGroupDescriptor.into(`out`: NativeGPUBindGroupDescriptor = NativeGPUBindGroupDescriptor.allocate(this@Arena)): NativeGPUBindGroupDescriptor {
    this.label.into(out.label)
    out.layout = this.layout.into()
    out.entryCount = this.entries.size.toULong()
    out.entries = allocateList(this.entries) { it.into().`$mem` }
    return out
}

public typealias NativeGPUBindGroupEntry = WGPUBindGroupEntry

context(Arena)
public fun GPUBindGroupEntry.into(`out`: Pointer<NativeGPUBindGroupEntry>): Pointer<NativeGPUBindGroupEntry> =
    into(NativeGPUBindGroupEntry(out)).`$mem`

context(Arena)
public fun GPUBindGroupEntry.into(`out`: NativeGPUBindGroupEntry = NativeGPUBindGroupEntry.allocate(this@Arena)): NativeGPUBindGroupEntry {
    out.binding = this.binding
    when (val resource = this.resource) {
        is GPUSampler -> {
            out.sampler = resource.into()
        }

        is GPUTextureView -> {
            out.textureView = resource.into()
        }

        is GPUBufferBinding -> {
            resource.into(out)

        }


        is GPUExternalTexture -> TODO("UNIMPLEMENTED")
    }
    return out
}

/**
 * TODO
 */
public typealias NativeGPUBufferBinding = NativeGPUBindGroupEntry

context(Arena)
public fun GPUBufferBinding.into(`out`: Pointer<NativeGPUBufferBinding>): Pointer<NativeGPUBufferBinding> =
    into(NativeGPUBufferBinding(out)).`$mem`

context(Arena)
public fun GPUBufferBinding.into(`out`: NativeGPUBufferBinding): NativeGPUBufferBinding {
    out.buffer = buffer.into()
    out.offset = offset
    size?.let { out.size = it }
    return out
}

public typealias NativeGPUPipelineLayoutDescriptor = WGPUPipelineLayoutDescriptor

context(Arena)
public fun GPUPipelineLayoutDescriptor.into(`out`: Pointer<NativeGPUPipelineLayoutDescriptor>): Pointer<NativeGPUPipelineLayoutDescriptor> =
    into(NativeGPUPipelineLayoutDescriptor(out)).`$mem`

context(Arena)
public fun GPUPipelineLayoutDescriptor.into(
    `out`: NativeGPUPipelineLayoutDescriptor = NativeGPUPipelineLayoutDescriptor.allocate(
        this@Arena
    )
): NativeGPUPipelineLayoutDescriptor {
    this.label.into(out.label)
    out.bindGroupLayoutCount = this.bindGroupLayouts.size.toULong()
    out.bindGroupLayouts = allocateList(this.bindGroupLayouts) { it?.into() ?: MemorySegment.NULL }
    return out
}

public typealias NativeGPUShaderModuleDescriptor = WGPUShaderModuleDescriptor

context(Arena)
public fun GPUShaderModuleDescriptor.into(`out`: Pointer<NativeGPUShaderModuleDescriptor>): Pointer<NativeGPUShaderModuleDescriptor> =
    into(NativeGPUShaderModuleDescriptor(out)).`$mem`

context(Arena)
public fun GPUShaderModuleDescriptor.into(
    `out`: NativeGPUShaderModuleDescriptor = NativeGPUShaderModuleDescriptor.allocate(
        this@Arena
    )
): NativeGPUShaderModuleDescriptor {
    this.label.into(out.label)
    // todo: no interop for this.code
    // todo: no interop for this.compilationHints
    return out
}


public typealias NativeGPUComputePipelineDescriptor = WGPUComputePipelineDescriptor

context(Arena)
public fun GPUComputePipelineDescriptor.into(`out`: Pointer<NativeGPUComputePipelineDescriptor>): Pointer<NativeGPUComputePipelineDescriptor> =
    into(NativeGPUComputePipelineDescriptor(out)).`$mem`

context(Arena)
public fun GPUComputePipelineDescriptor.into(
    `out`: NativeGPUComputePipelineDescriptor = NativeGPUComputePipelineDescriptor.allocate(
        this@Arena
    )
): NativeGPUComputePipelineDescriptor {
    this.label.into(out.label)
    out.layout = this.layout?.into() ?: MemorySegment.NULL
    this.compute.into(out.compute)
    return out
}

public typealias NativeGPURenderPipelineDescriptor = WGPURenderPipelineDescriptor

context(Arena)
public fun GPURenderPipelineDescriptor.into(`out`: Pointer<NativeGPURenderPipelineDescriptor>): Pointer<NativeGPURenderPipelineDescriptor> =
    into(NativeGPURenderPipelineDescriptor(out)).`$mem`

context(Arena)
public fun GPURenderPipelineDescriptor.into(
    `out`: NativeGPURenderPipelineDescriptor = NativeGPURenderPipelineDescriptor.allocate(
        this@Arena
    )
): NativeGPURenderPipelineDescriptor {
    this.label.into(out.label)
    out.layout = this.layout?.into() ?: MemorySegment.NULL
    this.vertex.into(out.vertex)
    this.primitive.into(out.primitive)
    this.depthStencil?.into(out.depthStencil)
    this.multisample.into(out.multisample)
    this.fragment?.into(out.fragment)
    return out
}

public typealias NativeGPUPrimitiveState = WGPUPrimitiveState

context(Arena)
public fun GPUPrimitiveState.into(`out`: Pointer<NativeGPUPrimitiveState>): Pointer<NativeGPUPrimitiveState> =
    into(NativeGPUPrimitiveState(out)).`$mem`

context(Arena)
public fun GPUPrimitiveState.into(`out`: NativeGPUPrimitiveState = NativeGPUPrimitiveState.allocate(this@Arena)): NativeGPUPrimitiveState {
    out.topology = this.topology.into()
    out.stripIndexFormat = this.stripIndexFormat?.into() ?: WGPUIndexFormat.Undefined
    out.frontFace = this.frontFace.into()
    out.cullMode = this.cullMode.into()
    this.unclippedDepth.into(out.unclippedDepth)
    return out
}

public typealias NativeGPUMultisampleState = WGPUMultisampleState

context(Arena)
public fun GPUMultisampleState.into(`out`: Pointer<NativeGPUMultisampleState>): Pointer<NativeGPUMultisampleState> =
    into(NativeGPUMultisampleState(out)).`$mem`

context(Arena)
public fun GPUMultisampleState.into(`out`: NativeGPUMultisampleState = NativeGPUMultisampleState.allocate(this@Arena)): NativeGPUMultisampleState {
    out.count = this.count
    out.mask = this.mask
    this.alphaToCoverageEnabled.into(out.alphaToCoverageEnabled)
    return out
}

public typealias NativeGPUFragmentState = WGPUFragmentState

context(Arena)
public fun GPUFragmentState.into(`out`: Pointer<NativeGPUFragmentState>): Pointer<NativeGPUFragmentState> =
    into(NativeGPUFragmentState(out)).`$mem`

context(Arena)
public fun GPUFragmentState.into(`out`: NativeGPUFragmentState = NativeGPUFragmentState.allocate(this@Arena)): NativeGPUFragmentState {
    out.module = this.module.into()
    this.entryPoint?.into(out.entryPoint)
    out.constantCount = this.constants.size.toULong()
    out.constants = allocateList(this.constants) { it.into().`$mem` }
    out.targetCount = this.targets.size.toULong()
    out.targets = allocateList(this.targets) { it?.into()?.`$mem` ?: MemorySegment.NULL }
    return out
}

public typealias NativeGPUColorTargetState = WGPUColorTargetState

context(Arena)
public fun GPUColorTargetState.into(`out`: Pointer<NativeGPUColorTargetState>): Pointer<NativeGPUColorTargetState> =
    into(NativeGPUColorTargetState(out)).`$mem`

context(Arena)
public fun GPUColorTargetState.into(`out`: NativeGPUColorTargetState = NativeGPUColorTargetState.allocate(this@Arena)): NativeGPUColorTargetState {
    out.format = this.format.into()
    this.blend?.into(out.blend)
    out.writeMask = this.writeMask.toULong()
    return out
}

public typealias NativeGPUBlendState = WGPUBlendState

context(Arena)
public fun GPUBlendState.into(`out`: Pointer<NativeGPUBlendState>): Pointer<NativeGPUBlendState> =
    into(NativeGPUBlendState(out)).`$mem`

context(Arena)
public fun GPUBlendState.into(`out`: NativeGPUBlendState = NativeGPUBlendState.allocate(this@Arena)): NativeGPUBlendState {
    this.color.into(out.color)
    this.alpha.into(out.alpha)
    return out
}

public typealias NativeGPUBlendComponent = WGPUBlendComponent

context(Arena)
public fun GPUBlendComponent.into(`out`: Pointer<NativeGPUBlendComponent>): Pointer<NativeGPUBlendComponent> =
    into(NativeGPUBlendComponent(out)).`$mem`

context(Arena)
public fun GPUBlendComponent.into(`out`: NativeGPUBlendComponent = NativeGPUBlendComponent.allocate(this@Arena)): NativeGPUBlendComponent {
    out.operation = this.operation.into()
    out.srcFactor = this.srcFactor.into()
    out.dstFactor = this.dstFactor.into()
    return out
}

public typealias NativeGPUDepthStencilState = WGPUDepthStencilState

context(Arena)
public fun GPUDepthStencilState.into(`out`: Pointer<NativeGPUDepthStencilState>): Pointer<NativeGPUDepthStencilState> =
    into(NativeGPUDepthStencilState(out)).`$mem`

context(Arena)
public fun GPUDepthStencilState.into(`out`: NativeGPUDepthStencilState = NativeGPUDepthStencilState.allocate(this@Arena)): NativeGPUDepthStencilState {
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

public typealias NativeGPUStencilFaceState = WGPUStencilFaceState

context(Arena)
public fun GPUStencilFaceState.into(`out`: Pointer<NativeGPUStencilFaceState>): Pointer<NativeGPUStencilFaceState> =
    into(NativeGPUStencilFaceState(out)).`$mem`

context(Arena)
public fun GPUStencilFaceState.into(`out`: NativeGPUStencilFaceState = NativeGPUStencilFaceState.allocate(this@Arena)): NativeGPUStencilFaceState {
    out.compare = this.compare.into()
    out.failOp = this.failOp.into()
    out.depthFailOp = this.depthFailOp.into()
    out.passOp = this.passOp.into()
    return out
}

public typealias NativeGPUVertexState = WGPUVertexState

context(Arena)
public fun GPUVertexState.into(`out`: Pointer<NativeGPUVertexState>): Pointer<NativeGPUVertexState> =
    into(NativeGPUVertexState(out)).`$mem`

context(Arena)
public fun GPUVertexState.into(`out`: NativeGPUVertexState = NativeGPUVertexState.allocate(this@Arena)): NativeGPUVertexState {
    out.module = this.module.into()
    this.entryPoint?.into(out.entryPoint)
    out.constantCount = this.constants.size.toULong()
    out.constants = allocateList(this.constants) { it.into().`$mem` }
    out.bufferCount = this.buffers.size.toULong()
    out.buffers = allocateList(this.buffers) { it?.into()?.`$mem` ?: MemorySegment.NULL }
    return out
}

public typealias NativeGPUVertexBufferLayout = WGPUVertexBufferLayout

context(Arena)
public fun GPUVertexBufferLayout.into(`out`: Pointer<NativeGPUVertexBufferLayout>): Pointer<NativeGPUVertexBufferLayout> =
    into(NativeGPUVertexBufferLayout(out)).`$mem`

context(Arena)
public fun GPUVertexBufferLayout.into(`out`: NativeGPUVertexBufferLayout = NativeGPUVertexBufferLayout.allocate(this@Arena)): NativeGPUVertexBufferLayout {
    out.arrayStride = this.arrayStride
    out.stepMode = this.stepMode.into()
    out.attributeCount = this.attributes.size.toULong()
    out.attributes = allocateList(this.attributes) { it.into().`$mem` }
    return out
}

public typealias NativeGPUVertexAttribute = WGPUVertexAttribute

context(Arena)
public fun GPUVertexAttribute.into(`out`: Pointer<NativeGPUVertexAttribute>): Pointer<NativeGPUVertexAttribute> =
    into(NativeGPUVertexAttribute(out)).`$mem`

context(Arena)
public fun GPUVertexAttribute.into(`out`: NativeGPUVertexAttribute = NativeGPUVertexAttribute.allocate(this@Arena)): NativeGPUVertexAttribute {
    out.format = this.format.into()
    out.offset = this.offset
    out.shaderLocation = this.shaderLocation
    return out
}

public typealias NativeGPUTexelCopyBufferInfo = WGPUTexelCopyBufferInfo

context(Arena)
public fun GPUTexelCopyBufferInfo.into(`out`: Pointer<NativeGPUTexelCopyBufferInfo>): Pointer<NativeGPUTexelCopyBufferInfo> =
    into(NativeGPUTexelCopyBufferInfo(out)).`$mem`

context(Arena)
public fun GPUTexelCopyBufferInfo.into(`out`: NativeGPUTexelCopyBufferInfo = NativeGPUTexelCopyBufferInfo.allocate(this@Arena)): NativeGPUTexelCopyBufferInfo {
    out.layout.offset = this.offset
    this.bytesPerRow?.let { out.layout.bytesPerRow = it }
    this.rowsPerImage?.let { out.layout.rowsPerImage = it }
    out.buffer = this.buffer.into()
    return out
}

public typealias NativeGPUTexelCopyTextureInfo = WGPUTexelCopyTextureInfo

context(Arena)
public fun GPUTexelCopyTextureInfo.into(`out`: Pointer<NativeGPUTexelCopyTextureInfo>): Pointer<NativeGPUTexelCopyTextureInfo> =
    into(NativeGPUTexelCopyTextureInfo(out)).`$mem`

context(Arena)
public fun GPUTexelCopyTextureInfo.into(
    `out`: NativeGPUTexelCopyTextureInfo = NativeGPUTexelCopyTextureInfo.allocate(
        this@Arena
    )
): NativeGPUTexelCopyTextureInfo {
    out.texture = this.texture.into()
    out.mipLevel = this.mipLevel
    this.origin.into(out.origin)
    out.aspect = this.aspect.into()
    return out
}

public typealias NativeGPUCommandBufferDescriptor = WGPUCommandBufferDescriptor

context(Arena)
public fun GPUCommandBufferDescriptor.into(`out`: Pointer<NativeGPUCommandBufferDescriptor>): Pointer<NativeGPUCommandBufferDescriptor> =
    into(NativeGPUCommandBufferDescriptor(out)).`$mem`

context(Arena)
public fun GPUCommandBufferDescriptor.into(
    `out`: NativeGPUCommandBufferDescriptor = NativeGPUCommandBufferDescriptor.allocate(
        this@Arena
    )
): NativeGPUCommandBufferDescriptor {
    this.label.into(out.label)
    return out
}

public typealias NativeGPUCommandEncoderDescriptor = WGPUCommandEncoderDescriptor

context(Arena)
public fun GPUCommandEncoderDescriptor.into(`out`: Pointer<NativeGPUCommandEncoderDescriptor>): Pointer<NativeGPUCommandEncoderDescriptor> =
    into(NativeGPUCommandEncoderDescriptor(out)).`$mem`

context(Arena)
public fun GPUCommandEncoderDescriptor.into(
    `out`: NativeGPUCommandEncoderDescriptor = NativeGPUCommandEncoderDescriptor.allocate(
        this@Arena
    )
): NativeGPUCommandEncoderDescriptor {
    this.label.into(out.label)
    return out
}

/**
 * TODO
 */
public typealias NativeGPUComputePassTimestampWrites = WGPUPassTimestampWrites


context(Arena)
public fun GPUComputePassTimestampWrites.into(
    `out`: NativeGPUComputePassTimestampWrites = NativeGPUComputePassTimestampWrites.allocate(
        this@Arena
    )
): NativeGPUComputePassTimestampWrites {
    out.querySet = this.querySet.into()
    this.beginningOfPassWriteIndex?.let { out.beginningOfPassWriteIndex = it }
    this.endOfPassWriteIndex?.let { out.endOfPassWriteIndex = it }

    return out
}

public typealias NativeGPUComputePassDescriptor = WGPUComputePassDescriptor

context(Arena)
public fun GPUComputePassDescriptor.into(`out`: Pointer<NativeGPUComputePassDescriptor>): Pointer<NativeGPUComputePassDescriptor> =
    into(NativeGPUComputePassDescriptor(out)).`$mem`

context(Arena)
public fun GPUComputePassDescriptor.into(
    `out`: NativeGPUComputePassDescriptor = NativeGPUComputePassDescriptor.allocate(
        this@Arena
    )
): NativeGPUComputePassDescriptor {
    this.label.into(out.label)
    out.timestampWrites = this.timestampWrites?.into()?.`$mem` ?: MemorySegment.NULL
    return out
}

/**
 * TODO
 */
public typealias NativeGPURenderPassTimestampWrites = WGPUPassTimestampWrites

context(Arena)
public fun GPURenderPassTimestampWrites.into(
    `out`: NativeGPURenderPassTimestampWrites = NativeGPURenderPassTimestampWrites.allocate(
        this@Arena
    )
): NativeGPURenderPassTimestampWrites {
    out.querySet = this.querySet.into()
    this.beginningOfPassWriteIndex?.let { out.beginningOfPassWriteIndex = it }
    this.endOfPassWriteIndex?.let { out.endOfPassWriteIndex = it }
    return out
}

public typealias NativeGPURenderPassDescriptor = WGPURenderPassDescriptor

context(Arena)
public fun GPURenderPassDescriptor.into(`out`: Pointer<NativeGPURenderPassDescriptor>): Pointer<NativeGPURenderPassDescriptor> =
    into(NativeGPURenderPassDescriptor(out)).`$mem`

context(Arena)
public fun GPURenderPassDescriptor.into(
    `out`: NativeGPURenderPassDescriptor = NativeGPURenderPassDescriptor.allocate(
        this@Arena
    )
): NativeGPURenderPassDescriptor {
    this.label.into(out.label)
    out.colorAttachmentCount = this.colorAttachments.size.toULong()
    out.colorAttachments = allocateList(this.colorAttachments) { it?.into()?.`$mem` ?: MemorySegment.NULL }
    this.depthStencilAttachment?.into(out.depthStencilAttachment)
    out.occlusionQuerySet = this.occlusionQuerySet?.into() ?: MemorySegment.NULL
    out.timestampWrites = this.timestampWrites?.into()?.`$mem` ?: MemorySegment.NULL

    val maxDrawCountDesc = WGPURenderPassMaxDrawCount.allocate(this@Arena)
    maxDrawCountDesc.chain.sType = WGPUSType.RenderPassMaxDrawCount
    maxDrawCountDesc.maxDrawCount = this.maxDrawCount
    out.nextInChain = maxDrawCountDesc.`$mem`

    return out
}

public typealias NativeGPURenderPassColorAttachment = WGPURenderPassColorAttachment

context(Arena)
public fun GPURenderPassColorAttachment.into(`out`: Pointer<NativeGPURenderPassColorAttachment>): Pointer<NativeGPURenderPassColorAttachment> =
    into(NativeGPURenderPassColorAttachment(out)).`$mem`

context(Arena)
public fun GPURenderPassColorAttachment.into(
    `out`: NativeGPURenderPassColorAttachment = NativeGPURenderPassColorAttachment.allocate(
        this@Arena
    )
): NativeGPURenderPassColorAttachment {
    out.view = this.view.into()
    out.depthSlice = this.depthSlice ?: 0u
    out.resolveTarget = this.resolveTarget?.into() ?: MemorySegment.NULL
    this.clearValue?.into(out.clearValue)
    out.loadOp = this.loadOp.into()
    out.storeOp = this.storeOp.into()
    return out
}

public typealias NativeGPURenderPassDepthStencilAttachment = WGPURenderPassDepthStencilAttachment

context(Arena)
public fun GPURenderPassDepthStencilAttachment.into(`out`: Pointer<NativeGPURenderPassDepthStencilAttachment>): Pointer<NativeGPURenderPassDepthStencilAttachment> =
    into(NativeGPURenderPassDepthStencilAttachment(out)).`$mem`

context(Arena)
public fun GPURenderPassDepthStencilAttachment.into(
    `out`: NativeGPURenderPassDepthStencilAttachment = NativeGPURenderPassDepthStencilAttachment.allocate(
        this@Arena
    )
): NativeGPURenderPassDepthStencilAttachment {
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

public typealias NativeGPURenderBundleDescriptor = WGPURenderBundleDescriptor

context(Arena)
public fun GPURenderBundleDescriptor.into(`out`: Pointer<NativeGPURenderBundleDescriptor>): Pointer<NativeGPURenderBundleDescriptor> =
    into(NativeGPURenderBundleDescriptor(out)).`$mem`

context(Arena)
public fun GPURenderBundleDescriptor.into(
    `out`: NativeGPURenderBundleDescriptor = NativeGPURenderBundleDescriptor.allocate(
        this@Arena
    )
): NativeGPURenderBundleDescriptor {
    this.label.into(out.label)
    return out
}

public typealias NativeGPURenderBundleEncoderDescriptor = WGPURenderBundleEncoderDescriptor

context(Arena)
public fun GPURenderBundleEncoderDescriptor.into(`out`: Pointer<NativeGPURenderBundleEncoderDescriptor>): Pointer<NativeGPURenderBundleEncoderDescriptor> =
    into(NativeGPURenderBundleEncoderDescriptor(out)).`$mem`

context(Arena)
public fun GPURenderBundleEncoderDescriptor.into(
    `out`: NativeGPURenderBundleEncoderDescriptor = NativeGPURenderBundleEncoderDescriptor.allocate(
        this@Arena
    )
): NativeGPURenderBundleEncoderDescriptor {
    this.label.into(out.label)
    out.colorFormatCount = this.colorFormats.size.toULong()
    out.colorFormats =
        allocateFrom(ValueLayout.JAVA_INT, *this.colorFormats.map { it?.interop?.value ?: 0 }.toIntArray())
    out.depthStencilFormat = this.depthStencilFormat?.into() ?: WGPUTextureFormat.Undefined
    out.sampleCount = this.sampleCount
    this.depthReadOnly.into(out.depthReadOnly)
    this.stencilReadOnly.into(out.stencilReadOnly)
    return out
}

public typealias NativeGPUQueueDescriptor = WGPUQueueDescriptor

context(Arena)
public fun GPUQueueDescriptor.into(`out`: Pointer<NativeGPUQueueDescriptor>): Pointer<NativeGPUQueueDescriptor> =
    into(NativeGPUQueueDescriptor(out)).`$mem`

context(Arena)
public fun GPUQueueDescriptor.into(`out`: NativeGPUQueueDescriptor = NativeGPUQueueDescriptor.allocate(this@Arena)): NativeGPUQueueDescriptor {
    this.label.into(out.label)
    return out
}

public typealias NativeGPUQuerySetDescriptor = WGPUQuerySetDescriptor

context(Arena)
public fun GPUQuerySetDescriptor.into(`out`: Pointer<NativeGPUQuerySetDescriptor>): Pointer<NativeGPUQuerySetDescriptor> =
    into(NativeGPUQuerySetDescriptor(out)).`$mem`

context(Arena)
public fun GPUQuerySetDescriptor.into(`out`: NativeGPUQuerySetDescriptor = NativeGPUQuerySetDescriptor.allocate(this@Arena)): NativeGPUQuerySetDescriptor {
    this.label.into(out.label)
    out.type = this.type.into()
    out.count = this.count
    return out
}

public typealias NativeGPUColor = WGPUColor

context(Arena)
public fun GPUColor.into(`out`: Pointer<NativeGPUColor>): Pointer<NativeGPUColor> = into(NativeGPUColor(out)).`$mem`

context(Arena)
public fun GPUColor.into(`out`: NativeGPUColor = NativeGPUColor.allocate(this@Arena)): NativeGPUColor {
    out.r = this.r
    out.g = this.g
    out.b = this.b
    out.a = this.a
    return out
}

public typealias NativeGPUOrigin3D = WGPUOrigin3D

context(Arena)
public fun GPUOrigin3D.into(`out`: Pointer<NativeGPUOrigin3D>): Pointer<NativeGPUOrigin3D> =
    into(NativeGPUOrigin3D(out)).`$mem`

context(Arena)
public fun GPUOrigin3D.into(`out`: NativeGPUOrigin3D = NativeGPUOrigin3D.allocate(this@Arena)): NativeGPUOrigin3D {
    out.x = this.x
    out.y = this.y
    out.z = this.z
    return out
}

public typealias NativeGPUExtent3D = WGPUExtent3D

context(Arena)
public fun GPUExtent3D.into(`out`: Pointer<NativeGPUExtent3D>): Pointer<NativeGPUExtent3D> =
    into(NativeGPUExtent3D(out)).`$mem`

context(Arena)
public fun GPUExtent3D.into(`out`: NativeGPUExtent3D = NativeGPUExtent3D.allocate(this@Arena)): NativeGPUExtent3D {
    out.width = this.width
    out.height = this.height
    out.depthOrArrayLayers = this.depthOrArrayLayers
    return out
}

public typealias NativeGPULimits = WGPULimits

context(Arena)
public fun GPULimits.into(`out`: Pointer<NativeGPULimits>): Pointer<NativeGPULimits> = into(NativeGPULimits(out)).`$mem`

context(Arena)
public fun GPULimits.into(`out`: NativeGPULimits = NativeGPULimits.allocate(this@Arena)): NativeGPULimits {
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
