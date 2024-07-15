// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType
import kotlin.Int

public enum class WGPUBufferUsage(
    public val `value`: Int,
) {
    None(0x00000000),
    MapRead(0x00000001),
    MapWrite(0x00000002),
    CopySrc(0x00000004),
    CopyDst(0x00000008),
    Index(0x00000010),
    Vertex(0x00000020),
    Uniform(0x00000040),
    Storage(0x00000080),
    Indirect(0x00000100),
    QueryResolve(0x00000200),
    ;

    public companion object {
        @JvmStatic
        public val fromInt: MethodHandle = MethodHandles.lookup().findStatic(
            WGPUBufferUsage::class.java,
            "fromInt",
            MethodType.methodType(WGPUBufferUsage::class.java, Int::class.java)
        )

        @JvmStatic
        public val toInt: MethodHandle = MethodHandles.lookup().findGetter(
            WGPUBufferUsage::class.java,
            "value",
            Int::class.java
        )

        @JvmStatic
        public fun fromInt(`value`: Int): WGPUBufferUsage = when (value) {
            None.value -> None
            MapRead.value -> MapRead
            MapWrite.value -> MapWrite
            CopySrc.value -> CopySrc
            CopyDst.value -> CopyDst
            Index.value -> Index
            Vertex.value -> Vertex
            Uniform.value -> Uniform
            Storage.value -> Storage
            Indirect.value -> Indirect
            QueryResolve.value -> QueryResolve
            else -> error("enum not found")
        }
    }
}
