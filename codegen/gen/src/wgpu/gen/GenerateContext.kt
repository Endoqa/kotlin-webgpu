package wgpu.gen

import com.squareup.kotlinpoet.FileSpec
import webgpu.schema.Schema
import java.nio.file.Path

class GenerateContext(
    val schema: Schema
) {
    private val sources = mutableListOf<FileSpec.Builder>()


    val excludeIdentifiers = listOf(
        "GPUPipelineErrorReason"
    )

    fun emit(path: Path) {
        sources.forEach { it.build().writeTo(path) }
    }

    infix fun includeSource(file: FileSpec.Builder) {
        sources += file
    }
}