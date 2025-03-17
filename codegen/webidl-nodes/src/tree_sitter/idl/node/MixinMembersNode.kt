package tree_sitter.idl.node

import kotlin.collections.List
import tree_sitter.Node

public class MixinMembersNode(
  override val `$node`: Node,
) : IDLTSBaseNode {
  public val members: List<MixinMemberNode>
    get() = useCursor { cursor ->
      `$node`.childrenByFieldName("members", cursor)
      .asSequence()
      .map { MixinMemberNode(it) }
      .toList()
    }
}
