package tree_sitter.idl.node

import tree_sitter.Node

public sealed interface FloatLiteralNode : IDLTSBaseNode, _ConstValueNode {
  public companion object {
    public operator fun invoke(node: Node): FloatLiteralNode {
      val n = createNode(node)
      if (n is FloatLiteralNode) {
        return n
      }
      throw IllegalArgumentException("Node is not a FloatLiteralNode")
    }
  }
}
