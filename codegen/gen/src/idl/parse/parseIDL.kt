package idl.parse

import tree_sitter.idl.node.*


interface SourceAvailable {
    fun IDLTSBaseNode.content(): String
}


context(SourceAvailable)
fun parseIDL(node: SourceNode) {

    (node.children() ?: emptyList()).forEach { child ->
        when (child) {
            is CallbackInterfaceNode -> TODO()
            is CommentNode -> {

            }

            is DictionaryNode -> parseDict(child)
            is EnumNode -> TODO()
            is IncludesStatementNode -> TODO()
            is InterfaceNode -> parseInterface(child)
            is MixinNode -> parseMixin(child)
            is NamespaceNode -> TODO()
            is PartialDictionaryNode -> TODO()
            is PartialInterfaceNode -> TODO()
            is PartialNamespaceNode -> TODO()
            is TypedefNode -> TODO()
        }
    }
}