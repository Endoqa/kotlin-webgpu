package tree_sitter.idl.node

import tree_sitter.Node

public class CallbackInterfaceNode(
    override val `$node`: Node,
) : IDLNodeBase,
    _DefinitionNode {
    public val attributes: ExtendedAttributeListNode?
        get() = (`$node`.getChildByFieldName("attributes"))?.let { ExtendedAttributeListNode(it) }

    public val body: CallbackInterfaceMembersNode
        get() = CallbackInterfaceMembersNode(
            `$node`.getChildByFieldName("body") ?: error("required field body is null")
        )

    public val name: IdentifierNode
        get() = IdentifierNode(
            `$node`.getChildByFieldName("name") ?: error("required field name is null")
        )
}
