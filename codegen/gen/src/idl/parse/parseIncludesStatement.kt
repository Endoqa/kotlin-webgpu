package idl.parse

import idl.Include
import tree_sitter.idl.node.IncludesStatementNode

context(SourceAvailable)
fun parseIncludesStatement(node: IncludesStatementNode): Include {
    val interfaceName = node.target.content()
    val mixinName = node.mixin.content()

    return Include(interfaceName, mixinName)
}