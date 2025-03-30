package wgpu

import lib.wgpu.*
import java.lang.foreign.Arena
import java.lang.foreign.MemorySegment
import java.lang.foreign.ValueLayout

// this file contains hardcoded for basic structure, and some edge cases


context(Arena)
internal fun String.into(view: WGPUStringView = WGPUStringView.allocate(this@Arena)): WGPUStringView {
    val bytes = allocateFrom(this)
    view.data = bytes
    view.length = (bytes.byteSize() - 1).toULong()
    return view
}

internal fun String.into(level: WGPUFeatureLevel): WGPUFeatureLevel {
    TODO()
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

context(Arena)
internal fun <T> allocateList(
    list: List<T>,
    converter: Arena.(T) -> MemorySegment,
): MemorySegment {
    val a = allocate(ValueLayout.ADDRESS)
    list.forEachIndexed { index, t ->
        a.setAtIndex(ValueLayout.ADDRESS, index.toLong(), converter(this@Arena, t))
    }
    return a
}

context(Arena)
internal fun <K, V> allocateList(
    list: Map<K, V>,
    converter: Arena.(Map.Entry<K, V>) -> MemorySegment,
): MemorySegment {
    val a = allocate(ValueLayout.ADDRESS)
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