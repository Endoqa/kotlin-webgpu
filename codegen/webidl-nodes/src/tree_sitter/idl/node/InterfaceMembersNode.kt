package tree_sitter.idl.node

import kotlin.collections.List
import tree_sitter.Node

public class InterfaceMembersNode(
  override val `$node`: Node,
) : IDLTSBaseNode {
  public val members: List<InterfaceMemberNode>
    get() = useCursor { cursor ->
      `$node`.childrenByFieldName("members", cursor)
      .asSequence()
      .map { InterfaceMemberNode(it) }
      .toList()
    }
}
