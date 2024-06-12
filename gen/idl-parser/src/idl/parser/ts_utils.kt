package idl.parser

import tree_sitter.Pointer
import tree_sitter.TSNode
import tree_sitter.ts_node_end_byte
import tree_sitter.ts_node_start_byte
import java.lang.foreign.Arena
import java.lang.foreign.MemorySegment


private fun TSNode.content(src: Pointer<Byte>): String {
    val startByte = ts_node_start_byte(this)
    val endByte = ts_node_end_byte(this)

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

context(WithSource)
val TSNode.content: String
    get() = content(source)