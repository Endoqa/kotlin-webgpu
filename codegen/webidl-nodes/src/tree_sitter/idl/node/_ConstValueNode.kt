package tree_sitter.idl.node

import tree_sitter.Node

public sealed interface _ConstValueNode : IDLNodeBase, _DefaultValueNode {
    public companion object {
        public operator fun invoke(node: Node): _ConstValueNode {
            val n = createNode(node)
            if (n is _ConstValueNode) {
                return n
            }
            throw IllegalArgumentException("Node is not a _ConstValueNode")
        }
    }
}
