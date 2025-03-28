package tree_sitter.idl.node

import tree_sitter.Node

public class PartialInterfaceMemberNode(
    override val `$node`: Node,
) : IDLNodeBase {
    public val attributes: ExtendedAttributeListNode?
        get() = (`$node`.getChildByFieldName("attributes"))?.let { ExtendedAttributeListNode(it) }

    public val member: _PartialInterfaceMemberBodyNode
        get() = _PartialInterfaceMemberBodyNode(
            `$node`.getChildByFieldName("member") ?: error("required field member is null")
        )
}
