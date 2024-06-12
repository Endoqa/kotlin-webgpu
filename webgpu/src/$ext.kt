import java.lang.foreign.MemorySegment

internal operator fun MemorySegment.not(): Boolean {
    return this == MemorySegment.NULL
}