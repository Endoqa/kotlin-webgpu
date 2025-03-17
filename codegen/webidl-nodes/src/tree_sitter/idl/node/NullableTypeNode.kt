package tree_sitter.idl.node

import tree_sitter.Node

public class NullableTypeNode(
  override val `$node`: Node,
) : IDLTSBaseNode,
    _SingleTypeNode {
  public val type: _SingleTypeNode
    get() = _SingleTypeNode(`$node`.getChildByFieldName("type") ?:
        error("required field type is null"))
}
