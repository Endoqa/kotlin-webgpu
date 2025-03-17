package tree_sitter.idl.node

import tree_sitter.Node

public class StringNode(
    override val `$node`: Node,
) : IDLTSBaseNode,
    _DefaultValueNode,
    EnumNodeValues
