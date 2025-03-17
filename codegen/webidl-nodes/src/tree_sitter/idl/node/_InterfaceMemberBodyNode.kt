package tree_sitter.idl.node

import tree_sitter.Node

public sealed interface _InterfaceMemberBodyNode : IDLTSBaseNode {
    public companion object {
        public operator fun invoke(node: Node): _InterfaceMemberBodyNode {
            val n = createNode(node)
            if (n is _InterfaceMemberBodyNode) {
                return n
            }
            throw IllegalArgumentException("Node is not a _InterfaceMemberBodyNode")
        }
    }
}
