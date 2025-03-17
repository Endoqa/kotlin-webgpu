package tree_sitter.idl.node

import tree_sitter.Node

public class RegularOperationNode(
    override val `$node`: Node,
) : IDLTSBaseNode,
    _NamespaceMemberNode,
    _OperationNode,
    _StaticMemberBodyNode {
    public val arguments: ArgumentListNode
        get() = ArgumentListNode(
            `$node`.getChildByFieldName("arguments") ?: error("required field arguments is null")
        )

    public val name: IdentifierNode?
        get() = (`$node`.getChildByFieldName("name"))?.let { IdentifierNode(it) }

    public val returnType: _TypeNode
        get() = _TypeNode(
            `$node`.getChildByFieldName("return_type") ?: error("required field return_type is null")
        )
}
