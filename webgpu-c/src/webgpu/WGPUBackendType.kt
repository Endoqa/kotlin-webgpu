// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType
import kotlin.Int

public enum class WGPUBackendType(
    public val `value`: Int,
) {
    Undefined(0x00000000),
    Null(0x00000001),
    WebGPU(0x00000002),
    D3D11(0x00000003),
    D3D12(0x00000004),
    Metal(0x00000005),
    Vulkan(0x00000006),
    OpenGL(0x00000007),
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
