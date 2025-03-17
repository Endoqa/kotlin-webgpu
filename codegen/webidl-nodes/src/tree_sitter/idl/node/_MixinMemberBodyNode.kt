package tree_sitter.idl.node

import tree_sitter.Node

public sealed interface _MixinMemberBodyNode : IDLTSBaseNode {
    public companion object {
        public operator fun invoke(node: Node): _MixinMemberBodyNode {
            val n = createNode(node)
            if (n is _MixinMemberBodyNode) {
                return n
            }
            throw IllegalArgumentException("Node is not a _MixinMemberBodyNode")
        }
    }
}
