package tree_sitter.idl.node

import tree_sitter.Node

public class EmptySequenceNode(
    override val `$node`: Node,
) : IDLNodeBase,
    _DefaultValueNode
