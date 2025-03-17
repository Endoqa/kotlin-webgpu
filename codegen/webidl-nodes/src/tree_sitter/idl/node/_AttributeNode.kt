package tree_sitter.idl.node

import tree_sitter.Node

public sealed interface _AttributeNode : IDLTSBaseNode, _InterfaceMemberBodyNode,
    _MixinMemberBodyNode, _PartialInterfaceMemberBodyNode {
  public companion object {
    public operator fun invoke(node: Node): _AttributeNode {
      val n = createNode(node)
      if (n is _AttributeNode) {
        return n
      }
      throw IllegalArgumentException("Node is not a _AttributeNode")
    }
  }
}
