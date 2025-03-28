package tree_sitter.idl.node

import tree_sitter.Node

public class ExtendedAttributeNoArgsNode(
    override val `$node`: Node,
) : IDLNodeBase,
    _ExtendedAttributeNode {
    public val name: IdentifierNode
        get() = IdentifierNode(
            `$node`.getChildByFieldName("name") ?: error("required field name is null")
        )
}
