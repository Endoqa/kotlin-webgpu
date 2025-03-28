package tree_sitter.idl.node

import tree_sitter.Node

public class IdentifierNode(
    override val `$node`: Node,
) : IDLNodeBase,
    _ConstTypeNode,
    _SingleTypeNode
