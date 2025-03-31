package wgpu.gen.preprocess

import idl.*
import wgpu.gen.common.WithIDL
import wgpu.gen.common.resolveActualType

private val excludeMixin = listOf("NavigatorGPU")

private val excludeInterface =
    listOf("GPUCanvasContext", "GPUCanvasConfiguration", "GPUCanvasAlphaMode", "EventHandler")

private val excludeTypedefs = listOf("GPUCopyExternalImageSource")

private val excludeDictionaries = listOf(
    "GPUExternalTextureDescriptor",
    "GPUExternalTextureBindingLayout",
    "GPUCopyExternalImageDestInfo",
    "GPUCopyExternalImageSourceInfo",
    "GPUCanvasToneMapping",
    "GPUCanvasConfiguration",
)

private val excludeEnums = listOf(
    "GPUCanvasAlphaMode",
    "GPUCanvasToneMappingMode"
)

context(WithIDL)
private fun isInExclude(type: Type): Boolean {
    return when (val t = resolveActualType(type)) {
        is Identifier -> t.name in excludeInterface || t.name in excludeTypedefs || t.name in excludeDictionaries
        is NullableType -> isInExclude(t.innerType)
        else -> false
    }
}


context(WithIDL)
internal fun removeUnwanted() {


    idl.definitions
        .filterIsInstance<Dictionary>()
        .toList()
        .forEach { dict ->
            if (dict.inherits == "EventInit") {
                val newDict = dict.copy(inherits = null)
                val idx = idl.definitions.indexOf(dict)
                require(idx >= 0)
                idl.definitions[idx] = newDict
            }

        }


    // remove members
    idl.definitions.forEach { def ->
        when (def) {

            is Dictionary -> {
                def.members.removeIf { member ->
                    isInExclude(member.type)
                }
            }


            is Interface -> {

                def.members.removeIf { member ->
                    when (member) {

                        is Attribute -> isInExclude(member.type)
                        is Constructor -> {
                            member.parameters.any { isInExclude(it.type) }
                        }

                        is Operation -> {
                            member.parameters.any { isInExclude(it.type) } || isInExclude(member.returnType)
                        }

//                        is AsyncIterable -> TODO()
//                        is Constant -> TODO()
//                        is Iterable -> TODO()
//                        is Maplike -> TODO()
//
//                        is Setlike -> TODO()
//                        is Stringifier -> TODO()

                        else -> false
                    }

                }

            }

            is Mixin -> {
                def.members.removeIf { member ->
                    when (member) {

                        is Attribute -> isInExclude(member.type)
                        is Constructor -> {
                            member.parameters.any { isInExclude(it.type) }
                        }

                        is Operation -> {
                            member.parameters.any { isInExclude(it.type) } || isInExclude(member.returnType)
                        }

                        else -> false
                    }


                }
            }

            else -> {}

//            is Namespace -> TODO()
//            is Typedef -> TODO()
//            is CallbackInterface -> TODO()
//            is Enum -> TODO()
//            is Include -> TODO()
        }
    }


    // remove definitions
    idl.definitions.removeIf { type ->
        type is Interface && type.name in excludeInterface
    }

    idl.definitions.removeIf { type ->
        type is Typedef && type.name in excludeTypedefs
    }

    idl.definitions.removeIf { type ->
        type is Dictionary && type.name in excludeDictionaries
    }

    idl.definitions.removeIf { type ->
        type is idl.Enum && type.name in excludeEnums
    }

    idl.definitions.removeIf { type ->
        type is Mixin && type.name in excludeMixin
    }

}