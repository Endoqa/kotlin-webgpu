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
                mixin.members.add(constant)
            }

            is MaplikeNode -> {
                val maplike = parseMaplike(member)
                mixin.members.add(maplike)
            }

            is SetlikeNode -> {
                val setlike = parseSetlike(member)
                mixin.members.add(setlike)
            }

            is StaticMemberNode -> {
                when (val staticMember = parseStaticMember(member)) {
                    is Attribute -> mixin.members.add(staticMember)
                    is Operation -> mixin.members.add(staticMember)
                }
            }

            is StringifierNode -> {
                val stringifier = parseStringifier(member)
                mixin.members.add(stringifier)
            }

            is AttributeNode -> {
                val attribute = parseAttribute(member)
                mixin.members.add(attribute)
            }

            is RegularOperationNode -> {
                val operation = parseRegularOperation(member)
                mixin.members.add(operation)
            }

            is SpecialOperationNode -> {
                val operation = parseSpecialOperation(member)
                mixin.members.add(operation)
            }
        }
    }

    return mixin
}
