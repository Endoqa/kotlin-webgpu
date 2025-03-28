package tree_sitter.idl.node

import tree_sitter.Node

public class IntegerNode(
    override val `$node`: Node,
) : IDLNodeBase,
    _ConstValueNode
