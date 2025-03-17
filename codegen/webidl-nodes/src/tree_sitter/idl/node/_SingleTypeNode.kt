package tree_sitter.idl.node

import tree_sitter.Node

public sealed interface _SingleTypeNode : IDLTSBaseNode, _TypeNode {
    public companion object {
        public operator fun invoke(node: Node): _SingleTypeNode {
            val n = createNode(node)
            if (n is _SingleTypeNode) {
                return n
            }
            throw IllegalArgumentException("Node is not a _SingleTypeNode")
        }
    }
}
