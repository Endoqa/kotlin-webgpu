package tree_sitter.idl.node

import tree_sitter.Node

public class MixinMemberNode(
    override val `$node`: Node,
) : IDLNodeBase {
    public val attributes: ExtendedAttributeListNode?
        get() = (`$node`.getChildByFieldName("attributes"))?.let { ExtendedAttributeListNode(it) }

    public val member: _MixinMemberBodyNode
        get() = _MixinMemberBodyNode(
            `$node`.getChildByFieldName("member") ?: error("required field member is null")
        )
}
