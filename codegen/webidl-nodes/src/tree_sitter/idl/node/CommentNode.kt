package tree_sitter.idl.node

import tree_sitter.Node

public class CommentNode(
    override val `$node`: Node,
) : IDLNodeBase,
    SourceNodeChildren,
    StringifierNodeChildren
