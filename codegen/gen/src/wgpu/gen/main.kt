package wgpu.gen


import idl.*
import idl.Enum
import idl.parse.SourceAvailable
import idl.parse.parseIDL
import tree_sitter.Language
import tree_sitter.Parser
import tree_sitter.idl.node.IDLTSBaseNode
import tree_sitter.idl.node.SourceNode
import webgpu.schema.Schema
import wgpu.gen.enum.generateEnum
import java.io.File

const val WGPU_PACKAGE = "wgpu"

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

    val idl = with(sa) {
        parseIDL(source)
    }

    println("Parsed IDL:")
    println("- Interfaces: ${idl.definitions.filterIsInstance<Interface>().size}")
    println("- Mixins: ${idl.definitions.filterIsInstance<Mixin>().size}")
    println("- Dictionaries: ${idl.definitions.filterIsInstance<Dictionary>().size}")
    println("- Enums: ${idl.definitions.filterIsInstance<Enum>().size}")
    println("- Typedefs: ${idl.definitions.filterIsInstance<Typedef>().size}")
    println("- Includes: ${idl.definitions.filterIsInstance<Include>().size}")

    val webgpuJson = File("webgpu.json").readText()


    val ctx = GenerateContext(Schema.parse(webgpuJson))

    with(ctx) {
        generate(idl)
    }


    ctx.emit(File("../webgpu/src").toPath())

}

context(GenerateContext)
private fun generate(idl: IDL) {
    idl.definitions.forEach { def ->
        when (def) {
            is Enum -> {
                this@GenerateContext includeSource generateEnum(def)
            }

            else -> {}
        }
    }
}
