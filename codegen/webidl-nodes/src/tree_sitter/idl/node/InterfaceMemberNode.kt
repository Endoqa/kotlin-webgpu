package tree_sitter.idl.node

import tree_sitter.Node

public class InterfaceMemberNode(
  override val `$node`: Node,
) : IDLTSBaseNode {
  public val attributes: ExtendedAttributeListNode?
    get() = (`$node`.getChildByFieldName("attributes"))?.let { ExtendedAttributeListNode(it) }

  public val member: _InterfaceMemberBodyNode
    get() = _InterfaceMemberBodyNode(`$node`.getChildByFieldName("member") ?:
        error("required field member is null"))
}
