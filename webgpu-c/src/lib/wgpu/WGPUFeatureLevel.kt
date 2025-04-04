// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType

/**
 * See [WGPURequestAdapterOptions]::featureLevel.
 */
public enum class WGPUFeatureLevel(
    public val `value`: Int,
) {
    /**
     * Indicates no value is passed for this argument. See [SentinelValues](https://webgpu-native.github.io/webgpu-headers/SentinelValues.html).
     */
    Undefined(0x00000000),

    /**
     * "Compatibility" profile which can be supported on OpenGL ES 3.1 and D3D11.
     */
    Compatibility(0x00000001),

    /**
     * "Core" profile which can be supported on Vulkan/Metal/D3D12 (at least).
     */
    Core(0x00000002),
    ;

    public companion object {
        @JvmStatic
        public val fromInt: MethodHandle = MethodHandles.lookup().findStatic(
            WGPUFeatureLevel::class.java,
            "fromInt",
            MethodType.methodType(WGPUFeatureLevel::class.java, Int::class.java)
        )

        @JvmStatic
        public val toInt: MethodHandle = MethodHandles.lookup().findGetter(
            WGPUFeatureLevel::class.java,
            "value",
            Int::class.java
        )

        @JvmStatic
        public fun fromInt(`value`: Int): WGPUFeatureLevel = when (value) {
            Undefined.value -> Undefined
            Compatibility.value -> Compatibility
            Core.value -> Core
            else -> error("enum not found")
        }
    }
}
