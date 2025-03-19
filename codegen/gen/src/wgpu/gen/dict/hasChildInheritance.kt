package wgpu.gen.dict

import idl.Dictionary
import idl.IDL

fun hasChildInheritance(
    idl: IDL,
    dict: Dictionary
): Boolean {

    val children = idl.definitions
        .filterIsInstance<Dictionary>()
        .filter { it.inherits == dict.name }

    if (children.isEmpty()) {
        return false
    }

    for (child in children) {
        if (hasChildInheritance(idl, child)) {
            return true
        }
    }

    return true

}