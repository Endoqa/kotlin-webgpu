package tree_sitter.idl.node

import tree_sitter.Node

public class AttributeNode(
    override val `$node`: Node,
) : IDLTSBaseNode,
    _AttributeNode,
    _NamespaceMemberNode,
    _StaticMemberBodyNode,
    StringifierNodeChildren {
    public val inherit: IDLTSBaseNode.Unnamed?
        get() = (`$node`.getChildByFieldName("inherit"))?.let { IDLTSBaseNode.Unnamed(it) }

    public val name: IdentifierNode
        get() = IdentifierNode(
            `$node`.getChildByFieldName("name") ?: error("required field name is null")
        )

    public val readonly: IDLTSBaseNode.Unnamed?
        get() = (`$node`.getChildByFieldName("readonly"))?.let { IDLTSBaseNode.Unnamed(it) }

    public val type: TypeWithExtendedAttributesNode
        get() = TypeWithExtendedAttributesNode(
            `$node`.getChildByFieldName("type") ?: error("required field type is null")
        )
}
