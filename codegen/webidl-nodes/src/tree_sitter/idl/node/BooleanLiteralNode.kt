package tree_sitter.idl.node

import tree_sitter.Node

public class BooleanLiteralNode(
    override val `$node`: Node,
) : IDLTSBaseNode,
    _ConstValueNode
