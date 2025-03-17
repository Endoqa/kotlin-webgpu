package idl.parse

import idl.IDL
import tree_sitter.idl.node.*


interface SourceAvailable {
    fun IDLTSBaseNode.content(): String
}


context(SourceAvailable)
fun parseIDL(node: SourceNode): IDL {
    val idl = IDL()

    (node.children() ?: emptyList()).forEach { child ->
        when (child) {
            is CallbackInterfaceNode -> {
                val callbackInterface = parseCallbackInterface(child)
                idl.callbackInterfaces.add(callbackInterface)
            }

            is CommentNode -> {
                // Ignore comments
            }

            is DictionaryNode -> {
                val dictionary = parseDict(child)
                idl.dictionaries.add(dictionary)
            }

            is EnumNode -> {
                val enum = parseEnum(child)
                idl.enums.add(enum)
            }

            is IncludesStatementNode -> {
                val include = parseIncludesStatement(child)
                idl.includes.add(include)
            }

            is InterfaceNode -> {
                val interface_ = parseInterface(child)
                idl.interfaces.add(interface_)
            }

            is MixinNode -> {
                val mixin = parseMixin(child)
                idl.mixins.add(mixin)
            }

            is NamespaceNode -> {
                val namespace = parseNamespace(child)
                idl.namespaces.add(namespace)
            }

            is PartialDictionaryNode -> {
                val dictionary = parsePartialDict(child)
                idl.dictionaries.add(dictionary)
            }

            is PartialInterfaceNode -> {
                val interface_ = parsePartialInterface(child)
                idl.interfaces.add(interface_)
            }

            is PartialNamespaceNode -> {
                val namespace = parsePartialNamespace(child)
                idl.namespaces.add(namespace)
            }

            is TypedefNode -> {
                val typedef = parseTypedef(child)
                idl.typedefs.add(typedef)
            }
        }
    }

    return idl
}
