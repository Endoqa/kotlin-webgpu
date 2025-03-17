package tree_sitter.idl.node

import tree_sitter.Node

public sealed interface FloatTypeNodeBase : IDLTSBaseNode {
    public companion object {
        public operator fun invoke(node: Node): FloatTypeNodeBase {
            val n = createNode(node)
            if (n is FloatTypeNodeBase) {
                return n
            }
            throw IllegalArgumentException("Node is not a FloatTypeNodeBase")
        }
    }
}

public class FloatTypeNode(
    override val `$node`: Node,
) : IDLTSBaseNode,
    PrimitiveTypeNode {
    public val base: FloatTypeNodeBase
        get() = FloatTypeNodeBase(
            `$node`.getChildByFieldName("base") ?: error("required field base is null")
        )

    public val unrestricted: IDLTSBaseNode.Unnamed?
        get() = (`$node`.getChildByFieldName("unrestricted"))?.let { IDLTSBaseNode.Unnamed(it) }
}
