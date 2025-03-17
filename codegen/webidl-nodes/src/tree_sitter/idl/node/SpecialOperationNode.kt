package tree_sitter.idl.node

import tree_sitter.Node

public class SpecialOperationNode(
    override val `$node`: Node,
) : IDLTSBaseNode,
    _OperationNode {
    public val operation: RegularOperationNode
        get() = RegularOperationNode(
            `$node`.getChildByFieldName("operation") ?: error("required field operation is null")
        )

    public val special: SpecialNode
        get() = SpecialNode(
            `$node`.getChildByFieldName("special") ?: error("required field special is null")
        )
}
