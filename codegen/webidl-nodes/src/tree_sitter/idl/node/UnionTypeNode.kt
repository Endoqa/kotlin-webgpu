package tree_sitter.idl.node

import tree_sitter.Node

public class UnionTypeNode(
    override val `$node`: Node,
) : IDLNodeBase,
    _TypeNode {
    public val memberTypes: List<_TypeNode>
        get() = useCursor { cursor ->
            `$node`.childrenByFieldName("member_types", cursor)
                .asSequence()
                .map { _TypeNode(it) }
                .toList()
        }
}
