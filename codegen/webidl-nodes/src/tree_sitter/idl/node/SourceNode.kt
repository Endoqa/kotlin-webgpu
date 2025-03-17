package tree_sitter.idl.node

import tree_sitter.Node

public sealed interface SourceNodeChildren : IDLTSBaseNode {
    public companion object {
        public operator fun invoke(node: Node): SourceNodeChildren {
            val n = createNode(node)
            if (n is SourceNodeChildren) {
                return n
            }
            throw IllegalArgumentException("Node is not a SourceNodeChildren")
        }
    }
}

public class SourceNode(
    override val `$node`: Node,
) : IDLTSBaseNode {
    public fun children(): List<SourceNodeChildren>? {
        if (`$node`.namedChildCount == 0U) {
            return null
        }
        return `$node`.namedChildren.map {
            SourceNodeChildren(it)
        }
    }
}
