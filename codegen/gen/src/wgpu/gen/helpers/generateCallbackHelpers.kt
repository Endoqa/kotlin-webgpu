@file:OptIn(ExperimentalKotlinPoetApi::class)

package wgpu.gen.helpers

import com.squareup.kotlinpoet.*
import webgpu.schema.Callback
import webgpu.schema.CallbackStyle
import webgpu.schema.Schema
import java.lang.foreign.Arena

private const val DEFAULT_MODE_NAME = "DEFAULT_CALLBACK_MODE"

private val WGPU_CALLBACK_MODE = ClassName("lib.wgpu", "WGPUCallbackMode")

fun generateCallbackHelpers(schema: Schema): FileSpec.Builder {
    val file = FileSpec.builder("wgpu", "\$callback_helper")


    file.addProperty(
        PropertySpec.builder(
            DEFAULT_MODE_NAME,
            WGPU_CALLBACK_MODE
        )
            .initializer("%T.AllowSpontaneous", WGPU_CALLBACK_MODE)
            .build()
    )

    for (callback in schema.callbacks) {
        file.addFunction(generateCallbackHelper(callback).build())
    }

    return file
}

private fun generateCallbackHelper(callback: Callback): FunSpec.Builder {

    val func = FunSpec.builder("create${callback.name.pascalCase}Callback")

    val infoClass = ClassName("lib.wgpu", "WGPU${callback.name.pascalCase}CallbackInfo")

    func.contextReceivers(Arena::class.asTypeName())

    func.returns(infoClass)

    if (callback.style == CallbackStyle.CallbackMode) {
        func.addParameter(
            ParameterSpec.builder("mode", WGPU_CALLBACK_MODE)
                .defaultValue("%N", DEFAULT_MODE_NAME)
                .build()
        )
    }

    func.addParameter(
        ParameterSpec.builder(
            "callback",
            ClassName("lib.wgpu.proc", "WGPU${callback.name.pascalCase}Callback")
        ).build()
    )

    val cb = CodeBlock.builder()
        .addStatement("val info = %T.allocate(this@Arena)", infoClass)


    if (callback.style == CallbackStyle.CallbackMode) {
        cb.addStatement("info.mode = mode")
    }


    cb.addStatement("info.callback = callback.allocate(this@Arena)")
        .addStatement("return info")

    func.addCode(cb.build())

    return func

}