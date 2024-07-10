package idl.parser

import tree_sitter.Node
import java.lang.foreign.Arena
import java.lang.foreign.MemorySegment


private fun Node.content(src: MemorySegment): String {
    val startByte = this.startByte
    val endByte = this.endByte

    return Arena.ofConfined().use { temp ->
        val content = temp.allocate((endByte - startByte + 1u).toLong())

        MemorySegment.copy(
            src,
            startByte.toLong(),
            content,
            0,
            (endByte - startByte).toLong()
        )


        content.getString(0)
    }


}

context(ParseContext)
val Node.content: String
    get() = content(source)