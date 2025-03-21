package wgpu

public interface GPUDebugCommandsMixin {
    public fun pushDebugGroup(groupLabel: String)

    public fun popDebugGroup()

    public fun insertDebugMarker(markerLabel: String)
}
