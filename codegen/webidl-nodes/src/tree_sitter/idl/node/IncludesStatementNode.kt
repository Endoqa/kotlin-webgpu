package tree_sitter.idl.node

import tree_sitter.Node

public class IncludesStatementNode(
    override val `$node`: Node,
) : IDLTSBaseNode,
    _DefinitionNode {
    public val mixin: IdentifierNode
        get() = IdentifierNode(
            `$node`.getChildByFieldName("mixin") ?: error("required field mixin is null")
        )

    public val target: IdentifierNode
        get() = IdentifierNode(
            `$node`.getChildByFieldName("target") ?: error("required field target is null")
        )
}
