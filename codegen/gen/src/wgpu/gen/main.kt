package wgpu.gen


import idl.parse.SourceAvailable
import idl.parse.parseIDL
import tree_sitter.Language
import tree_sitter.Parser
import tree_sitter.idl.node.IDLTSBaseNode
import tree_sitter.idl.node.SourceNode
import java.io.File

private fun loadTreeSitter() {
    val tsPath = System.getenv("TREE_SITTER_PATH")
    System.load(File("$tsPath/lib/libtree-sitter.so").absolutePath)
    System.load(File("../libs/webidl.so").absolutePath)
}

class StringSourceAvailable(private val source: String) : SourceAvailable {
    override fun IDLTSBaseNode.content(): String {
        val range = `$node`.byteRange
        return source.substring(range.first.toInt(), range.last.toInt())
    }

}

fun main(args: Array<String>) {
    loadTreeSitter()

    val webidl = Language.getLanguage("webidl")

    val idlContent = File("webgpu.idl").readText()

    val parser = Parser()

    parser.language = webidl

    val tree = parser.parse(idlContent)

    require(idlContent.length.toUInt() == tree.rootNode.byteRange.last)

    val source = SourceNode(tree.rootNode)

    val sa = StringSourceAvailable(idlContent)

    with(sa) {
        val idl = parseIDL(source)
        println("Parsed IDL:")
        println("- Interfaces: ${idl.interfaces.size}")
        println("- Mixins: ${idl.mixins.size}")
        println("- Dictionaries: ${idl.dictionaries.size}")
        println("- Enums: ${idl.enums.size}")
        println("- Typedefs: ${idl.typedefs.size}")
        println("- Includes: ${idl.includes.size}")
    }


}
