import webgpu.WGPUBool
import java.lang.foreign.Arena
import java.lang.foreign.MemoryLayout
import java.lang.foreign.MemorySegment

internal object Converter {


    inline fun convert(
        ctx: Arena,
        string: String?,
        r: (MemorySegment) -> Unit
    ) {
        if (string.isNullOrEmpty()) {
            r(MemorySegment.NULL)
            return
        }

        val segment = ctx.allocateFrom(string)
        r(segment)
    }

    inline fun <T> convert(
        ctx: Arena,
        dst: (MemorySegment) -> Unit,
        list: List<T>,
        layout: MemoryLayout,
        converter: (T, MemorySegment) -> Unit
    ): ULong {
        return convert(ctx, dst, list, list.size, layout, converter)
    }

    inline fun <T> convert(
        ctx: Arena,
        dst: (MemorySegment) -> Unit,
        list: Set<T>,
        layout: MemoryLayout,
        converter: (T, MemorySegment) -> Unit
    ): ULong {
        return convert(ctx, dst, list, list.size, layout, converter)
    }

    inline fun <T> convert(
        ctx: Arena,
        dst: (MemorySegment) -> Unit,
        list: Iterable<T>,
        size: Int,
        layout: MemoryLayout,
        converter: (T, MemorySegment) -> Unit
    ): ULong {

        if (size == 0) {
            dst(MemorySegment.NULL)
            return 0u
        }

        val array = ctx.allocate(layout, size.toLong())
        dst(array)

        list.forEachIndexed { index, value ->
            val segment = array.asSlice(layout.byteSize() * index)
            converter(value, segment)
        }

        return size.toULong()
    }

    fun convert(boolean: Boolean): WGPUBool {
        return if (boolean) 1u else 0u
    }


}