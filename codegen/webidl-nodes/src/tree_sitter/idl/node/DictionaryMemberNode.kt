package tree_sitter.idl.node

import tree_sitter.Node

public class DictionaryMemberNode(
    override val `$node`: Node,
) : IDLNodeBase {
    public val attributes: ExtendedAttributeListNode?
        get() = (`$node`.getChildByFieldName("attributes"))?.let { ExtendedAttributeListNode(it) }

    public val default: _DefaultValueNode?
        get() = (`$node`.getChildByFieldName("default"))?.let { _DefaultValueNode(it) }

    public val name: IdentifierNode
        get() = IdentifierNode(
            `$node`.getChildByFieldName("name") ?: error("required field name is null")
        )

    public val type: _TypeNode
        get() = _TypeNode(`$node`.getChildByFieldName("type") ?: error("required field type is null"))
}
