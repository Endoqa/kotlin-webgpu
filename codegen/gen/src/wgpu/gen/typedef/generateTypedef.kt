package wgpu.gen.typedef

import com.squareup.kotlinpoet.*
import idl.Identifier
import idl.Typedef
import idl.UnionType
import wgpu.gen.WGPU_PACKAGE
import wgpu.gen.common.WithIDL
import wgpu.gen.common.resolveKotlinType

fun generateTypedef(alias: Typedef, file: FileSpec.Builder) {
    if (alias.type !is UnionType) {
        val spec = TypeAliasSpec.builder(alias.name, resolveKotlinType(alias.type))
        file.addTypeAlias(spec.build())
        return
    }


    // use sealed interface for unions

    val spec = TypeSpec.interfaceBuilder(ClassName(WGPU_PACKAGE, alias.name))
        .addModifiers(KModifier.SEALED)
    file.addType(spec.build())
}

context(WithIDL)
fun getUnionSuperclasses(identifier: String): List<ClassName> {
    val union = idl.definitions
        .filterIsInstance<Typedef>()
        .filter { it.type is UnionType }
        .filter { typedef ->
            val union = typedef.type
            require(union is UnionType)

            union.memberTypes
                .filterIsInstance<Identifier>()
                .any { it.name == identifier }
        }
        .map {
            ClassName(WGPU_PACKAGE, it.name)
        }

    return union

}