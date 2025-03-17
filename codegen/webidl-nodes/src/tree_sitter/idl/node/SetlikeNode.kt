package tree_sitter.idl.node

import tree_sitter.Node

public class SetlikeNode(
  override val `$node`: Node,
) : IDLTSBaseNode,
    _InterfaceMemberBodyNode,
    _MixinMemberBodyNode,
    _PartialInterfaceMemberBodyNode {
  public val readonly: IDLTSBaseNode.Unnamed?
    get() = (`$node`.getChildByFieldName("readonly"))?.let { IDLTSBaseNode.Unnamed(it) }

  public val valueType: _TypeNode
    get() = _TypeNode(`$node`.getChildByFieldName("value_type") ?:
        error("required field value_type is null"))
}
