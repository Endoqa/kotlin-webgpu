@file:OptIn(ExperimentalStdlibApi::class)

package webgpu.gen

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.CodeBlock
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import com.squareup.kotlinpoet.asTypeName
import webgpu.schema.Bitflag
import webgpu.schema.Value64

fun generateBitflag(
    bitflag: Bitflag,
    packageName: String
): FileSpec.Builder {

    val fileName = "WGPU${bitflag.name.pascalCase}"

    val type = TypeSpec.objectBuilder(ClassName(packageName, fileName))

    type.addKdoc(transformDoc(bitflag.doc))

    bitflag.entries.forEachIndexed { index, entry ->

        val spec = PropertySpec.builder(entry.name.pascalCase, ClassName(packageName, "WGPUFlags"), KModifier.CONST)
        spec.addKdoc(transformDoc(entry.doc))


        when {
            entry.value != null -> {
                spec.initializer(entry.value.toCode())
            }

            entry.valueCombination != null -> {
                val value = bitflag.entries
                    .filter { it.name in entry.valueCombination }
                    .fold(0L) { acc, e -> acc or bitValue(bitflag.entries.indexOf(e)) }

                spec.addKdoc(entry.valueCombination.joinToString(" | ") {
                    "[${it.pascalCase}]"
                })

                spec.initializer("0x%Lu", value.toULong().toHexString(HexFormat.UpperCase))
            }

            else -> {

                spec.initializer("0x%Lu", bitValue(index).toULong().toHexString(HexFormat.UpperCase))
            }
        }



        type.addProperty(spec.build())

    }


    return FileSpec.builder(packageName, fileName)
        .addType(type.build())

}

private fun bitValue(idx: Int): Long {
    return if (idx == 0) 0L else 1L shl (idx - 1)
}

private fun Value64.toCode(): CodeBlock {
    return when (this) {
        Value64.Constant.USizeMax -> CodeBlock.of("%T.MAX_VALUE", ULong::class.asTypeName())
        Value64.Constant.UInt32Max -> CodeBlock.of("%T.MAX_VALUE", UInt::class.asTypeName())
        Value64.Constant.UInt64Max -> CodeBlock.of("%T.MAX_VALUE", ULong::class.asTypeName())
        Value64.Constant.NaN -> TODO()
        is Value64.Integer -> CodeBlock.of("0x%Lu", value.toHexString(HexFormat.UpperCase))
    }
}