package webgpu.gen.c

import c.lang.*
import webgpu.schema.ComplexType
import webgpu.schema.Name
import webgpu.schema.Type
import webgpu.schema.singularize

data class Member(
    val name: Name,
    val type: Type,
    val isPointer: Boolean,
    val doc: String
)

data class CMember(
    val identifier: Identifier,
    val type: CType,
    val doc: String,
)

private val size_t = CPrimitiveType(null, listOf(TypeModifier.Unsigned, TypeModifier.Long))

fun generateCMembers(members: List<Member>): List<CMember> {

    val cMembers = mutableListOf<CMember>()

    members.forEach { member ->

        val memberType = member.type

        if (memberType is ComplexType && memberType.isArray) {
            cMembers.add(
                CMember(
                    Identifier("${singularize(member.name.camelCase)}Count"),
                    size_t,
                    "Array count for ${member.name.camelCase}."
                )
            )

            cMembers.add(
                CMember(
                    Identifier(member.name.camelCase),
                    CPointer(memberType.toCType()),
                    member.doc
                )
            )
        } else {
            val cType = memberType.toCType()
            cMembers.add(
                CMember(
                    Identifier(member.name.camelCase),
                    if (member.isPointer) CPointer(cType) else cType,
                    member.doc
                )
            )
        }


    }


    return cMembers

}