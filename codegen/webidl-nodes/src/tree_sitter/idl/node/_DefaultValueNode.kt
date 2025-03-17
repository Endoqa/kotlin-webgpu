package tree_sitter.idl.node

import tree_sitter.Node

public sealed interface _DefaultValueNode : IDLTSBaseNode {
  public companion object {
    public operator fun invoke(node: Node): _DefaultValueNode {
      val n = createNode(node)
      if (n is _DefaultValueNode) {
        return n
      }
      throw IllegalArgumentException("Node is not a _DefaultValueNode")
    }
  }
}
