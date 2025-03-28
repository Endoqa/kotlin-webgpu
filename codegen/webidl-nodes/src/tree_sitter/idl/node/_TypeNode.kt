package tree_sitter.idl.node

import tree_sitter.Node

public sealed interface _TypeNode : IDLNodeBase {
    public companion object {
        public operator fun invoke(node: Node): _TypeNode {
            val n = createNode(node)
            if (n is _TypeNode) {
                return n
            }
            throw IllegalArgumentException("Node is not a _TypeNode")
        }
    }
}
