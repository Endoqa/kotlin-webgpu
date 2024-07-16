package webgpu

object GPUHeapProperty {
    @JvmStatic
    val DeviceLocal: GPUHeapPropertyFlags = 0x0000000000000001u;

    @JvmStatic
    val HostVisible: GPUHeapPropertyFlags = 0x0000000000000002u;

    @JvmStatic
    val HostCoherent: GPUHeapPropertyFlags = 0x0000000000000004u;

    @JvmStatic
    val HostUncached: GPUHeapPropertyFlags = 0x0000000000000008u;

    @JvmStatic
    val HostCached: GPUHeapPropertyFlags = 0x0000000000000010u;
}