package wgpu.gen

import com.squareup.kotlinpoet.FileSpec
import idl.IDL
import webgpu.schema.Schema
import wgpu.gen.common.WithIDL
import java.nio.file.Path

class GenerateContext(
    val schema: Schema,
    override val idl: IDL
) : WithIDL {
    private val expectSources = mutableListOf<FileSpec.Builder>()
    private val actualSources = mutableListOf<FileSpec.Builder>()


    val excludeIdentifiers = listOf(
        "GPUPipelineErrorReason"
    )

    fun emit(path: Path) {
        expectSources.forEach { it.build().writeTo(path) }
    }

    fun emitActual(path: Path) {
        actualSources.forEach { it.build().writeTo(path) }
    }

    infix fun includeSource(file: FileSpec.Builder) {
        expectSources += file
    }

    fun actualSource(file: FileSpec.Builder) {
        actualSources += file
    }
}