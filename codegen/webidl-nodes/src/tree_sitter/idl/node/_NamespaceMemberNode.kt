package tree_sitter.idl.node

import tree_sitter.Node

public sealed interface _NamespaceMemberNode : IDLNodeBase {
    public companion object {
        public operator fun invoke(node: Node): _NamespaceMemberNode {
            val n = createNode(node)
            if (n is _NamespaceMemberNode) {
                return n
            }
            throw IllegalArgumentException("Node is not a _NamespaceMemberNode")
        }
    }
}
