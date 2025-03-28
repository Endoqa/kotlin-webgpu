package tree_sitter.idl.node

import tree_sitter.Node

public class MaplikeNode(
    override val `$node`: Node,
) : IDLNodeBase,
    _InterfaceMemberBodyNode,
    _MixinMemberBodyNode,
    _PartialInterfaceMemberBodyNode {
    public val keyType: _TypeNode
        get() = _TypeNode(
            `$node`.getChildByFieldName("key_type") ?: error("required field key_type is null")
        )

    public val readonly: IDLNodeBase.Unnamed?
        get() = (`$node`.getChildByFieldName("readonly"))?.let { IDLNodeBase.Unnamed(it) }

    public val valueType: _TypeNode
        get() = _TypeNode(
            `$node`.getChildByFieldName("value_type") ?: error("required field value_type is null")
        )
}
