package tree_sitter.idl.node

import tree_sitter.Node

public sealed interface PrimitiveTypeNode : IDLNodeBase, _ConstTypeNode, _SingleTypeNode {
    public companion object {
        public operator fun invoke(node: Node): PrimitiveTypeNode {
            val n = createNode(node)
            if (n is PrimitiveTypeNode) {
                return n
            }
            throw IllegalArgumentException("Node is not a PrimitiveTypeNode")
        }
    }
}
