package tree_sitter.idl.node

import tree_sitter.Node

public class ExtendedAttributeNamedArgListNode(
    override val `$node`: Node,
) : IDLNodeBase,
    _ExtendedAttributeNode {
    public val arguments: ArgumentListNode
        get() = ArgumentListNode(
            `$node`.getChildByFieldName("arguments") ?: error("required field arguments is null")
        )

    public val identifier: IdentifierNode
        get() = IdentifierNode(
            `$node`.getChildByFieldName("identifier") ?: error("required field identifier is null")
        )

    public val name: IdentifierNode
        get() = IdentifierNode(
            `$node`.getChildByFieldName("name") ?: error("required field name is null")
        )
}
