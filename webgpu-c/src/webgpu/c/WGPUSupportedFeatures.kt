// this file is auto generated by endoqa kotlin ffi, modify it with caution
package webgpu.c

import java.lang.foreign.Arena
import java.lang.foreign.MemoryLayout
import java.lang.foreign.MemorySegment
import java.lang.foreign.SegmentAllocator
import java.lang.foreign.StructLayout
import java.lang.foreign.ValueLayout
import java.lang.invoke.VarHandle
import kotlin.Boolean
import kotlin.Long
import kotlin.ULong
import kotlin.jvm.JvmField
import kotlin.jvm.JvmInline
import kotlin.jvm.JvmStatic

@JvmInline
public value class WGPUSupportedFeatures(
    public val `$mem`: MemorySegment,
) {
    public var featureCount: ULong
        get() = (WGPUSupportedFeatures.featureCountHandle.get(this.`$mem`, 0L) as Long).toULong()
        set(`value`) {
            WGPUSupportedFeatures.featureCountHandle.set(this.`$mem`, 0L, value.toLong())
        }

    public var features: Pointer<WGPUFeatureName>
        get() = WGPUSupportedFeatures.featuresHandle.get(this.`$mem`, 0L) as MemorySegment
        set(`value`) {
            WGPUSupportedFeatures.featuresHandle.set(this.`$mem`, 0L, value)
        }

    public constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(WGPUSupportedFeatures.layout)
    })

    public companion object {
        public val layout: StructLayout = MemoryLayout.structLayout(
            ValueLayout.JAVA_LONG.withName("featureCount"),
            `$RuntimeHelper`.POINTER.withName("features"),
        ).withName("WGPUSupportedFeatures")

        @JvmField
        public val featureCountHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("featureCount"))

        @JvmField
        public val featuresHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("features"))

        @JvmStatic
        public fun allocate(alloc: SegmentAllocator): WGPUSupportedFeatures =
            WGPUSupportedFeatures(alloc.allocate(WGPUSupportedFeatures.layout))
    }
}
