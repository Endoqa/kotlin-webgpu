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

            val iface = idl.definitions
                .filterIsInstance<idl.Interface>()
                .find { it.name == type.name }

            if (iface != null) {
                return Identifier(iface.name)
            }

            val dict = idl.definitions
                .filterIsInstance<idl.Dictionary>()
                .find { it.name == type.name }

            if (dict != null) {
                return Identifier(dict.name)
            }

            val enum = idl.definitions
                .filterIsInstance<idl.Enum>()
                .find { it.name == type.name }

            if (enum != null) {
                return Identifier(enum.name)
            }

            val typedef = idl.definitions
                .filterIsInstance<Typedef>()
                .find { it.name == type.name }

            if (typedef != null) {
                return resolveType(typedef.type)
            }


            type
        }

        else -> type
    }
}