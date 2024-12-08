package webgpu.gen.c

import c.lang.CBasicType
import c.lang.CFunction
import c.lang.CFunctionParam
import c.lang.CPointer
import c.lang.CPrimitiveType
import c.lang.CType
import c.lang.Identifier
import c.lang.IdentifierKind
import c.lang.ScopedIdentifier
import webgpu.schema.Function


fun Function.returnType(): CType {
    if (this.callback != null) {
        return ScopedIdentifier(IdentifierKind.struct, Identifier("WGPUFuture"))
    }

    if (this.returns != null) {
        val type = returns.type.toCType()

        val rtType = if (returns.pointer != null) CPointer(type) else type

        return rtType
    }


    return CPrimitiveType(CBasicType.Void)
}


fun Function.toCFunction(): CFunction {

    val args = (this.args ?: emptyList())
        .map { Member(it.name, it.type, it.pointer != null, it.doc) }
        .let(::generateCMembers)
        .map { CFunctionParam(it.identifier, it.type, it.doc) }
        .toMutableList()


    if (callback != null) {
        args += CFunctionParam(Identifier("callbackInfo"), callback.toCType())
    }

    return CFunction(args, this.returnType(), doc = this.doc)
}

fun generateFunction(function: Function): Pair<Identifier, CFunction> {
    val name = Identifier("wgpu${function.name.pascalCase}")

    return name to function.toCFunction()
}