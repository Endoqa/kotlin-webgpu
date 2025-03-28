package tree_sitter.idl.node

import tree_sitter.Node

public sealed interface IDLNodeBase {
    public val `$node`: Node

    public class Unnamed(
        override val `$node`: Node,
    ) : IDLNodeBase,
        _DefaultValueNode,
        _SingleTypeNode,
        FloatLiteralNode,
        PrimitiveTypeNode,
        EnumNodeValues,
        FloatTypeNodeBase
}
