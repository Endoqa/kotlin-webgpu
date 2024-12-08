package webgpu


import gen.GenerateContext
import gen.enums.EnumNameFormat
import gen.generate
import kotlinx.serialization.json.Json
import webgpu.gen.c.GenerateCContext
import webgpu.gen.c.generate
import webgpu.gen.generateBitflag
import webgpu.schema.Schema
import java.io.File

fun main(args: Array<String>) {


    val webgpuJson = File("webgpu.json").readText()


    val json = Json {
        ignoreUnknownKeys = true
        explicitNulls = false
    }


    val schema: Schema = json.decodeFromString(webgpuJson)

//    println(schema)


    val context = GenerateCContext()

    with(context) {
        generate(schema)
    }


    val gc = GenerateContext(
        "lib.wgpu",
        enumFormat = EnumNameFormat.NOOP
    )

    gc.globals.putAll(context.globals)
    gc.enums.putAll(context.enums)
    gc.structs.putAll(context.structs)
//    gc.unions.putAll(context.unions)

    schema.bitflags.forEach {
        gc.files.add(generateBitflag(it, "lib.wgpu"))
    }


    gc.generate(File("output/kotlin"))


}