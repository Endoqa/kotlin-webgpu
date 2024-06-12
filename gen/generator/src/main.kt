import generator.GenerateContext
import generator.genDict
import idl.parser.parseIDL
import java.io.File
import java.lang.foreign.Arena

fun main(args: Array<String>) {

    System.load(File("libs/libtree-sitter.dylib").absolutePath)
    System.load(File("libs/libtree-sitter-idl.dylib").absolutePath)

    with(Arena.ofAuto()) {
        val idl = parseIDL(File("webgpu-mod.idl").readText())

        val context = GenerateContext(idl)

        with(context) {
            idl.roots.forEach { (name, d) ->
                if (d is idl.Dictionary) {
                    genDict(d)
                }
            }
        }

    }

}