package tree_sitter.idl.node

import tree_sitter.Node

public class TypeWithExtendedAttributesNode(
    override val `$node`: Node,
) : IDLNodeBase {
    public val attributes: ExtendedAttributeListNode?
        get() = (`$node`.getChildByFieldName("attributes"))?.let { ExtendedAttributeListNode(it) }

    public val type: _TypeNode
        get() = _TypeNode(`$node`.getChildByFieldName("type") ?: error("required field type is null"))
}
