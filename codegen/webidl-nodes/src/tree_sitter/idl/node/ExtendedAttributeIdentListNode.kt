package tree_sitter.idl.node

import kotlin.collections.List
import tree_sitter.Node

public class ExtendedAttributeIdentListNode(
  override val `$node`: Node,
) : IDLTSBaseNode,
    _ExtendedAttributeNode {
  public val name: IdentifierNode
    get() = IdentifierNode(`$node`.getChildByFieldName("name") ?:
        error("required field name is null"))

  public val `value`: List<IdentifierNode>
    get() = useCursor { cursor ->
      `$node`.childrenByFieldName("value", cursor)
      .asSequence()
      .map { IdentifierNode(it) }
      .toList()
    }
}
