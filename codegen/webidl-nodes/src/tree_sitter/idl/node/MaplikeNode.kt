package tree_sitter.idl.node

import tree_sitter.Node

public class MaplikeNode(
    override val `$node`: Node,
) : IDLTSBaseNode,
    _InterfaceMemberBodyNode,
    _MixinMemberBodyNode,
    _PartialInterfaceMemberBodyNode {
    public val keyType: _TypeNode
        get() = _TypeNode(
            `$node`.getChildByFieldName("key_type") ?: error("required field key_type is null")
        )

    public val readonly: IDLTSBaseNode.Unnamed?
        get() = (`$node`.getChildByFieldName("readonly"))?.let { IDLTSBaseNode.Unnamed(it) }

    public val valueType: _TypeNode
        get() = _TypeNode(
            `$node`.getChildByFieldName("value_type") ?: error("required field value_type is null")
        )
}
