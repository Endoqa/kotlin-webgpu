package tree_sitter.idl.node

import tree_sitter.Node

public class ExtendedAttributeIdentNode(
    override val `$node`: Node,
) : IDLNodeBase,
    _ExtendedAttributeNode {
    public val name: IdentifierNode
        get() = IdentifierNode(
            `$node`.getChildByFieldName("name") ?: error("required field name is null")
        )

    public val `value`: IdentifierNode
        get() = IdentifierNode(
            `$node`.getChildByFieldName("value") ?: error("required field value is null")
        )
}
