package webgpu

import java.lang.foreign.Arena
import java.lang.foreign.MemorySegment

interface GPUDebugCommandsMixin {
    fun pushDebugGroup(groupLabel: String) {
        Arena.ofConfined().use {
            pushDebugGroup(it.allocateFrom(groupLabel))
        }
    }

    fun pushDebugGroup(c_str: MemorySegment)

    fun popDebugGroup()

    fun insertDebugMarker(markerLabel: String) {
        Arena.ofConfined().use {
            insertDebugMarker(it.allocateFrom(markerLabel))
        }
    }

    fun insertDebugMarker(c_str: MemorySegment)
}