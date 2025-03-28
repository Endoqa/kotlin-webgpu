package tree_sitter.idl.node

import tree_sitter.Node

public sealed interface _ConstTypeNode : IDLNodeBase {
    public companion object {
        public operator fun invoke(node: Node): _ConstTypeNode {
            val n = createNode(node)
            if (n is _ConstTypeNode) {
                return n
            }
            throw IllegalArgumentException("Node is not a _ConstTypeNode")
        }
    }
}
