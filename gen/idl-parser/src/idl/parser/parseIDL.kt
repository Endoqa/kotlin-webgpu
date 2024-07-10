package idl.parser

import idl.IDL
import tree_sitter.Language
import tree_sitter.Parser
import java.lang.foreign.Arena
import java.lang.foreign.MemorySegment


interface ParseContext {
    val source: MemorySegment
    val types: NodeType
}


context(Arena)
fun parseIDL(source: String): IDL {

    val parser = Parser()
    val idlLang = Language.getLanguage("idl")
    parser.setLanguage(idlLang)


    val sourceCode = allocateFrom(source)
    val tree = parser.parse(source)

    val rootNode = tree.rootNode

    val idl = IDL()

    val nodeType = NodeType(
        dictionary_declaration = idlLang.getSymbolForName("dictionary_declaration", true),
        enum_declaration = idlLang.getSymbolForName("enum_declaration", true),
        typedef_declaration = idlLang.getSymbolForName("typedef_declaration", true),
        string_literal = idlLang.getSymbolForName("string_literal", true),
        number_literal = idlLang.getSymbolForName("number_literal", true),
        hex_literal = idlLang.getSymbolForName("hex_literal", true),
        object_literal = idlLang.getSymbolForName("object_literal", true),
        array_literal = idlLang.getSymbolForName("array_literal", true),
        boolean_literal = idlLang.getSymbolForName("boolean_literal", true),
        primitive_type = idlLang.getSymbolForName("primitive_type", true),
        identifier = idlLang.getSymbolForName("identifier", true),
        parameterized = idlLang.getSymbolForName("parameterized", true)
    )

    val context = object : ParseContext {
        override val source: MemorySegment
            get() = sourceCode

        override val types: NodeType
            get() = nodeType
    }

    with(context) {
        rootNode.namedChildren.forEach { child ->


            when (child.symbol) {
                types.dictionary_declaration -> {
                    val dict = parseDict(child)
                    idl.roots[dict.name] = dict
                }

                types.enum_declaration -> {
                    val enum = parseEnum(child)
                    idl.roots[enum.name] = enum
                }

                types.typedef_declaration -> {
                    val typedef = parseTypedef(child)
                    idl.roots[typedef.name] = typedef
                }


            }
        }
    }

    return idl
}


