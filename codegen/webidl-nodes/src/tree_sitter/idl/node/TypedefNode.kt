package tree_sitter.idl.node

import tree_sitter.Node

public class TypedefNode(
    override val `$node`: Node,
) : IDLTSBaseNode,
    _DefinitionNode {
    public val attributes: ExtendedAttributeListNode?
        get() = (`$node`.getChildByFieldName("attributes"))?.let { ExtendedAttributeListNode(it) }

    public val name: IdentifierNode
        get() = IdentifierNode(
            `$node`.getChildByFieldName("name") ?: error("required field name is null")
        )

    public val type: TypeWithExtendedAttributesNode
        get() = TypeWithExtendedAttributesNode(
            `$node`.getChildByFieldName("type") ?: error("required field type is null")
        )
}
