package tree_sitter.idl.node

import tree_sitter.Node

public class SetlikeNode(
    override val `$node`: Node,
) : IDLNodeBase,
    _InterfaceMemberBodyNode,
    _MixinMemberBodyNode,
    _PartialInterfaceMemberBodyNode {
    public val readonly: IDLNodeBase.Unnamed?
        get() = (`$node`.getChildByFieldName("readonly"))?.let { IDLNodeBase.Unnamed(it) }

    public val valueType: _TypeNode
        get() = _TypeNode(
            `$node`.getChildByFieldName("value_type") ?: error("required field value_type is null")
        )
}
