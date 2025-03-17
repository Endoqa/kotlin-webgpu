package tree_sitter.idl.node

import tree_sitter.Node

public class DefaultDictionaryNode(
  override val `$node`: Node,
) : IDLTSBaseNode,
    _DefaultValueNode
