package idl.parse

import idl.IDL
import tree_sitter.idl.node.*


interface SourceAvailable {
    fun IDLNodeBase.content(): String
}


context(SourceAvailable)
fun parseIDL(node: SourceNode): IDL {
    val idl = IDL()

    (node.children() ?: emptyList()).forEach { child ->
        when (child) {
            is CallbackInterfaceNode -> {
                val callbackInterface = parseCallbackInterface(child)
                idl.definitions.add(callbackInterface)
            }

            is CommentNode -> {
                // Ignore comments
            }

            is DictionaryNode -> {
                val dictionary = parseDict(child)
                idl.definitions.add(dictionary)
            }

            is EnumNode -> {
                val enum = parseEnum(child)
                idl.definitions.add(enum)
            }

            is IncludesStatementNode -> {
                val include = parseIncludesStatement(child)
                idl.definitions.add(include)
            }

            is InterfaceNode -> {
                val interface_ = parseInterface(child)
                idl.definitions.add(interface_)
            }

            is MixinNode -> {
                val mixin = parseMixin(child)
                idl.definitions.add(mixin)
            }

            is NamespaceNode -> {
                val namespace = parseNamespace(child)
                idl.definitions.add(namespace)
            }

            is PartialDictionaryNode -> {
                val dictionary = parsePartialDict(child)
                idl.definitions.add(dictionary)
            }

            is PartialInterfaceNode -> {
                val interface_ = parsePartialInterface(child)
                idl.definitions.add(interface_)
            }

            is PartialNamespaceNode -> {
                val namespace = parsePartialNamespace(child)
                idl.definitions.add(namespace)
            }

            is TypedefNode -> {
                val typedef = parseTypedef(child)
                idl.definitions.add(typedef)
            }
        }
    }

    return idl
}
