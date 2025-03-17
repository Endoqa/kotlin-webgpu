package tree_sitter.idl.node

import tree_sitter.Node

public class ConstNode(
    override val `$node`: Node,
) : IDLTSBaseNode,
    _InterfaceMemberBodyNode,
    _MixinMemberBodyNode,
    _NamespaceMemberNode,
    _PartialInterfaceMemberBodyNode {
    public val name: IdentifierNode
        get() = IdentifierNode(
            `$node`.getChildByFieldName("name") ?: error("required field name is null")
        )

    public val type: _ConstTypeNode
        get() = _ConstTypeNode(
            `$node`.getChildByFieldName("type") ?: error("required field type is null")
        )

    public val `value`: _ConstValueNode
        get() = _ConstValueNode(
            `$node`.getChildByFieldName("value") ?: error("required field value is null")
        )
}
