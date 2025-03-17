package tree_sitter.idl.node

import tree_sitter.Node

public class MixinNode(
  override val `$node`: Node,
) : IDLTSBaseNode,
    _DefinitionNode {
  public val attributes: ExtendedAttributeListNode?
    get() = (`$node`.getChildByFieldName("attributes"))?.let { ExtendedAttributeListNode(it) }

  public val body: MixinMembersNode
    get() = MixinMembersNode(`$node`.getChildByFieldName("body") ?:
        error("required field body is null"))

  public val name: IdentifierNode
    get() = IdentifierNode(`$node`.getChildByFieldName("name") ?:
        error("required field name is null"))
}
