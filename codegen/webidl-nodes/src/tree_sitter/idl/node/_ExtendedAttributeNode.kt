package tree_sitter.idl.node

import tree_sitter.Node

public sealed interface _ExtendedAttributeNode : IDLTSBaseNode {
  public companion object {
    public operator fun invoke(node: Node): _ExtendedAttributeNode {
      val n = createNode(node)
      if (n is _ExtendedAttributeNode) {
        return n
      }
      throw IllegalArgumentException("Node is not a _ExtendedAttributeNode")
    }
  }
}
