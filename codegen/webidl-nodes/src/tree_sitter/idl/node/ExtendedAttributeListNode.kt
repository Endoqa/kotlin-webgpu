package tree_sitter.idl.node

import kotlin.collections.List
import tree_sitter.Node

public class ExtendedAttributeListNode(
  override val `$node`: Node,
) : IDLTSBaseNode {
  public val attribute: List<_ExtendedAttributeNode>
    get() = useCursor { cursor ->
      `$node`.childrenByFieldName("attribute", cursor)
      .asSequence()
      .map { _ExtendedAttributeNode(it) }
      .toList()
    }
}
