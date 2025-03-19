package wgpu.gen.interfaces

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.TypeSpec
import idl.IDL
import idl.Interface
import idl.Mixin
import wgpu.gen.GenerateContext
import wgpu.gen.WGPU_PACKAGE
import wgpu.gen.typedef.getUnionSuperclasses

context(GenerateContext)
fun generateInterface(
    iface: Interface,
    superInterfaces: List<String> = emptyList(),
    idl: IDL,
): FileSpec.Builder {
    val spec = TypeSpec.classBuilder(ClassName(WGPU_PACKAGE, iface.name))

    spec.addModifiers(KModifier.EXPECT)


    if (iface.superClass == "DOMException") {
        spec.superclass(Exception::class)
    }

    spec.addSuperinterfaces(getUnionSuperclasses(iface.name))


    for (superInterface in superInterfaces) {
        spec.addSuperinterface(ClassName(WGPU_PACKAGE, superInterface))
    }

    for (superInterface in superInterfaces) {
        val mixin = idl.definitions.filterIsInstance<Mixin>().find { it.name == superInterface }
        mixin ?: continue
        for (member in mixin.members) {
            generateInterfaceMember(spec, member, override = true)
        }
    }

    for (member in iface.members) {
        generateInterfaceMember(spec, member, override = false)
    }

    val file = FileSpec.builder(WGPU_PACKAGE, iface.name)
    file.addType(spec.build())
    return file
}
