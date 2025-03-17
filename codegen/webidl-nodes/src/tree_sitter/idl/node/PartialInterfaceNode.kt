package tree_sitter.idl.node

import kotlin.collections.List
import tree_sitter.Node

public class PartialInterfaceNode(
  override val `$node`: Node,
) : IDLTSBaseNode,
    _DefinitionNode {
  public val attributes: ExtendedAttributeListNode?
    get() = (`$node`.getChildByFieldName("attributes"))?.let { ExtendedAttributeListNode(it) }

  public val members: List<PartialInterfaceMemberNode>
    get() = useCursor { cursor ->
      `$node`.childrenByFieldName("members", cursor)
      .asSequence()
      .map { PartialInterfaceMemberNode(it) }
      .toList()
    }

  public val name: IdentifierNode
    get() = IdentifierNode(`$node`.getChildByFieldName("name") ?:
        error("required field name is null"))
}
