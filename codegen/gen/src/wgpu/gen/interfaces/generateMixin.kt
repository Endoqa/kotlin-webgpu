package wgpu.gen.interfaces

import com.squareup.kotlinpoet.ClassName
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.TypeSpec
import wgpu.gen.WGPU_PACKAGE


fun generateMixin(mixin: idl.Mixin): FileSpec.Builder {
    val spec = TypeSpec.interfaceBuilder(ClassName(WGPU_PACKAGE, mixin.name))

    for (member in mixin.members) {
        generateInterfaceMember(spec, member, false, inMixin = true)
    }


    val file = FileSpec.builder(WGPU_PACKAGE, mixin.name)
    file.addType(spec.build())
    return file
}