package tree_sitter.idl.node

import tree_sitter.Node

public sealed interface _OperationNode : IDLNodeBase, _InterfaceMemberBodyNode,
    _MixinMemberBodyNode, _PartialInterfaceMemberBodyNode {
    public companion object {
        public operator fun invoke(node: Node): _OperationNode {
            val n = createNode(node)
            if (n is _OperationNode) {
                return n
            }
            throw IllegalArgumentException("Node is not a _OperationNode")
        }
    }
}
