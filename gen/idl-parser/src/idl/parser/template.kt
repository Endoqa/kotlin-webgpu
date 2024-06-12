package idl.parser

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.TypeSpec
import idl.Interface

fun interfaceTemplate(interfaceType: Interface) {

    val type = if (interfaceType.isMixin) {
        TypeSpec.interfaceBuilder(ClassName("webgpu", interfaceType.name))
    } else {
        TypeSpec.classBuilder(ClassName("webgpu", interfaceType.name))
    }

    interfaceType.includes.forEach {
        type.addSuperinterface(ClassName("webgpu", it))
    }


}