package tree_sitter.idl.node

import tree_sitter.Node

public sealed interface FloatTypeNodeBase : IDLNodeBase {
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
) : IDLNodeBase,
    PrimitiveTypeNode {
    public val base: FloatTypeNodeBase
        get() = FloatTypeNodeBase(
            `$node`.getChildByFieldName("base") ?: error("required field base is null")
        )

    public val unrestricted: IDLNodeBase.Unnamed?
        get() = (`$node`.getChildByFieldName("unrestricted"))?.let { IDLNodeBase.Unnamed(it) }
}
