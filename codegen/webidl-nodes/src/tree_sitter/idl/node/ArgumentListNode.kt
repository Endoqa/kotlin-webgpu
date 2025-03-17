package tree_sitter.idl.node

import kotlin.collections.List
import tree_sitter.Node

public class ArgumentListNode(
  override val `$node`: Node,
) : IDLTSBaseNode {
  public val argument: List<ArgumentNode>
    get() = useCursor { cursor ->
      `$node`.childrenByFieldName("argument", cursor)
      .asSequence()
      .map { ArgumentNode(it) }
      .toList()
    }
}
