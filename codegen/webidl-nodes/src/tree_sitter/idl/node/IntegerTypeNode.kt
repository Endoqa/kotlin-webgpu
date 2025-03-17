package tree_sitter.idl.node

import tree_sitter.Node

public sealed interface IntegerTypeNodeBase : IDLTSBaseNode {
    public companion object {
        public operator fun invoke(node: Node): IntegerTypeNodeBase {
            val n = createNode(node)
            if (n is IntegerTypeNodeBase) {
                return n
            }
            throw IllegalArgumentException("Node is not a IntegerTypeNodeBase")
        }
    }
}

public class IntegerTypeNode(
    override val `$node`: Node,
) : IDLTSBaseNode,
    PrimitiveTypeNode {
    public val base: List<IntegerTypeNodeBase>
        get() = useCursor { cursor ->
            `$node`.childrenByFieldName("base", cursor)
                .asSequence()
                .map { IntegerTypeNodeBase(it) }
                .toList()
        }

    public val unsigned: IDLTSBaseNode.Unnamed?
        get() = (`$node`.getChildByFieldName("unsigned"))?.let { IDLTSBaseNode.Unnamed(it) }
}
