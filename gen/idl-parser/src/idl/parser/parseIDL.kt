package idl.parser

import idl.IDL
import tree_sitter.*
import java.lang.foreign.*


val languageMethod = Linker.nativeLinker().downcallHandle(
    `$RuntimeHelper`.symbolLookup.find("tree_sitter_idl").get(),
    FunctionDescriptor.of(ValueLayout.ADDRESS)
)

val idlLang: Pointer<TSLanguage> = languageMethod.invokeExact() as MemorySegment


interface WithSource {
    val source: Pointer<Byte>
}


context(Arena)
fun parseIDL(source: String): IDL {

    val parser = ts_parser_new()
    ts_parser_set_language(parser, idlLang)


    val sourceCode = allocateFrom(source)
    val tree = ts_parser_parse_string(parser, MemorySegment.NULL, sourceCode, source.length.toUInt())

    val rootNode = ts_tree_root_node(tree)

    val idl = IDL()

    with(object : WithSource {
        override val source: Pointer<Byte>
            get() = sourceCode

    }) {
        for (i in 0u until ts_node_named_child_count(rootNode)) {
            val child = ts_node_named_child(rootNode, i)
            val nodeType = ts_node_type(child).getString(0)

            when (nodeType) {
                "dictionary_declaration" -> {
                    val dict = parseDict(child)
                    idl.roots[dict.name] = dict
                }

                "enum_declaration" -> {
                    val enum = parseEnum(child)
                    idl.roots[enum.name] = enum
                }

                "typedef_declaration" -> {
                    val typedef = parseTypedef(child)
                    idl.roots[typedef.name] = typedef
                }


            }
        }
    }

    return idl
}


