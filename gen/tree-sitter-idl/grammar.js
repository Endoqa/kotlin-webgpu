module.exports = grammar({
  name: "idl",

  rules: {
    source_file: ($) => repeat($._declaration),
    _declaration: ($) =>
      choice(
        $.enum_declaration,
        $.interface_declaration,
        $.dictionary_declaration,
        $.includes_declaration,
        $.namespace_declaration,
        $.typedef_declaration,
        $.comment,
      ),

    identifier: ($) => /[a-zA-Z_][a-zA-Z0-9_]*/,

    // //comment
    comment: ($) => token(seq("//", /.*/)),

    primitive_type: ($) =>
      choice(
        "undefined",
        "boolean",
        "byte",
        "short",
        "unsigned short",
        "long",
        "float",
        "double",
        "long long",
        "unsigned long",
        "unsigned long long",

        "DOMString",
        "USVString",
      ),

    parameterized: ($) =>
      seq(field("name", $.identifier), field("types", $.type_parameter_list)),

    type_parameter_list: ($) => seq("<", commaSep1($.type), ">"),

    _base_type: ($) => choice($.primitive_type, $.identifier, $.parameterized),

    type: ($) =>
      seq(
        field("attribute", optional($.attributes)),
        field("type", choice($.primitive_type, $.identifier, $.parameterized)),
        field("nullable", optional(token.immediate("?"))),
      ),

    includes_declaration: ($) =>
      seq(
        field("id", $.identifier),
        "includes",
        field("include", $.identifier),
        ";",
      ),

    setlike_declaration: ($) =>
      seq(
        field("readonly", optional("readonly")),
        "setlike",
        "<",
        field("type", $.type),
        ">",
        ";",
      ),

    implements: ($) => seq(":", field("implement", $.identifier)),

    string_literal: ($) => token(seq('"', repeat(/[^"]*/), '"')),
    number_literal: ($) => token(/[0-9]+/),
    hex_literal: ($) => token(/0x[0-9a-fA-F]+/),
    object_literal: ($) => "{}",
    boolean_literal: ($) => choice("true", "false"),
    array_literal: ($) => "[]",

    _literal: ($) =>
      choice(
        $.string_literal,
        $.number_literal,
        $.hex_literal,
        $.object_literal,
        $.boolean_literal,
        $.array_literal,
      ),

    attributes: ($) => seq("[", commaSep($.attribute), "]"),

    attribute: ($) =>
      choice($._attribute_with_value, field("identifier", $.identifier)),

    _attribute_with_value: ($) =>
      seq(
        field("identifier", $.identifier),
        "=",
        field("value", $._attribute_value),
      ),

    _attribute_value: ($) => choice($.identifier, $.attribute_value_set),

    attribute_value_set: ($) => seq("(", commaSep($.identifier), ")"),

    interface_declaration: ($) =>
      seq(
        field("attributes", optional($.attributes)),
        "interface",
        field("is_mixin", optional("mixin")),
        field("name", $.identifier),
        optional($.implements),
        "{",
        field("setlike", optional($.setlike_declaration)),
        field("decls", $.iterface_decl_list),
        ";",
      ),

    iterface_decl_list: ($) =>
      seq(repeat(choice($.interface_member, $.comment)), "}"),

    interface_member: ($) =>
      choice($._field_declaration, $.operation_declaration),

    operation_declaration: ($) =>
      seq(
        field("return_type", $.type),
        field("name", $.identifier),
        "(",
        field("parameters", commaSep($.operation_parameter)),
        ")",
        ";",
      ),

    operation_parameter: ($) =>
      seq(
        field("optional", optional("optional")),
        field("type", $.type),
        field("name", $.identifier),
        optional($._parameter_initializer),
      ),

    _parameter_initializer: ($) => seq("=", field("value", $._literal)),

    _field_declaration: ($) =>
      seq(
        field("attributes", optional($.attributes)),
        field("is_readonly", optional("readonly")),
        "attribute",
        $.type,
        $.identifier,
        ";",
      ),

    _dict_field_declaration: ($) =>
      seq(
        field("required", optional("required")),
        $.type,
        $.identifier,
        optional($._dict_field_initializer),
        ";",
      ),
    _dict_field_initializer: ($) => seq("=", field("value", $._literal)),

    enum_declaration: ($) =>
      seq(
        "enum",
        field("name", $.identifier),
        "{",
        field("values", repeat(choice($.comment, seq($.string_literal, ",")))),
        optional(","),
        "}",
        ";",
      ),

    _inherits: ($) => seq(":", field("inherit", $.identifier)),

    dictionary_declaration: ($) =>
      seq(
        "dictionary",
        field("name", $.identifier),
        optional($._inherits),
        field("decls", repeat($.dictionary_decl_list)),
        ";",
      ),

    dictionary_decl_list: ($) =>
      seq("{", repeat(choice($.dictionary_member, $.comment)), "}"),

    dictionary_member: ($) => $._dict_field_declaration,

    _dict_field_declaration: ($) =>
      seq(
        field("required", optional("required")),
        field("type", $.type),
        field("name", $.identifier),
        optional($._dict_field_initializer),
        ";",
      ),

    _dict_field_initializer: ($) => seq("=", field("value", $._literal)),

    namespace_declaration: ($) =>
      seq(
        field("attributes", optional($.attributes)),
        "namespace",
        field("name", $.identifier),
        "{",
        field("members", repeat(choice($._namespace_member, $.comment))),
        "}",
        ";",
      ),
    _namespace_member: ($) =>
      seq(
        "const",
        field("type", $.type),
        field("name", $.identifier),
        "=",
        field("value", choice($.number_literal, $.hex_literal)),
        ";",
      ),

    typedef_declaration: ($) =>
      seq("typedef", field("type", $.type), field("name", $.identifier), ";"),
  },
});

function commaSep1(rule) {
  return seq(rule, repeat(seq(",", rule)));
}

function commaSep(rule) {
  return optional(commaSep1(rule));
}
