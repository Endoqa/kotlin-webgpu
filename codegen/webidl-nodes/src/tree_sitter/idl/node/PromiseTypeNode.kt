package tree_sitter.idl.node

import tree_sitter.Node

public class PromiseTypeNode(
    override val `$node`: Node,
) : IDLTSBaseNode,
    _TypeNode {
    public val resolveType: _TypeNode
        get() = _TypeNode(
            `$node`.getChildByFieldName("resolve_type") ?: error("required field resolve_type is null")
        )
}
