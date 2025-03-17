package tree_sitter.idl.node

import tree_sitter.Node

public class ObservableArrayTypeNode(
    override val `$node`: Node,
) : IDLTSBaseNode,
    _SingleTypeNode {
    public val elementType: _TypeNode
        get() = _TypeNode(
            `$node`.getChildByFieldName("element_type") ?: error("required field element_type is null")
        )
}
