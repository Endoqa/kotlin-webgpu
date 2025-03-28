package tree_sitter.idl.node

import tree_sitter.Node

public class AttributeNode(
    override val `$node`: Node,
) : IDLNodeBase,
    _AttributeNode,
    _NamespaceMemberNode,
    _StaticMemberBodyNode,
    StringifierNodeChildren {
    public val inherit: IDLNodeBase.Unnamed?
        get() = (`$node`.getChildByFieldName("inherit"))?.let { IDLNodeBase.Unnamed(it) }

    public val name: IdentifierNode
        get() = IdentifierNode(
            `$node`.getChildByFieldName("name") ?: error("required field name is null")
        )

    public val readonly: IDLNodeBase.Unnamed?
        get() = (`$node`.getChildByFieldName("readonly"))?.let { IDLNodeBase.Unnamed(it) }

    public val type: TypeWithExtendedAttributesNode
        get() = TypeWithExtendedAttributesNode(
            `$node`.getChildByFieldName("type") ?: error("required field type is null")
        )
}
