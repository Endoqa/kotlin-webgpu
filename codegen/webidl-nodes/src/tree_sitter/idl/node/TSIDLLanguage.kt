package tree_sitter.idl.node

import kotlin.UShort
import tree_sitter.Language

public class TSIDLLanguage(
  public val lang: Language,
) {
  public val _attribute: UShort = lang.idForNodeKind("_attribute", true)

  public val _const_type: UShort = lang.idForNodeKind("_const_type", true)

  public val _const_value: UShort = lang.idForNodeKind("_const_value", true)

  public val _default_value: UShort = lang.idForNodeKind("_default_value", true)

  public val _definition: UShort = lang.idForNodeKind("_definition", true)

  public val _extended_attribute: UShort = lang.idForNodeKind("_extended_attribute", true)

  public val _interface_member_body: UShort = lang.idForNodeKind("_interface_member_body", true)

  public val _mixin_member_body: UShort = lang.idForNodeKind("_mixin_member_body", true)

  public val _namespace_member: UShort = lang.idForNodeKind("_namespace_member", true)

  public val _operation: UShort = lang.idForNodeKind("_operation", true)

  public val _partial_interface_member_body: UShort =
      lang.idForNodeKind("_partial_interface_member_body", true)

  public val _single_type: UShort = lang.idForNodeKind("_single_type", true)

  public val _static_member_body: UShort = lang.idForNodeKind("_static_member_body", true)

  public val _type: UShort = lang.idForNodeKind("_type", true)

  public val float_literal: UShort = lang.idForNodeKind("float_literal", true)

  public val primitive_type: UShort = lang.idForNodeKind("primitive_type", true)

  public val argument: UShort = lang.idForNodeKind("argument", true)

  public val argument_list: UShort = lang.idForNodeKind("argument_list", true)

  public val async_iterable: UShort = lang.idForNodeKind("async_iterable", true)

  public val attribute: UShort = lang.idForNodeKind("attribute", true)

  public val boolean_literal: UShort = lang.idForNodeKind("boolean_literal", true)

  public val buffer_related_type: UShort = lang.idForNodeKind("buffer_related_type", true)

  public val callback_interface: UShort = lang.idForNodeKind("callback_interface", true)

  public val callback_interface_members: UShort = lang.idForNodeKind("callback_interface_members",
      true)

  public val `const`: UShort = lang.idForNodeKind("const", true)

  public val `constructor`: UShort = lang.idForNodeKind("constructor", true)

  public val dictionary: UShort = lang.idForNodeKind("dictionary", true)

  public val dictionary_member: UShort = lang.idForNodeKind("dictionary_member", true)

  public val dictionary_members: UShort = lang.idForNodeKind("dictionary_members", true)

  public val `enum`: UShort = lang.idForNodeKind("enum", true)

  public val extended_attribute_arg_list: UShort = lang.idForNodeKind("extended_attribute_arg_list",
      true)

  public val extended_attribute_ident: UShort = lang.idForNodeKind("extended_attribute_ident", true)

  public val extended_attribute_ident_list: UShort =
      lang.idForNodeKind("extended_attribute_ident_list", true)

  public val extended_attribute_list: UShort = lang.idForNodeKind("extended_attribute_list", true)

  public val extended_attribute_named_arg_list: UShort =
      lang.idForNodeKind("extended_attribute_named_arg_list", true)

  public val extended_attribute_no_args: UShort = lang.idForNodeKind("extended_attribute_no_args",
      true)

  public val float_type: UShort = lang.idForNodeKind("float_type", true)

  public val frozen_array_type: UShort = lang.idForNodeKind("frozen_array_type", true)

  public val includes_statement: UShort = lang.idForNodeKind("includes_statement", true)

  public val integer_type: UShort = lang.idForNodeKind("integer_type", true)

  public val `interface`: UShort = lang.idForNodeKind("interface", true)

  public val interface_member: UShort = lang.idForNodeKind("interface_member", true)

  public val interface_members: UShort = lang.idForNodeKind("interface_members", true)

  public val iterable: UShort = lang.idForNodeKind("iterable", true)

  public val maplike: UShort = lang.idForNodeKind("maplike", true)

  public val mixin: UShort = lang.idForNodeKind("mixin", true)

  public val mixin_member: UShort = lang.idForNodeKind("mixin_member", true)

  public val mixin_members: UShort = lang.idForNodeKind("mixin_members", true)

  public val namespace: UShort = lang.idForNodeKind("namespace", true)

  public val nullable_type: UShort = lang.idForNodeKind("nullable_type", true)

  public val observable_array_type: UShort = lang.idForNodeKind("observable_array_type", true)

  public val partial_dictionary: UShort = lang.idForNodeKind("partial_dictionary", true)

  public val partial_interface: UShort = lang.idForNodeKind("partial_interface", true)

  public val partial_interface_member: UShort = lang.idForNodeKind("partial_interface_member", true)

  public val partial_namespace: UShort = lang.idForNodeKind("partial_namespace", true)

  public val promise_type: UShort = lang.idForNodeKind("promise_type", true)

  public val record_type: UShort = lang.idForNodeKind("record_type", true)

  public val regular_operation: UShort = lang.idForNodeKind("regular_operation", true)

  public val sequence_type: UShort = lang.idForNodeKind("sequence_type", true)

  public val setlike: UShort = lang.idForNodeKind("setlike", true)

  public val source: UShort = lang.idForNodeKind("source", true)

  public val special: UShort = lang.idForNodeKind("special", true)

  public val special_operation: UShort = lang.idForNodeKind("special_operation", true)

  public val static_member: UShort = lang.idForNodeKind("static_member", true)

  public val string_type: UShort = lang.idForNodeKind("string_type", true)

  public val stringifier: UShort = lang.idForNodeKind("stringifier", true)

  public val type_with_extended_attributes: UShort =
      lang.idForNodeKind("type_with_extended_attributes", true)

  public val typedef: UShort = lang.idForNodeKind("typedef", true)

  public val union_type: UShort = lang.idForNodeKind("union_type", true)

  public val comment: UShort = lang.idForNodeKind("comment", true)

  public val decimal: UShort = lang.idForNodeKind("decimal", true)

  public val default_dictionary: UShort = lang.idForNodeKind("default_dictionary", true)

  public val empty_sequence: UShort = lang.idForNodeKind("empty_sequence", true)

  public val identifier: UShort = lang.idForNodeKind("identifier", true)

  public val integer: UShort = lang.idForNodeKind("integer", true)

  public val string: UShort = lang.idForNodeKind("string", true)

  public companion object {
    public val Lang: TSIDLLanguage = TSIDLLanguage(Language.getLanguage("webidl"))
  }
}
