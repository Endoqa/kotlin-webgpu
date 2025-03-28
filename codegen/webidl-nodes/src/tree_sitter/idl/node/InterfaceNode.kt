package tree_sitter.idl.node

import tree_sitter.Node

public class InterfaceNode(
    override val `$node`: Node,
) : IDLNodeBase,
    _DefinitionNode {
    public val attributes: ExtendedAttributeListNode?
        get() = (`$node`.getChildByFieldName("attributes"))?.let { ExtendedAttributeListNode(it) }

    public val body: InterfaceMembersNode
        get() = InterfaceMembersNode(
            `$node`.getChildByFieldName("body") ?: error("required field body is null")
        )

    public val name: IdentifierNode
        get() = IdentifierNode(
            `$node`.getChildByFieldName("name") ?: error("required field name is null")
        )

    public val `super`: IdentifierNode?
        get() = (`$node`.getChildByFieldName("super"))?.let { IdentifierNode(it) }
}
