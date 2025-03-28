package tree_sitter.idl.node

import tree_sitter.Node

public fun createNode(node: Node): IDLNodeBase {
    if (!node.isNamed) {
        return IDLNodeBase.Unnamed(node)
    }
    return when (node.kindID) {
        TSIDLLanguage.Lang._attribute -> _AttributeNode(node)
        TSIDLLanguage.Lang._const_type -> _ConstTypeNode(node)
        TSIDLLanguage.Lang._const_value -> _ConstValueNode(node)
        TSIDLLanguage.Lang._default_value -> _DefaultValueNode(node)
        TSIDLLanguage.Lang._definition -> _DefinitionNode(node)
        TSIDLLanguage.Lang._extended_attribute -> _ExtendedAttributeNode(node)
        TSIDLLanguage.Lang._interface_member_body -> _InterfaceMemberBodyNode(node)
        TSIDLLanguage.Lang._mixin_member_body -> _MixinMemberBodyNode(node)
        TSIDLLanguage.Lang._namespace_member -> _NamespaceMemberNode(node)
        TSIDLLanguage.Lang._operation -> _OperationNode(node)
        TSIDLLanguage.Lang._partial_interface_member_body -> _PartialInterfaceMemberBodyNode(node)
        TSIDLLanguage.Lang._single_type -> _SingleTypeNode(node)
        TSIDLLanguage.Lang._static_member_body -> _StaticMemberBodyNode(node)
        TSIDLLanguage.Lang._type -> _TypeNode(node)
        TSIDLLanguage.Lang.float_literal -> FloatLiteralNode(node)
        TSIDLLanguage.Lang.primitive_type -> PrimitiveTypeNode(node)
        TSIDLLanguage.Lang.argument -> ArgumentNode(node)
        TSIDLLanguage.Lang.argument_list -> ArgumentListNode(node)
        TSIDLLanguage.Lang.async_iterable -> AsyncIterableNode(node)
        TSIDLLanguage.Lang.attribute -> AttributeNode(node)
        TSIDLLanguage.Lang.base_integer_type -> BaseIntegerTypeNode(node)
        TSIDLLanguage.Lang.boolean_literal -> BooleanLiteralNode(node)
        TSIDLLanguage.Lang.buffer_related_type -> BufferRelatedTypeNode(node)
        TSIDLLanguage.Lang.callback_interface -> CallbackInterfaceNode(node)
        TSIDLLanguage.Lang.callback_interface_members -> CallbackInterfaceMembersNode(node)
        TSIDLLanguage.Lang.`const` -> ConstNode(node)
        TSIDLLanguage.Lang.`constructor` -> ConstructorNode(node)
        TSIDLLanguage.Lang.dictionary -> DictionaryNode(node)
        TSIDLLanguage.Lang.dictionary_member -> DictionaryMemberNode(node)
        TSIDLLanguage.Lang.dictionary_members -> DictionaryMembersNode(node)
        TSIDLLanguage.Lang.`enum` -> EnumNode(node)
        TSIDLLanguage.Lang.extended_attribute_arg_list -> ExtendedAttributeArgListNode(node)
        TSIDLLanguage.Lang.extended_attribute_ident -> ExtendedAttributeIdentNode(node)
        TSIDLLanguage.Lang.extended_attribute_ident_list -> ExtendedAttributeIdentListNode(node)
        TSIDLLanguage.Lang.extended_attribute_list -> ExtendedAttributeListNode(node)
        TSIDLLanguage.Lang.extended_attribute_named_arg_list -> ExtendedAttributeNamedArgListNode(node)
        TSIDLLanguage.Lang.extended_attribute_no_args -> ExtendedAttributeNoArgsNode(node)
        TSIDLLanguage.Lang.float_type -> FloatTypeNode(node)
        TSIDLLanguage.Lang.frozen_array_type -> FrozenArrayTypeNode(node)
        TSIDLLanguage.Lang.includes_statement -> IncludesStatementNode(node)
        TSIDLLanguage.Lang.integer_type -> IntegerTypeNode(node)
        TSIDLLanguage.Lang.`interface` -> InterfaceNode(node)
        TSIDLLanguage.Lang.interface_member -> InterfaceMemberNode(node)
        TSIDLLanguage.Lang.interface_members -> InterfaceMembersNode(node)
        TSIDLLanguage.Lang.iterable -> IterableNode(node)
        TSIDLLanguage.Lang.maplike -> MaplikeNode(node)
        TSIDLLanguage.Lang.mixin -> MixinNode(node)
        TSIDLLanguage.Lang.mixin_member -> MixinMemberNode(node)
        TSIDLLanguage.Lang.mixin_members -> MixinMembersNode(node)
        TSIDLLanguage.Lang.namespace -> NamespaceNode(node)
        TSIDLLanguage.Lang.nullable_type -> NullableTypeNode(node)
        TSIDLLanguage.Lang.observable_array_type -> ObservableArrayTypeNode(node)
        TSIDLLanguage.Lang.partial_dictionary -> PartialDictionaryNode(node)
        TSIDLLanguage.Lang.partial_interface -> PartialInterfaceNode(node)
        TSIDLLanguage.Lang.partial_interface_member -> PartialInterfaceMemberNode(node)
        TSIDLLanguage.Lang.partial_namespace -> PartialNamespaceNode(node)
        TSIDLLanguage.Lang.promise_type -> PromiseTypeNode(node)
        TSIDLLanguage.Lang.record_type -> RecordTypeNode(node)
        TSIDLLanguage.Lang.regular_operation -> RegularOperationNode(node)
        TSIDLLanguage.Lang.sequence_type -> SequenceTypeNode(node)
        TSIDLLanguage.Lang.setlike -> SetlikeNode(node)
        TSIDLLanguage.Lang.source -> SourceNode(node)
        TSIDLLanguage.Lang.special -> SpecialNode(node)
        TSIDLLanguage.Lang.special_operation -> SpecialOperationNode(node)
        TSIDLLanguage.Lang.static_member -> StaticMemberNode(node)
        TSIDLLanguage.Lang.string_type -> StringTypeNode(node)
        TSIDLLanguage.Lang.stringifier -> StringifierNode(node)
        TSIDLLanguage.Lang.type_with_extended_attributes -> TypeWithExtendedAttributesNode(node)
        TSIDLLanguage.Lang.typedef -> TypedefNode(node)
        TSIDLLanguage.Lang.union_type -> UnionTypeNode(node)
        TSIDLLanguage.Lang.comment -> CommentNode(node)
        TSIDLLanguage.Lang.decimal -> DecimalNode(node)
        TSIDLLanguage.Lang.default_dictionary -> DefaultDictionaryNode(node)
        TSIDLLanguage.Lang.empty_sequence -> EmptySequenceNode(node)
        TSIDLLanguage.Lang.identifier -> IdentifierNode(node)
        TSIDLLanguage.Lang.integer -> IntegerNode(node)
        TSIDLLanguage.Lang.string -> StringNode(node)
        else -> error("Unknown node type")
    }
}
