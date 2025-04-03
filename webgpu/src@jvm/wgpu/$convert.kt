package wgpu

import lib.wgpu.*
import java.lang.foreign.Arena
import java.lang.foreign.MemoryLayout
import java.lang.foreign.MemorySegment
import java.lang.foreign.ValueLayout

// this file contains hardcoded for basic structure, and some edge cases


// hardcoded

context(Arena)
internal fun GPUBindingResource.into(out: NativeGPUBindGroupEntry) {
    when (val resource = this) {
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
}

internal typealias NativeGPUTexelCopyBufferInfo = WGPUTexelCopyBufferInfo

context(Arena)
internal fun GPUTexelCopyBufferInfo.into(`out`: Pointer<NativeGPUTexelCopyBufferInfo>): NativeGPUTexelCopyBufferInfo =
    into()

context(Arena)
internal fun GPUTexelCopyBufferInfo.into(`out`: NativeGPUTexelCopyBufferInfo = NativeGPUTexelCopyBufferInfo.allocate(this@Arena)): NativeGPUTexelCopyBufferInfo {
    out.layout.offset = this.offset
    this.bytesPerRow?.let { out.layout.bytesPerRow = it }
    this.rowsPerImage?.let { out.layout.rowsPerImage = it }
    out.buffer = this.buffer.into()
    return out
}

internal typealias NativeGPUComputePassTimestampWrites = WGPUPassTimestampWrites


context(Arena)
internal fun GPUComputePassTimestampWrites.into(
    `out`: NativeGPUComputePassTimestampWrites = NativeGPUComputePassTimestampWrites.allocate(
        this@Arena
    )
): NativeGPUComputePassTimestampWrites {
    out.querySet = this.querySet.into()
    this.beginningOfPassWriteIndex?.let { out.beginningOfPassWriteIndex = it }
    this.endOfPassWriteIndex?.let { out.endOfPassWriteIndex = it }

    return out
}

internal typealias NativeGPUBufferBinding = NativeGPUBindGroupEntry

context(Arena)
internal fun GPUBufferBinding.into(`out`: NativeGPUBufferBinding): NativeGPUBufferBinding {
    out.buffer = buffer.into()
    out.offset = offset
    size?.let { out.size = it }
    return out
}

internal typealias NativeGPURenderPassTimestampWrites = WGPUPassTimestampWrites

context(Arena)
internal fun GPURenderPassTimestampWrites.into(
    `out`: NativeGPURenderPassTimestampWrites = NativeGPURenderPassTimestampWrites.allocate(
        this@Arena
    )
): NativeGPURenderPassTimestampWrites {
    out.querySet = this.querySet.into()
    this.beginningOfPassWriteIndex?.let { out.beginningOfPassWriteIndex = it }
    this.endOfPassWriteIndex?.let { out.endOfPassWriteIndex = it }
    return out
}


context(Arena)
internal fun GPUProgrammableStage.into(out: WGPUComputeState) {
    out.module = this.module.into()
    this.entryPoint?.into(out.entryPoint)
    out.constants = allocateList(this.constants) { it.into().`$mem` }
}

// string and bools

context(Arena)
internal fun String.into(view: WGPUStringView = WGPUStringView.allocate(this@Arena)): WGPUStringView {
    if (this.isEmpty()) {
        view.data = MemorySegment.NULL
        view.length = 0u
        return view
    }


    val bytes = allocateFrom(this)
    view.data = bytes
    view.length = (bytes.byteSize() - 1).toULong()
    return view
}

internal fun String.into(level: WGPUFeatureLevel): WGPUFeatureLevel {
    return WGPUFeatureLevel.entries.first { it.name.equals(this, ignoreCase = true) }
}

internal fun Boolean.into(bool: WGPUBool): WGPUBool {
    return if (this) {
        1u
    } else {
        0u
    }
}


internal fun String.Companion.from(view: WGPUStringView): String {
    return view.data.reinterpret(view.length.toLong()).toArray(ValueLayout.JAVA_BYTE).decodeToString()
}

internal fun Boolean?.into(): WGPUOptionalBool {
    if (this == null) {
        return WGPUOptionalBool.Undefined
    }

    return if (this) {
        WGPUOptionalBool.True
    } else {
        WGPUOptionalBool.False
    }
}


// lists, maps

context(Arena)
internal fun <T> allocateList(
    list: List<T>,
    converter: Arena.(T) -> MemorySegment,
): MemorySegment {
    val a = allocate(ValueLayout.ADDRESS, list.size.toLong())
    list.forEachIndexed { index, t ->
        a.setAtIndex(ValueLayout.ADDRESS, index.toLong(), converter(this@Arena, t))
    }
    return a
}

context(Arena)
internal fun <T, N> allocateList(
    list: List<T>,
    layout: MemoryLayout,
    mapper: (MemorySegment) -> N,
    converter: context(Arena) (T, N) -> Unit,
): MemorySegment {
    val a = allocate(layout, list.size.toLong())

    list.forEachIndexed { index, t ->
        val seg = a.asSlice(index.toLong(), layout.byteSize())
        val n = mapper(seg)
        converter(this@Arena, t, n)

    }

    return a
}


context(Arena)
internal fun <K, V, N> allocateList(
    list: Map<K, V>,
    layout: MemoryLayout,
    mapper: (MemorySegment) -> N,
    converter: context(Arena) (Map.Entry<K, V>, N) -> Unit,
): MemorySegment {
    val a = allocate(layout, list.size.toLong())

    list.entries.forEachIndexed { index, t ->
        val seg = a.asSlice(index.toLong(), layout.byteSize())
        val n = mapper(seg)
        converter(this@Arena, t, n)

    }

    return a
}


context(Arena)
internal fun <K, V> allocateList(
    list: Map<K, V>,
    converter: Arena.(Map.Entry<K, V>) -> MemorySegment,
): MemorySegment {
    val a = allocate(ValueLayout.ADDRESS, list.size.toLong())
    list.entries.forEachIndexed { index, t ->
        a.setAtIndex(ValueLayout.ADDRESS, index.toLong(), converter(this@Arena, t))
    }
    return a
}

context(Arena)
internal fun Map.Entry<String, GPUPipelineConstantValue>.into(out: WGPUConstantEntry = WGPUConstantEntry.allocate(this@Arena)): WGPUConstantEntry {
    out.key = key.into()
    out.value = value
    return out
}

