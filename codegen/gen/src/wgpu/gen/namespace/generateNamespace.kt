package wgpu.gen.namespace

import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.KModifier
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import idl.Constant
import idl.Namespace
import wgpu.gen.GenerateContext
import wgpu.gen.WGPU_PACKAGE
import wgpu.gen.common.resolveKotlinType
import wgpu.gen.interfaces.generateInterfaceMember

context(GenerateContext)
fun generateNamespace(namespace: Namespace): FileSpec.Builder {
    val file = FileSpec.builder(WGPU_PACKAGE, namespace.name)

    // Create an object for the namespace
    val objectSpec = TypeSpec.objectBuilder(namespace.name)

    // Add members to the object
    for (member in namespace.members) {
        when (member) {
            is Constant -> {
                // Add constant as a property
                val property = PropertySpec.builder(
                    member.name,
                    resolveKotlinType(member.type)
                )
                    .addModifiers(KModifier.CONST)
                    .initializer("%LU", member.value) // this assumption only works in webgpu
                    .build()

                objectSpec.addProperty(property)
            }

            else -> {
                // Use generateInterfaceMember for other member types
                generateInterfaceMember(objectSpec, member, override = false)
            }
        }
    }

    // Add the object to the file
    file.addType(objectSpec.build())

    return file
}
