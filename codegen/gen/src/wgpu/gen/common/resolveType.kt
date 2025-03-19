package wgpu.gen.common

import idl.IDL
import idl.Identifier
import idl.Type
import idl.Typedef


interface WithIDL {
    val idl: IDL
}

context(WithIDL)
fun resolveType(type: Type): Type {
    return when (type) {
        is Identifier -> {
            val typedef = idl.definitions
                .filterIsInstance<Typedef>()
                .find { it.name == type.name }
                ?: error("Unknown type $type")

            resolveType(typedef.type)
        }

        else -> type
    }
}