package tree_sitter.idl.node

import tree_sitter.Node

public class DecimalNode(
    override val `$node`: Node,
) : IDLNodeBase,
    FloatLiteralNode
