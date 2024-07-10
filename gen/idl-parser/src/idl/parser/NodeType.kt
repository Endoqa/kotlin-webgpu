package idl.parser

data class NodeType(
    val dictionary_declaration: UShort,
    val enum_declaration: UShort,
    val typedef_declaration: UShort,
    val string_literal: UShort,
    val number_literal: UShort,
    val hex_literal: UShort,
    val object_literal: UShort,
    val array_literal: UShort,
    val boolean_literal: UShort,
    val primitive_type: UShort,
    val identifier: UShort,
    val parameterized: UShort
)