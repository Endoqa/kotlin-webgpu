package tree_sitter.idl.node

import tree_sitter.Node

public class ConstructorNode(
    override val `$node`: Node,
) : IDLNodeBase,
    _InterfaceMemberBodyNode {
    public val arguments: ArgumentListNode
        get() = ArgumentListNode(
            `$node`.getChildByFieldName("arguments") ?: error("required field arguments is null")
        )
}
