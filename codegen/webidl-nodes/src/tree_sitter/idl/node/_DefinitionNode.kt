package tree_sitter.idl.node

import tree_sitter.Node

public sealed interface _DefinitionNode : IDLTSBaseNode, SourceNodeChildren {
  public companion object {
    public operator fun invoke(node: Node): _DefinitionNode {
      val n = createNode(node)
      if (n is _DefinitionNode) {
        return n
      }
      throw IllegalArgumentException("Node is not a _DefinitionNode")
    }
  }
}
