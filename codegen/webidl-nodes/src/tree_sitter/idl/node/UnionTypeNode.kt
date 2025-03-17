package tree_sitter.idl.node

import kotlin.collections.List
import tree_sitter.Node

public sealed interface UnionTypeNodeMemberTypes : IDLTSBaseNode {
  public companion object {
    public operator fun invoke(node: Node): UnionTypeNodeMemberTypes {
      val n = createNode(node)
      if (n is UnionTypeNodeMemberTypes) {
        return n
      }
      throw IllegalArgumentException("Node is not a UnionTypeNodeMemberTypes")
    }
  }
}

public class UnionTypeNode(
  override val `$node`: Node,
) : IDLTSBaseNode,
    _TypeNode {
  public val memberTypes: List<UnionTypeNodeMemberTypes>
    get() = useCursor { cursor ->
      `$node`.childrenByFieldName("member_types", cursor)
      .asSequence()
      .map { UnionTypeNodeMemberTypes(it) }
      .toList()
    }
}
