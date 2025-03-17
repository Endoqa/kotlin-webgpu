package tree_sitter.idl.node

import tree_sitter.Node

public sealed interface _StaticMemberBodyNode : IDLTSBaseNode {
    public companion object {
        public operator fun invoke(node: Node): _StaticMemberBodyNode {
            val n = createNode(node)
            if (n is _StaticMemberBodyNode) {
                return n
            }
            throw IllegalArgumentException("Node is not a _StaticMemberBodyNode")
        }
    }
}
