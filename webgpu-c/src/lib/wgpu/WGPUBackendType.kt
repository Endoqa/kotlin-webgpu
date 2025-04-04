// this file is auto generated by endoqa kotlin ffi, modify it with caution
package lib.wgpu

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType

/**
 * TODO
 */
public enum class WGPUBackendType(
    public val `value`: Int,
) {
    /**
     * Indicates no value is passed for this argument. See [SentinelValues](https://webgpu-native.github.io/webgpu-headers/SentinelValues.html).
     */
    Undefined(0x00000000),

    /**
     * TODO
     */
    Null(0x00000001),

    /**
     * TODO
     */
    WebGPU(0x00000002),

    /**
     * TODO
     */
    D3D11(0x00000003),

    /**
     * TODO
     */
    D3D12(0x00000004),

    /**
     * TODO
     */
    Metal(0x00000005),

    /**
     * TODO
     */
    Vulkan(0x00000006),

    /**
     * TODO
     */
    OpenGL(0x00000007),

    /**
     * TODO
     */
    OpenGLES(0x00000008),
    ;

    public companion object {
        @JvmStatic
        public val fromInt: MethodHandle = MethodHandles.lookup().findStatic(
            WGPUBackendType::class.java,
            "fromInt",
            MethodType.methodType(WGPUBackendType::class.java, Int::class.java)
        )

        @JvmStatic
        public val toInt: MethodHandle = MethodHandles.lookup().findGetter(
            WGPUBackendType::class.java,
            "value",
            Int::class.java
        )

        @JvmStatic
        public fun fromInt(`value`: Int): WGPUBackendType = when (value) {
            Undefined.value -> Undefined
            Null.value -> Null
            WebGPU.value -> WebGPU
            D3D11.value -> D3D11
            D3D12.value -> D3D12
            Metal.value -> Metal
            Vulkan.value -> Vulkan
            OpenGL.value -> OpenGL
            OpenGLES.value -> OpenGLES
            else -> error("enum not found")
        }
    }
}
