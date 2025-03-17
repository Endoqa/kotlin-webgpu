package tree_sitter.idl.node

import tree_sitter.Node

public class AsyncIterableNode(
  override val `$node`: Node,
) : IDLTSBaseNode,
    _InterfaceMemberBodyNode,
    _PartialInterfaceMemberBodyNode {
  public val arguments: ArgumentListNode?
    get() = (`$node`.getChildByFieldName("arguments"))?.let { ArgumentListNode(it) }

  public val type: _TypeNode
    get() = _TypeNode(`$node`.getChildByFieldName("type") ?: error("required field type is null"))

  public val valueType: _TypeNode?
    get() = (`$node`.getChildByFieldName("value_type"))?.let { _TypeNode(it) }
}
