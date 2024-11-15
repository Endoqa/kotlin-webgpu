// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType
import kotlin.Int
import kotlin.jvm.JvmStatic
import webgpu.c.WGPUPrimitiveTopology.LineList
import webgpu.c.WGPUPrimitiveTopology.LineStrip
import webgpu.c.WGPUPrimitiveTopology.PointList
import webgpu.c.WGPUPrimitiveTopology.TriangleList
import webgpu.c.WGPUPrimitiveTopology.TriangleStrip
import webgpu.c.WGPUPrimitiveTopology.Undefined

public enum class WGPUPrimitiveTopology(
    public val `value`: Int,
) {
    Undefined(0x00000000),
    PointList(0x00000001),
    LineList(0x00000002),
    LineStrip(0x00000003),
    TriangleList(0x00000004),
    TriangleStrip(0x00000005),
    ;

    public companion object {
        @JvmStatic
        public val fromInt: MethodHandle = MethodHandles.lookup().findStatic(
            WGPUPrimitiveTopology::class.java,
            "fromInt",
            MethodType.methodType(WGPUPrimitiveTopology::class.java, Int::class.java)
        )

        @JvmStatic
        public val toInt: MethodHandle = MethodHandles.lookup().findGetter(
            WGPUPrimitiveTopology::class.java,
            "value",
            Int::class.java
        )

        @JvmStatic
        public fun fromInt(`value`: Int): WGPUPrimitiveTopology = when (value) {
            Undefined.value -> Undefined
            PointList.value -> PointList
            LineList.value -> LineList
            LineStrip.value -> LineStrip
            TriangleList.value -> TriangleList
            TriangleStrip.value -> TriangleStrip
            else -> error("enum not found")
        }
    }
}
