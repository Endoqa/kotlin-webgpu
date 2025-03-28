package tree_sitter.idl.node

import tree_sitter.Node

public class ArgumentListNode(
    override val `$node`: Node,
) : IDLNodeBase {
    public val argument: List<ArgumentNode>
        get() = useCursor { cursor ->
            `$node`.childrenByFieldName("argument", cursor)
                .asSequence()
                .map { ArgumentNode(it) }
                .toList()
        }
}
