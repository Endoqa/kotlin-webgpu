package tree_sitter.idl.node

import tree_sitter.Node

public class DictionaryMembersNode(
    override val `$node`: Node,
) : IDLTSBaseNode {
    public val members: List<DictionaryMemberNode>
        get() = useCursor { cursor ->
            `$node`.childrenByFieldName("members", cursor)
                .asSequence()
                .map { DictionaryMemberNode(it) }
                .toList()
        }
}
