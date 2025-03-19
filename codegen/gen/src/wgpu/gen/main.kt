package wgpu.gen


import com.squareup.kotlinpoet.FileSpec
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
import wgpu.gen.interfaces.generateInterface
import wgpu.gen.interfaces.generateMixin
import wgpu.gen.typedef.generateTypedef
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

private val interfaceExclude = listOf(
    "NavigatorGPU"
)

context(GenerateContext)
private fun generate(idl: IDL) {
    // Map to track inheritance relationships (interface -> list of superinterfaces)
    val inheritanceMap = mutableMapOf<String, MutableList<String>>()

    // First pass: collect all includes
    for (def in idl.definitions) {
        if (def is Include) {
            inheritanceMap.getOrPut(def.interfaceName) { mutableListOf() }.add(def.mixinName)
        }
    }

    val typedefs = FileSpec.builder(WGPU_PACKAGE, "\$typedefs")
    includeSource(typedefs)

    // Process all definitions
    for (def in idl.definitions) {
        when (def) {
            is Enum -> {
                this@GenerateContext includeSource generateEnum(def)
            }

            is Typedef -> {
                typedefs.addTypeAlias(generateTypedef(def))
            }

            is Mixin -> {
                if (def.name in interfaceExclude) {
                    continue
                }
                includeSource(generateMixin(def))
            }

            is Interface -> {
                if (def.name in interfaceExclude) {
                    continue
                }

                // Get superinterfaces for this interface
                val superInterfaces = inheritanceMap[def.name] ?: emptyList()

                includeSource(generateInterface(def, superInterfaces, idl))
            }

            else -> {}
        }
    }
}
