import java.lang.foreign.*
import java.lang.invoke.VarHandle

@JvmInline
value class ShaderData(
    val `$mem`: MemorySegment,
) {
    var scale: Float
        get() = scaleHandle.get(this.`$mem`, 0L) as Float
        set(`value`) {
            scaleHandle.set(this.`$mem`, 0L, value)
        }

    var time: Float
        get() = timeHandle.get(this.`$mem`, 0L) as Float
        set(`value`) {
            timeHandle.set(this.`$mem`, 0L, value)
        }

    var offsetX: Float
        get() = offsetXHandle.get(this.`$mem`, 0L) as Float
        set(`value`) {
            offsetXHandle.set(this.`$mem`, 0L, value)
        }

    var offsetY: Float
        get() = offsetYHandle.get(this.`$mem`, 0L) as Float
        set(`value`) {
            offsetYHandle.set(this.`$mem`, 0L, value)
        }

    var scalar: Float
        get() = scalarHandle.get(this.`$mem`, 0L) as Float
        set(`value`) {
            scalarHandle.set(this.`$mem`, 0L, value)
        }

    var scalarOffset: Float
        get() = scalarOffsetHandle.get(this.`$mem`, 0L) as Float
        set(`value`) {
            scalarOffsetHandle.set(this.`$mem`, 0L, value)
        }

    constructor(gc: Boolean) : this(kotlin.run {
        require(gc) { "Do not call this if gc is not want" }
        Arena.ofAuto().allocate(layout)
    })

    companion object {
        val layout: StructLayout = MemoryLayout.structLayout(
            ValueLayout.JAVA_FLOAT.withName("scale"),
            ValueLayout.JAVA_FLOAT.withName("time"),
            ValueLayout.JAVA_FLOAT.withName("offsetX"),
            ValueLayout.JAVA_FLOAT.withName("offsetY"),
            ValueLayout.JAVA_FLOAT.withName("scalar"),
            ValueLayout.JAVA_FLOAT.withName("scalarOffset"),
            // align to 256
            MemoryLayout.paddingLayout(256 - (ValueLayout.JAVA_FLOAT.byteSize() * 6))
        ).withName("ShaderData")

        @JvmField
        val scaleHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("scale"))

        @JvmField
        val timeHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("time"))

        @JvmField
        val offsetXHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("offsetX"))

        @JvmField
        val offsetYHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("offsetY"))

        @JvmField
        val scalarHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("scalar"))

        @JvmField
        val scalarOffsetHandle: VarHandle =
            layout.varHandle(MemoryLayout.PathElement.groupElement("scalarOffset"))

        @JvmStatic
        fun allocate(alloc: SegmentAllocator): ShaderData = ShaderData(alloc.allocate(layout))
    }
}
