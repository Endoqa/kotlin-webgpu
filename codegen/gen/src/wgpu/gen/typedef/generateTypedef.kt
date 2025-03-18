package wgpu.gen.typedef

import com.squareup.kotlinpoet.TypeAliasSpec
import idl.Typedef
import wgpu.gen.common.resolveKotlinType

fun generateTypedef(alias: Typedef): TypeAliasSpec {
    val spec = TypeAliasSpec.builder(alias.name, resolveKotlinType(alias.type))

    return spec.build()
}
