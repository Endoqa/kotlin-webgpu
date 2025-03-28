package tree_sitter.idl.node

import tree_sitter.Node

public class StringNode(
    override val `$node`: Node,
) : IDLNodeBase,
    _DefaultValueNode,
    EnumNodeValues
