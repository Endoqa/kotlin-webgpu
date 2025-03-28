package tree_sitter.idl.node

import tree_sitter.Node

public sealed interface _PartialInterfaceMemberBodyNode : IDLNodeBase {
    public companion object {
        public operator fun invoke(node: Node): _PartialInterfaceMemberBodyNode {
            val n = createNode(node)
            if (n is _PartialInterfaceMemberBodyNode) {
                return n
            }
            throw IllegalArgumentException("Node is not a _PartialInterfaceMemberBodyNode")
        }
    }
}
