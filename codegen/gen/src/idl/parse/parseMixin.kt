package idl.parse

import idl.Attribute
import idl.Mixin
import idl.Operation
import tree_sitter.idl.node.*

context(SourceAvailable)
fun parseMixin(node: MixinNode): Mixin {
    val name = node.name.content()
    val mixin = Mixin(name)

    node.body.members.forEach {
        when (val member = it.member) {
            is ConstNode -> {
                val constant = parseConst(member)
                mixin.constants.add(constant)
            }

            is MaplikeNode -> {
                val maplike = parseMaplike(member)
                mixin.maplikes.add(maplike)
            }

            is SetlikeNode -> {
                val setlike = parseSetlike(member)
                mixin.setlikes.add(setlike)
            }

            is StaticMemberNode -> {
                when (val staticMember = parseStaticMember(member)) {
                    is Attribute -> mixin.attributes.add(staticMember)
                    is Operation -> mixin.operations.add(staticMember)
                }
            }

            is StringifierNode -> {
                val stringifier = parseStringifier(member)
                mixin.stringifiers.add(stringifier)
            }

            is AttributeNode -> {
                val attribute = parseAttribute(member)
                mixin.attributes.add(attribute)
            }

            is RegularOperationNode -> {
                val operation = parseRegularOperation(member)
                mixin.operations.add(operation)
            }

            is SpecialOperationNode -> {
                val operation = parseSpecialOperation(member)
                mixin.operations.add(operation)
            }
        }
    }

    return mixin
}
