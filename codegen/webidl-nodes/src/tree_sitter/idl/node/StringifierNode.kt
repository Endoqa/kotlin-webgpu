package tree_sitter.idl.node

import tree_sitter.Node

public sealed interface StringifierNodeChildren : IDLTSBaseNode {
  public companion object {
    public operator fun invoke(node: Node): StringifierNodeChildren {
      val n = createNode(node)
      if (n is StringifierNodeChildren) {
        return n
      }
      throw IllegalArgumentException("Node is not a StringifierNodeChildren")
    }
  }
}

public class StringifierNode(
  override val `$node`: Node,
) : IDLTSBaseNode,
    _InterfaceMemberBodyNode,
    _MixinMemberBodyNode,
    _PartialInterfaceMemberBodyNode {
  public fun children(): StringifierNodeChildren? {
    if (`$node`.namedChildCount == 0U) {
      return null
    }
    return StringifierNodeChildren(`$node`.getChild(0u) ?: error("no child found for stringifier"))
  }
}
