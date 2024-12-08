package webgpu.gen.c

import c.lang.CBasicType
import c.lang.CField
import c.lang.CFunction
import c.lang.CFunctionParam
import c.lang.CPointer
import c.lang.CPrimitiveType
import c.lang.CStruct
import c.lang.Identifier
import c.lang.IdentifierKind
import c.lang.ScopedIdentifier
import webgpu.schema.Callback
import webgpu.schema.CallbackStyle


private val opeaquePtr = CPointer(CPrimitiveType(CBasicType.Void))

data class GeneratedCallback(
    val identifier: Identifier,
    val cfunc: CFunction,

    val callbackIdentifier: Identifier,
    val callbackStruct: CStruct

)


fun generateCallback(callback: Callback): GeneratedCallback {
    val (callbackIdentifier, cfunc) = generateCallbackFuncDef(callback)
    val callbackStruct = generateCallbackInfoStruct(callback, callbackIdentifier)
    return GeneratedCallback(callbackIdentifier, cfunc, callbackStruct.id!!, callbackStruct)
}


private fun generateCallbackInfoStruct(callback: Callback, callbackIdentifier: Identifier): CStruct {


    val fields = mutableListOf<CField>()

    fields += CField(
        Identifier("nextInChain"),
        CPointer(WGPUChainedStruct)
    )

    if (callback.style == CallbackStyle.CallbackMode) {
        fields += CField(
            Identifier("mode"),
            ScopedIdentifier(IdentifierKind.enum, Identifier("WGPUCallbackMode"))
        )
    }

    fields += CField(Identifier("callback"), callbackIdentifier)

    fields += CField(Identifier("userdata1"), opeaquePtr)
    fields += CField(Identifier("userdata2"), opeaquePtr)


    return CStruct(
        Identifier("WGPU${callback.name.pascalCase}CallbackInfo"),
        fields,
    )

}


private fun generateCallbackFuncDef(callback: Callback): Pair<Identifier, CFunction> {

    val args = (callback.args ?: emptyList())
        .map { Member(it.name, it.type, it.pointer != null, it.doc) }
        .let { generateCMembers(it) }
        .map { CFunctionParam(it.identifier, it.type, it.doc) }

    val userDatas = listOf(
        CFunctionParam(Identifier("userdata1"), opeaquePtr),
        CFunctionParam(Identifier("userdata2"), opeaquePtr),
    )

    val identifier = Identifier("WGPU${callback.name.pascalCase}Callback")


    val cfunc = CFunction(
        args + userDatas,
        CPrimitiveType(CBasicType.Void),
        true,
        callback.doc
    )

    return identifier to cfunc
}