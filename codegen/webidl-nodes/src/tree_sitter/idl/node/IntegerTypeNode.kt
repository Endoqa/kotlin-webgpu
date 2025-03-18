package tree_sitter.idl.node

import tree_sitter.Node

public class IntegerTypeNode(
    override val `$node`: Node,
) : IDLTSBaseNode,
    PrimitiveTypeNode {
    public val base: BaseIntegerTypeNode
        get() = BaseIntegerTypeNode(
            `$node`.getChildByFieldName("base") ?: error("required field base is null")
        )

    public val unsigned: IDLTSBaseNode.Unnamed?
        get() = (`$node`.getChildByFieldName("unsigned"))?.let { IDLTSBaseNode.Unnamed(it) }
}
