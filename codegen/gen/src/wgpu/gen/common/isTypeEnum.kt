package wgpu.gen.common

import idl.Enum
import idl.Identifier
import idl.Type
import wgpu.gen.GenerateContext

context(GenerateContext)
fun isTypeEnum(type: Type): Boolean {
    if (type !is Identifier) {
        return false
    }

    val enum = idl.definitions
        .filterIsInstance<Enum>()
        .find { it.name == type.name }

    return enum != null
}