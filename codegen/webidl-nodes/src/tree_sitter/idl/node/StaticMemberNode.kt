package tree_sitter.idl.node

import tree_sitter.Node

public class StaticMemberNode(
    override val `$node`: Node,
) : IDLNodeBase,
    _InterfaceMemberBodyNode,
    _MixinMemberBodyNode,
    _PartialInterfaceMemberBodyNode {
    public val member: _StaticMemberBodyNode
        get() = _StaticMemberBodyNode(
            `$node`.getChildByFieldName("member") ?: error("required field member is null")
        )
}
