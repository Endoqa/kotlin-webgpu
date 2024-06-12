#include "tree_sitter/parser.h"

#if defined(__GNUC__) || defined(__clang__)
#pragma GCC diagnostic ignored "-Wmissing-field-initializers"
#endif

#ifdef _MSC_VER
#pragma optimize("", off)
#elif defined(__clang__)
#pragma clang optimize off
#elif defined(__GNUC__)
#pragma GCC optimize ("O0")
#endif

#define LANGUAGE_VERSION 14
#define STATE_COUNT 259
#define LARGE_STATE_COUNT 2
#define SYMBOL_COUNT 92
#define ALIAS_COUNT 0
#define TOKEN_COUNT 49
#define EXTERNAL_TOKEN_COUNT 0
#define FIELD_COUNT 23
#define MAX_ALIAS_SEQUENCE_LENGTH 9
#define PRODUCTION_ID_COUNT 57

enum ts_symbol_identifiers {
  sym_identifier = 1,
  sym_comment = 2,
  anon_sym_undefined = 3,
  anon_sym_boolean = 4,
  anon_sym_byte = 5,
  anon_sym_short = 6,
  anon_sym_unsignedshort = 7,
  anon_sym_long = 8,
  anon_sym_float = 9,
  anon_sym_double = 10,
  anon_sym_longlong = 11,
  anon_sym_unsignedlong = 12,
  anon_sym_unsignedlonglong = 13,
  anon_sym_DOMString = 14,
  anon_sym_USVString = 15,
  anon_sym_LT = 16,
  anon_sym_COMMA = 17,
  anon_sym_GT = 18,
  anon_sym_QMARK = 19,
  anon_sym_includes = 20,
  anon_sym_SEMI = 21,
  anon_sym_readonly = 22,
  anon_sym_setlike = 23,
  anon_sym_COLON = 24,
  sym_string_literal = 25,
  sym_number_literal = 26,
  sym_hex_literal = 27,
  sym_object_literal = 28,
  anon_sym_true = 29,
  anon_sym_false = 30,
  sym_array_literal = 31,
  anon_sym_LBRACK = 32,
  anon_sym_RBRACK = 33,
  anon_sym_EQ = 34,
  anon_sym_LPAREN = 35,
  anon_sym_RPAREN = 36,
  anon_sym_interface = 37,
  anon_sym_mixin = 38,
  anon_sym_LBRACE = 39,
  anon_sym_RBRACE = 40,
  anon_sym_optional = 41,
  anon_sym_attribute = 42,
  anon_sym_required = 43,
  anon_sym_enum = 44,
  anon_sym_dictionary = 45,
  anon_sym_namespace = 46,
  anon_sym_const = 47,
  anon_sym_typedef = 48,
  sym_source_file = 49,
  sym__declaration = 50,
  sym_primitive_type = 51,
  sym_parameterized = 52,
  sym_type_parameter_list = 53,
  sym_type = 54,
  sym_includes_declaration = 55,
  sym_setlike_declaration = 56,
  sym_implements = 57,
  sym_boolean_literal = 58,
  sym__literal = 59,
  sym_attributes = 60,
  sym_attribute = 61,
  sym__attribute_with_value = 62,
  sym__attribute_value = 63,
  sym_attribute_value_set = 64,
  sym_interface_declaration = 65,
  sym_iterface_decl_list = 66,
  sym_interface_member = 67,
  sym_operation_declaration = 68,
  sym_operation_parameter = 69,
  sym__parameter_initializer = 70,
  sym__field_declaration = 71,
  sym__dict_field_declaration = 72,
  sym__dict_field_initializer = 73,
  sym_enum_declaration = 74,
  sym__inherits = 75,
  sym_dictionary_declaration = 76,
  sym_dictionary_decl_list = 77,
  sym_dictionary_member = 78,
  sym_namespace_declaration = 79,
  sym__namespace_member = 80,
  sym_typedef_declaration = 81,
  aux_sym_source_file_repeat1 = 82,
  aux_sym_type_parameter_list_repeat1 = 83,
  aux_sym_attributes_repeat1 = 84,
  aux_sym_attribute_value_set_repeat1 = 85,
  aux_sym_iterface_decl_list_repeat1 = 86,
  aux_sym_operation_declaration_repeat1 = 87,
  aux_sym_enum_declaration_repeat1 = 88,
  aux_sym_dictionary_declaration_repeat1 = 89,
  aux_sym_dictionary_decl_list_repeat1 = 90,
  aux_sym_namespace_declaration_repeat1 = 91,
};

static const char * const ts_symbol_names[] = {
  [ts_builtin_sym_end] = "end",
  [sym_identifier] = "identifier",
  [sym_comment] = "comment",
  [anon_sym_undefined] = "undefined",
  [anon_sym_boolean] = "boolean",
  [anon_sym_byte] = "byte",
  [anon_sym_short] = "short",
  [anon_sym_unsignedshort] = "unsigned short",
  [anon_sym_long] = "long",
  [anon_sym_float] = "float",
  [anon_sym_double] = "double",
  [anon_sym_longlong] = "long long",
  [anon_sym_unsignedlong] = "unsigned long",
  [anon_sym_unsignedlonglong] = "unsigned long long",
  [anon_sym_DOMString] = "DOMString",
  [anon_sym_USVString] = "USVString",
  [anon_sym_LT] = "<",
  [anon_sym_COMMA] = ",",
  [anon_sym_GT] = ">",
  [anon_sym_QMARK] = "\?",
  [anon_sym_includes] = "includes",
  [anon_sym_SEMI] = ";",
  [anon_sym_readonly] = "readonly",
  [anon_sym_setlike] = "setlike",
  [anon_sym_COLON] = ":",
  [sym_string_literal] = "string_literal",
  [sym_number_literal] = "number_literal",
  [sym_hex_literal] = "hex_literal",
  [sym_object_literal] = "object_literal",
  [anon_sym_true] = "true",
  [anon_sym_false] = "false",
  [sym_array_literal] = "array_literal",
  [anon_sym_LBRACK] = "[",
  [anon_sym_RBRACK] = "]",
  [anon_sym_EQ] = "=",
  [anon_sym_LPAREN] = "(",
  [anon_sym_RPAREN] = ")",
  [anon_sym_interface] = "interface",
  [anon_sym_mixin] = "mixin",
  [anon_sym_LBRACE] = "{",
  [anon_sym_RBRACE] = "}",
  [anon_sym_optional] = "optional",
  [anon_sym_attribute] = "attribute",
  [anon_sym_required] = "required",
  [anon_sym_enum] = "enum",
  [anon_sym_dictionary] = "dictionary",
  [anon_sym_namespace] = "namespace",
  [anon_sym_const] = "const",
  [anon_sym_typedef] = "typedef",
  [sym_source_file] = "source_file",
  [sym__declaration] = "_declaration",
  [sym_primitive_type] = "primitive_type",
  [sym_parameterized] = "parameterized",
  [sym_type_parameter_list] = "type_parameter_list",
  [sym_type] = "type",
  [sym_includes_declaration] = "includes_declaration",
  [sym_setlike_declaration] = "setlike_declaration",
  [sym_implements] = "implements",
  [sym_boolean_literal] = "boolean_literal",
  [sym__literal] = "_literal",
  [sym_attributes] = "attributes",
  [sym_attribute] = "attribute",
  [sym__attribute_with_value] = "_attribute_with_value",
  [sym__attribute_value] = "_attribute_value",
  [sym_attribute_value_set] = "attribute_value_set",
  [sym_interface_declaration] = "interface_declaration",
  [sym_iterface_decl_list] = "iterface_decl_list",
  [sym_interface_member] = "interface_member",
  [sym_operation_declaration] = "operation_declaration",
  [sym_operation_parameter] = "operation_parameter",
  [sym__parameter_initializer] = "_parameter_initializer",
  [sym__field_declaration] = "_field_declaration",
  [sym__dict_field_declaration] = "_dict_field_declaration",
  [sym__dict_field_initializer] = "_dict_field_initializer",
  [sym_enum_declaration] = "enum_declaration",
  [sym__inherits] = "_inherits",
  [sym_dictionary_declaration] = "dictionary_declaration",
  [sym_dictionary_decl_list] = "dictionary_decl_list",
  [sym_dictionary_member] = "dictionary_member",
  [sym_namespace_declaration] = "namespace_declaration",
  [sym__namespace_member] = "_namespace_member",
  [sym_typedef_declaration] = "typedef_declaration",
  [aux_sym_source_file_repeat1] = "source_file_repeat1",
  [aux_sym_type_parameter_list_repeat1] = "type_parameter_list_repeat1",
  [aux_sym_attributes_repeat1] = "attributes_repeat1",
  [aux_sym_attribute_value_set_repeat1] = "attribute_value_set_repeat1",
  [aux_sym_iterface_decl_list_repeat1] = "iterface_decl_list_repeat1",
  [aux_sym_operation_declaration_repeat1] = "operation_declaration_repeat1",
  [aux_sym_enum_declaration_repeat1] = "enum_declaration_repeat1",
  [aux_sym_dictionary_declaration_repeat1] = "dictionary_declaration_repeat1",
  [aux_sym_dictionary_decl_list_repeat1] = "dictionary_decl_list_repeat1",
  [aux_sym_namespace_declaration_repeat1] = "namespace_declaration_repeat1",
};

static const TSSymbol ts_symbol_map[] = {
  [ts_builtin_sym_end] = ts_builtin_sym_end,
  [sym_identifier] = sym_identifier,
  [sym_comment] = sym_comment,
  [anon_sym_undefined] = anon_sym_undefined,
  [anon_sym_boolean] = anon_sym_boolean,
  [anon_sym_byte] = anon_sym_byte,
  [anon_sym_short] = anon_sym_short,
  [anon_sym_unsignedshort] = anon_sym_unsignedshort,
  [anon_sym_long] = anon_sym_long,
  [anon_sym_float] = anon_sym_float,
  [anon_sym_double] = anon_sym_double,
  [anon_sym_longlong] = anon_sym_longlong,
  [anon_sym_unsignedlong] = anon_sym_unsignedlong,
  [anon_sym_unsignedlonglong] = anon_sym_unsignedlonglong,
  [anon_sym_DOMString] = anon_sym_DOMString,
  [anon_sym_USVString] = anon_sym_USVString,
  [anon_sym_LT] = anon_sym_LT,
  [anon_sym_COMMA] = anon_sym_COMMA,
  [anon_sym_GT] = anon_sym_GT,
  [anon_sym_QMARK] = anon_sym_QMARK,
  [anon_sym_includes] = anon_sym_includes,
  [anon_sym_SEMI] = anon_sym_SEMI,
  [anon_sym_readonly] = anon_sym_readonly,
  [anon_sym_setlike] = anon_sym_setlike,
  [anon_sym_COLON] = anon_sym_COLON,
  [sym_string_literal] = sym_string_literal,
  [sym_number_literal] = sym_number_literal,
  [sym_hex_literal] = sym_hex_literal,
  [sym_object_literal] = sym_object_literal,
  [anon_sym_true] = anon_sym_true,
  [anon_sym_false] = anon_sym_false,
  [sym_array_literal] = sym_array_literal,
  [anon_sym_LBRACK] = anon_sym_LBRACK,
  [anon_sym_RBRACK] = anon_sym_RBRACK,
  [anon_sym_EQ] = anon_sym_EQ,
  [anon_sym_LPAREN] = anon_sym_LPAREN,
  [anon_sym_RPAREN] = anon_sym_RPAREN,
  [anon_sym_interface] = anon_sym_interface,
  [anon_sym_mixin] = anon_sym_mixin,
  [anon_sym_LBRACE] = anon_sym_LBRACE,
  [anon_sym_RBRACE] = anon_sym_RBRACE,
  [anon_sym_optional] = anon_sym_optional,
  [anon_sym_attribute] = anon_sym_attribute,
  [anon_sym_required] = anon_sym_required,
  [anon_sym_enum] = anon_sym_enum,
  [anon_sym_dictionary] = anon_sym_dictionary,
  [anon_sym_namespace] = anon_sym_namespace,
  [anon_sym_const] = anon_sym_const,
  [anon_sym_typedef] = anon_sym_typedef,
  [sym_source_file] = sym_source_file,
  [sym__declaration] = sym__declaration,
  [sym_primitive_type] = sym_primitive_type,
  [sym_parameterized] = sym_parameterized,
  [sym_type_parameter_list] = sym_type_parameter_list,
  [sym_type] = sym_type,
  [sym_includes_declaration] = sym_includes_declaration,
  [sym_setlike_declaration] = sym_setlike_declaration,
  [sym_implements] = sym_implements,
  [sym_boolean_literal] = sym_boolean_literal,
  [sym__literal] = sym__literal,
  [sym_attributes] = sym_attributes,
  [sym_attribute] = sym_attribute,
  [sym__attribute_with_value] = sym__attribute_with_value,
  [sym__attribute_value] = sym__attribute_value,
  [sym_attribute_value_set] = sym_attribute_value_set,
  [sym_interface_declaration] = sym_interface_declaration,
  [sym_iterface_decl_list] = sym_iterface_decl_list,
  [sym_interface_member] = sym_interface_member,
  [sym_operation_declaration] = sym_operation_declaration,
  [sym_operation_parameter] = sym_operation_parameter,
  [sym__parameter_initializer] = sym__parameter_initializer,
  [sym__field_declaration] = sym__field_declaration,
  [sym__dict_field_declaration] = sym__dict_field_declaration,
  [sym__dict_field_initializer] = sym__dict_field_initializer,
  [sym_enum_declaration] = sym_enum_declaration,
  [sym__inherits] = sym__inherits,
  [sym_dictionary_declaration] = sym_dictionary_declaration,
  [sym_dictionary_decl_list] = sym_dictionary_decl_list,
  [sym_dictionary_member] = sym_dictionary_member,
  [sym_namespace_declaration] = sym_namespace_declaration,
  [sym__namespace_member] = sym__namespace_member,
  [sym_typedef_declaration] = sym_typedef_declaration,
  [aux_sym_source_file_repeat1] = aux_sym_source_file_repeat1,
  [aux_sym_type_parameter_list_repeat1] = aux_sym_type_parameter_list_repeat1,
  [aux_sym_attributes_repeat1] = aux_sym_attributes_repeat1,
  [aux_sym_attribute_value_set_repeat1] = aux_sym_attribute_value_set_repeat1,
  [aux_sym_iterface_decl_list_repeat1] = aux_sym_iterface_decl_list_repeat1,
  [aux_sym_operation_declaration_repeat1] = aux_sym_operation_declaration_repeat1,
  [aux_sym_enum_declaration_repeat1] = aux_sym_enum_declaration_repeat1,
  [aux_sym_dictionary_declaration_repeat1] = aux_sym_dictionary_declaration_repeat1,
  [aux_sym_dictionary_decl_list_repeat1] = aux_sym_dictionary_decl_list_repeat1,
  [aux_sym_namespace_declaration_repeat1] = aux_sym_namespace_declaration_repeat1,
};

static const TSSymbolMetadata ts_symbol_metadata[] = {
  [ts_builtin_sym_end] = {
    .visible = false,
    .named = true,
  },
  [sym_identifier] = {
    .visible = true,
    .named = true,
  },
  [sym_comment] = {
    .visible = true,
    .named = true,
  },
  [anon_sym_undefined] = {
    .visible = true,
    .named = false,
  },
  [anon_sym_boolean] = {
    .visible = true,
    .named = false,
  },
  [anon_sym_byte] = {
    .visible = true,
    .named = false,
  },
  [anon_sym_short] = {
    .visible = true,
    .named = false,
  },
  [anon_sym_unsignedshort] = {
    .visible = true,
    .named = false,
  },
  [anon_sym_long] = {
    .visible = true,
    .named = false,
  },
  [anon_sym_float] = {
    .visible = true,
    .named = false,
  },
  [anon_sym_double] = {
    .visible = true,
    .named = false,
  },
  [anon_sym_longlong] = {
    .visible = true,
    .named = false,
  },
  [anon_sym_unsignedlong] = {
    .visible = true,
    .named = false,
  },
  [anon_sym_unsignedlonglong] = {
    .visible = true,
    .named = false,
  },
  [anon_sym_DOMString] = {
    .visible = true,
    .named = false,
  },
  [anon_sym_USVString] = {
    .visible = true,
    .named = false,
  },
  [anon_sym_LT] = {
    .visible = true,
    .named = false,
  },
  [anon_sym_COMMA] = {
    .visible = true,
    .named = false,
  },
  [anon_sym_GT] = {
    .visible = true,
    .named = false,
  },
  [anon_sym_QMARK] = {
    .visible = true,
    .named = false,
  },
  [anon_sym_includes] = {
    .visible = true,
    .named = false,
  },
  [anon_sym_SEMI] = {
    .visible = true,
    .named = false,
  },
  [anon_sym_readonly] = {
    .visible = true,
    .named = false,
  },
  [anon_sym_setlike] = {
    .visible = true,
    .named = false,
  },
  [anon_sym_COLON] = {
    .visible = true,
    .named = false,
  },
  [sym_string_literal] = {
    .visible = true,
    .named = true,
  },
  [sym_number_literal] = {
    .visible = true,
    .named = true,
  },
  [sym_hex_literal] = {
    .visible = true,
    .named = true,
  },
  [sym_object_literal] = {
    .visible = true,
    .named = true,
  },
  [anon_sym_true] = {
    .visible = true,
    .named = false,
  },
  [anon_sym_false] = {
    .visible = true,
    .named = false,
  },
  [sym_array_literal] = {
    .visible = true,
    .named = true,
  },
  [anon_sym_LBRACK] = {
    .visible = true,
    .named = false,
  },
  [anon_sym_RBRACK] = {
    .visible = true,
    .named = false,
  },
  [anon_sym_EQ] = {
    .visible = true,
    .named = false,
  },
  [anon_sym_LPAREN] = {
    .visible = true,
    .named = false,
  },
  [anon_sym_RPAREN] = {
    .visible = true,
    .named = false,
  },
  [anon_sym_interface] = {
    .visible = true,
    .named = false,
  },
  [anon_sym_mixin] = {
    .visible = true,
    .named = false,
  },
  [anon_sym_LBRACE] = {
    .visible = true,
    .named = false,
  },
  [anon_sym_RBRACE] = {
    .visible = true,
    .named = false,
  },
  [anon_sym_optional] = {
    .visible = true,
    .named = false,
  },
  [anon_sym_attribute] = {
    .visible = true,
    .named = false,
  },
  [anon_sym_required] = {
    .visible = true,
    .named = false,
  },
  [anon_sym_enum] = {
    .visible = true,
    .named = false,
  },
  [anon_sym_dictionary] = {
    .visible = true,
    .named = false,
  },
  [anon_sym_namespace] = {
    .visible = true,
    .named = false,
  },
  [anon_sym_const] = {
    .visible = true,
    .named = false,
  },
  [anon_sym_typedef] = {
    .visible = true,
    .named = false,
  },
  [sym_source_file] = {
    .visible = true,
    .named = true,
  },
  [sym__declaration] = {
    .visible = false,
    .named = true,
  },
  [sym_primitive_type] = {
    .visible = true,
    .named = true,
  },
  [sym_parameterized] = {
    .visible = true,
    .named = true,
  },
  [sym_type_parameter_list] = {
    .visible = true,
    .named = true,
  },
  [sym_type] = {
    .visible = true,
    .named = true,
  },
  [sym_includes_declaration] = {
    .visible = true,
    .named = true,
  },
  [sym_setlike_declaration] = {
    .visible = true,
    .named = true,
  },
  [sym_implements] = {
    .visible = true,
    .named = true,
  },
  [sym_boolean_literal] = {
    .visible = true,
    .named = true,
  },
  [sym__literal] = {
    .visible = false,
    .named = true,
  },
  [sym_attributes] = {
    .visible = true,
    .named = true,
  },
  [sym_attribute] = {
    .visible = true,
    .named = true,
  },
  [sym__attribute_with_value] = {
    .visible = false,
    .named = true,
  },
  [sym__attribute_value] = {
    .visible = false,
    .named = true,
  },
  [sym_attribute_value_set] = {
    .visible = true,
    .named = true,
  },
  [sym_interface_declaration] = {
    .visible = true,
    .named = true,
  },
  [sym_iterface_decl_list] = {
    .visible = true,
    .named = true,
  },
  [sym_interface_member] = {
    .visible = true,
    .named = true,
  },
  [sym_operation_declaration] = {
    .visible = true,
    .named = true,
  },
  [sym_operation_parameter] = {
    .visible = true,
    .named = true,
  },
  [sym__parameter_initializer] = {
    .visible = false,
    .named = true,
  },
  [sym__field_declaration] = {
    .visible = false,
    .named = true,
  },
  [sym__dict_field_declaration] = {
    .visible = false,
    .named = true,
  },
  [sym__dict_field_initializer] = {
    .visible = false,
    .named = true,
  },
  [sym_enum_declaration] = {
    .visible = true,
    .named = true,
  },
  [sym__inherits] = {
    .visible = false,
    .named = true,
  },
  [sym_dictionary_declaration] = {
    .visible = true,
    .named = true,
  },
  [sym_dictionary_decl_list] = {
    .visible = true,
    .named = true,
  },
  [sym_dictionary_member] = {
    .visible = true,
    .named = true,
  },
  [sym_namespace_declaration] = {
    .visible = true,
    .named = true,
  },
  [sym__namespace_member] = {
    .visible = false,
    .named = true,
  },
  [sym_typedef_declaration] = {
    .visible = true,
    .named = true,
  },
  [aux_sym_source_file_repeat1] = {
    .visible = false,
    .named = false,
  },
  [aux_sym_type_parameter_list_repeat1] = {
    .visible = false,
    .named = false,
  },
  [aux_sym_attributes_repeat1] = {
    .visible = false,
    .named = false,
  },
  [aux_sym_attribute_value_set_repeat1] = {
    .visible = false,
    .named = false,
  },
  [aux_sym_iterface_decl_list_repeat1] = {
    .visible = false,
    .named = false,
  },
  [aux_sym_operation_declaration_repeat1] = {
    .visible = false,
    .named = false,
  },
  [aux_sym_enum_declaration_repeat1] = {
    .visible = false,
    .named = false,
  },
  [aux_sym_dictionary_declaration_repeat1] = {
    .visible = false,
    .named = false,
  },
  [aux_sym_dictionary_decl_list_repeat1] = {
    .visible = false,
    .named = false,
  },
  [aux_sym_namespace_declaration_repeat1] = {
    .visible = false,
    .named = false,
  },
};

enum ts_field_identifiers {
  field_attribute = 1,
  field_attributes = 2,
  field_decls = 3,
  field_id = 4,
  field_identifier = 5,
  field_implement = 6,
  field_include = 7,
  field_inherit = 8,
  field_is_mixin = 9,
  field_is_readonly = 10,
  field_members = 11,
  field_name = 12,
  field_nullable = 13,
  field_optional = 14,
  field_parameters = 15,
  field_readonly = 16,
  field_required = 17,
  field_return_type = 18,
  field_setlike = 19,
  field_type = 20,
  field_types = 21,
  field_value = 22,
  field_values = 23,
};

static const char * const ts_field_names[] = {
  [0] = NULL,
  [field_attribute] = "attribute",
  [field_attributes] = "attributes",
  [field_decls] = "decls",
  [field_id] = "id",
  [field_identifier] = "identifier",
  [field_implement] = "implement",
  [field_include] = "include",
  [field_inherit] = "inherit",
  [field_is_mixin] = "is_mixin",
  [field_is_readonly] = "is_readonly",
  [field_members] = "members",
  [field_name] = "name",
  [field_nullable] = "nullable",
  [field_optional] = "optional",
  [field_parameters] = "parameters",
  [field_readonly] = "readonly",
  [field_required] = "required",
  [field_return_type] = "return_type",
  [field_setlike] = "setlike",
  [field_type] = "type",
  [field_types] = "types",
  [field_value] = "value",
  [field_values] = "values",
};

static const TSFieldMapSlice ts_field_map_slices[PRODUCTION_ID_COUNT] = {
  [1] = {.index = 0, .length = 1},
  [2] = {.index = 1, .length = 2},
  [3] = {.index = 3, .length = 1},
  [4] = {.index = 4, .length = 1},
  [5] = {.index = 5, .length = 2},
  [6] = {.index = 7, .length = 2},
  [7] = {.index = 9, .length = 2},
  [8] = {.index = 11, .length = 2},
  [9] = {.index = 13, .length = 2},
  [10] = {.index = 15, .length = 1},
  [11] = {.index = 16, .length = 2},
  [12] = {.index = 18, .length = 1},
  [13] = {.index = 19, .length = 4},
  [14] = {.index = 23, .length = 2},
  [15] = {.index = 25, .length = 2},
  [16] = {.index = 27, .length = 3},
  [17] = {.index = 30, .length = 2},
  [18] = {.index = 32, .length = 3},
  [19] = {.index = 35, .length = 2},
  [20] = {.index = 37, .length = 3},
  [21] = {.index = 40, .length = 6},
  [22] = {.index = 46, .length = 3},
  [23] = {.index = 49, .length = 2},
  [24] = {.index = 51, .length = 3},
  [25] = {.index = 54, .length = 2},
  [26] = {.index = 56, .length = 2},
  [27] = {.index = 58, .length = 5},
  [28] = {.index = 63, .length = 3},
  [29] = {.index = 66, .length = 2},
  [30] = {.index = 68, .length = 3},
  [31] = {.index = 71, .length = 4},
  [32] = {.index = 75, .length = 3},
  [33] = {.index = 78, .length = 3},
  [34] = {.index = 81, .length = 1},
  [35] = {.index = 82, .length = 3},
  [36] = {.index = 85, .length = 4},
  [37] = {.index = 89, .length = 3},
  [38] = {.index = 92, .length = 4},
  [39] = {.index = 96, .length = 6},
  [40] = {.index = 102, .length = 1},
  [41] = {.index = 103, .length = 1},
  [42] = {.index = 104, .length = 2},
  [43] = {.index = 106, .length = 1},
  [44] = {.index = 107, .length = 4},
  [45] = {.index = 111, .length = 4},
  [46] = {.index = 115, .length = 4},
  [47] = {.index = 119, .length = 5},
  [48] = {.index = 124, .length = 4},
  [49] = {.index = 128, .length = 2},
  [50] = {.index = 130, .length = 3},
  [51] = {.index = 133, .length = 3},
  [52] = {.index = 136, .length = 2},
  [53] = {.index = 138, .length = 3},
  [54] = {.index = 141, .length = 5},
  [55] = {.index = 146, .length = 4},
  [56] = {.index = 150, .length = 4},
};

static const TSFieldMapEntry ts_field_map_entries[] = {
  [0] =
    {field_identifier, 0},
  [1] =
    {field_identifier, 0, .inherited = true},
    {field_value, 0, .inherited = true},
  [3] =
    {field_type, 0},
  [4] =
    {field_name, 1},
  [5] =
    {field_nullable, 1},
    {field_type, 0},
  [7] =
    {field_name, 0},
    {field_types, 1},
  [9] =
    {field_attribute, 0},
    {field_type, 1},
  [11] =
    {field_id, 0},
    {field_include, 2},
  [13] =
    {field_identifier, 0},
    {field_value, 2},
  [15] =
    {field_implement, 1},
  [16] =
    {field_attributes, 0, .inherited = true},
    {field_is_readonly, 0, .inherited = true},
  [18] =
    {field_inherit, 1},
  [19] =
    {field_name, 0, .inherited = true},
    {field_required, 0, .inherited = true},
    {field_type, 0, .inherited = true},
    {field_value, 0, .inherited = true},
  [23] =
    {field_inherit, 2, .inherited = true},
    {field_name, 1},
  [25] =
    {field_decls, 2},
    {field_name, 1},
  [27] =
    {field_name, 0, .inherited = true},
    {field_type, 0, .inherited = true},
    {field_value, 0, .inherited = true},
  [30] =
    {field_name, 2},
    {field_type, 1},
  [32] =
    {field_attribute, 0},
    {field_nullable, 2},
    {field_type, 1},
  [35] =
    {field_decls, 3},
    {field_name, 1},
  [37] =
    {field_decls, 3},
    {field_inherit, 2, .inherited = true},
    {field_name, 1},
  [40] =
    {field_name, 0, .inherited = true},
    {field_name, 1, .inherited = true},
    {field_type, 0, .inherited = true},
    {field_type, 1, .inherited = true},
    {field_value, 0, .inherited = true},
    {field_value, 1, .inherited = true},
  [46] =
    {field_decls, 4},
    {field_name, 1},
    {field_setlike, 3},
  [49] =
    {field_decls, 4},
    {field_name, 1},
  [51] =
    {field_decls, 4},
    {field_is_mixin, 1},
    {field_name, 2},
  [54] =
    {field_name, 1},
    {field_values, 3},
  [56] =
    {field_name, 1},
    {field_type, 0},
  [58] =
    {field_members, 3},
    {field_name, 1},
    {field_name, 3, .inherited = true},
    {field_type, 3, .inherited = true},
    {field_value, 3, .inherited = true},
  [63] =
    {field_attributes, 0},
    {field_decls, 4},
    {field_name, 2},
  [66] =
    {field_attributes, 0},
    {field_name, 2},
  [68] =
    {field_decls, 5},
    {field_name, 1},
    {field_setlike, 4},
  [71] =
    {field_decls, 5},
    {field_is_mixin, 1},
    {field_name, 2},
    {field_setlike, 4},
  [75] =
    {field_decls, 5},
    {field_is_mixin, 1},
    {field_name, 2},
  [78] =
    {field_name, 2},
    {field_required, 0},
    {field_type, 1},
  [81] =
    {field_value, 1},
  [82] =
    {field_name, 1},
    {field_type, 0},
    {field_value, 2, .inherited = true},
  [85] =
    {field_attributes, 0},
    {field_decls, 5},
    {field_name, 2},
    {field_setlike, 4},
  [89] =
    {field_attributes, 0},
    {field_decls, 5},
    {field_name, 2},
  [92] =
    {field_attributes, 0},
    {field_decls, 5},
    {field_is_mixin, 2},
    {field_name, 3},
  [96] =
    {field_attributes, 0},
    {field_members, 4},
    {field_name, 2},
    {field_name, 4, .inherited = true},
    {field_type, 4, .inherited = true},
    {field_value, 4, .inherited = true},
  [102] =
    {field_is_readonly, 0},
  [103] =
    {field_type, 2},
  [104] =
    {field_name, 1},
    {field_return_type, 0},
  [106] =
    {field_attributes, 0},
  [107] =
    {field_decls, 6},
    {field_is_mixin, 1},
    {field_name, 2},
    {field_setlike, 5},
  [111] =
    {field_name, 2},
    {field_required, 0},
    {field_type, 1},
    {field_value, 3, .inherited = true},
  [115] =
    {field_attributes, 0},
    {field_decls, 6},
    {field_name, 2},
    {field_setlike, 5},
  [119] =
    {field_attributes, 0},
    {field_decls, 6},
    {field_is_mixin, 2},
    {field_name, 3},
    {field_setlike, 5},
  [124] =
    {field_attributes, 0},
    {field_decls, 6},
    {field_is_mixin, 2},
    {field_name, 3},
  [128] =
    {field_readonly, 0},
    {field_type, 3},
  [130] =
    {field_name, 2},
    {field_optional, 0},
    {field_type, 1},
  [133] =
    {field_name, 1},
    {field_parameters, 3},
    {field_return_type, 0},
  [136] =
    {field_attributes, 0},
    {field_is_readonly, 1},
  [138] =
    {field_name, 2},
    {field_type, 1},
    {field_value, 4},
  [141] =
    {field_attributes, 0},
    {field_decls, 7},
    {field_is_mixin, 2},
    {field_name, 3},
    {field_setlike, 6},
  [146] =
    {field_name, 2},
    {field_optional, 0},
    {field_type, 1},
    {field_value, 3, .inherited = true},
  [150] =
    {field_name, 1},
    {field_parameters, 3},
    {field_parameters, 4},
    {field_return_type, 0},
};

static const TSSymbol ts_alias_sequences[PRODUCTION_ID_COUNT][MAX_ALIAS_SEQUENCE_LENGTH] = {
  [0] = {0},
};

static const uint16_t ts_non_terminal_alias_map[] = {
  0,
};

static const TSStateId ts_primary_state_ids[STATE_COUNT] = {
  [0] = 0,
  [1] = 1,
  [2] = 2,
  [3] = 3,
  [4] = 4,
  [5] = 5,
  [6] = 6,
  [7] = 7,
  [8] = 8,
  [9] = 9,
  [10] = 10,
  [11] = 11,
  [12] = 12,
  [13] = 13,
  [14] = 14,
  [15] = 15,
  [16] = 16,
  [17] = 17,
  [18] = 18,
  [19] = 19,
  [20] = 20,
  [21] = 21,
  [22] = 22,
  [23] = 23,
  [24] = 24,
  [25] = 25,
  [26] = 26,
  [27] = 27,
  [28] = 28,
  [29] = 29,
  [30] = 30,
  [31] = 31,
  [32] = 32,
  [33] = 33,
  [34] = 34,
  [35] = 35,
  [36] = 36,
  [37] = 37,
  [38] = 38,
  [39] = 39,
  [40] = 40,
  [41] = 41,
  [42] = 42,
  [43] = 43,
  [44] = 44,
  [45] = 45,
  [46] = 46,
  [47] = 47,
  [48] = 48,
  [49] = 49,
  [50] = 50,
  [51] = 51,
  [52] = 52,
  [53] = 53,
  [54] = 54,
  [55] = 55,
  [56] = 56,
  [57] = 57,
  [58] = 58,
  [59] = 59,
  [60] = 57,
  [61] = 58,
  [62] = 56,
  [63] = 63,
  [64] = 64,
  [65] = 65,
  [66] = 66,
  [67] = 67,
  [68] = 68,
  [69] = 69,
  [70] = 70,
  [71] = 71,
  [72] = 72,
  [73] = 73,
  [74] = 74,
  [75] = 75,
  [76] = 76,
  [77] = 77,
  [78] = 78,
  [79] = 79,
  [80] = 80,
  [81] = 81,
  [82] = 82,
  [83] = 83,
  [84] = 84,
  [85] = 85,
  [86] = 86,
  [87] = 87,
  [88] = 88,
  [89] = 89,
  [90] = 90,
  [91] = 91,
  [92] = 92,
  [93] = 93,
  [94] = 94,
  [95] = 95,
  [96] = 96,
  [97] = 97,
  [98] = 98,
  [99] = 99,
  [100] = 100,
  [101] = 101,
  [102] = 102,
  [103] = 103,
  [104] = 104,
  [105] = 105,
  [106] = 106,
  [107] = 107,
  [108] = 108,
  [109] = 109,
  [110] = 110,
  [111] = 111,
  [112] = 112,
  [113] = 113,
  [114] = 114,
  [115] = 115,
  [116] = 116,
  [117] = 117,
  [118] = 118,
  [119] = 115,
  [120] = 115,
  [121] = 121,
  [122] = 122,
  [123] = 123,
  [124] = 124,
  [125] = 124,
  [126] = 126,
  [127] = 127,
  [128] = 128,
  [129] = 129,
  [130] = 124,
  [131] = 126,
  [132] = 132,
  [133] = 133,
  [134] = 134,
  [135] = 135,
  [136] = 136,
  [137] = 137,
  [138] = 126,
  [139] = 139,
  [140] = 140,
  [141] = 141,
  [142] = 142,
  [143] = 143,
  [144] = 144,
  [145] = 145,
  [146] = 146,
  [147] = 147,
  [148] = 148,
  [149] = 149,
  [150] = 150,
  [151] = 151,
  [152] = 152,
  [153] = 58,
  [154] = 154,
  [155] = 155,
  [156] = 156,
  [157] = 157,
  [158] = 158,
  [159] = 159,
  [160] = 160,
  [161] = 161,
  [162] = 162,
  [163] = 57,
  [164] = 164,
  [165] = 165,
  [166] = 166,
  [167] = 167,
  [168] = 56,
  [169] = 169,
  [170] = 170,
  [171] = 171,
  [172] = 172,
  [173] = 173,
  [174] = 174,
  [175] = 175,
  [176] = 176,
  [177] = 177,
  [178] = 178,
  [179] = 179,
  [180] = 180,
  [181] = 181,
  [182] = 182,
  [183] = 183,
  [184] = 184,
  [185] = 185,
  [186] = 186,
  [187] = 187,
  [188] = 188,
  [189] = 189,
  [190] = 190,
  [191] = 191,
  [192] = 192,
  [193] = 193,
  [194] = 194,
  [195] = 195,
  [196] = 196,
  [197] = 197,
  [198] = 198,
  [199] = 199,
  [200] = 200,
  [201] = 201,
  [202] = 202,
  [203] = 203,
  [204] = 204,
  [205] = 205,
  [206] = 206,
  [207] = 207,
  [208] = 208,
  [209] = 209,
  [210] = 210,
  [211] = 211,
  [212] = 212,
  [213] = 213,
  [214] = 214,
  [215] = 215,
  [216] = 216,
  [217] = 217,
  [218] = 218,
  [219] = 219,
  [220] = 220,
  [221] = 221,
  [222] = 222,
  [223] = 223,
  [224] = 224,
  [225] = 225,
  [226] = 226,
  [227] = 227,
  [228] = 228,
  [229] = 229,
  [230] = 230,
  [231] = 231,
  [232] = 232,
  [233] = 233,
  [234] = 234,
  [235] = 235,
  [236] = 236,
  [237] = 237,
  [238] = 238,
  [239] = 239,
  [240] = 240,
  [241] = 241,
  [242] = 242,
  [243] = 243,
  [244] = 244,
  [245] = 245,
  [246] = 246,
  [247] = 247,
  [248] = 248,
  [249] = 249,
  [250] = 250,
  [251] = 251,
  [252] = 252,
  [253] = 253,
  [254] = 254,
  [255] = 255,
  [256] = 256,
  [257] = 257,
  [258] = 258,
};

static bool ts_lex(TSLexer *lexer, TSStateId state) {
  START_LEXER();
  eof = lexer->eof(lexer);
  switch (state) {
    case 0:
      if (eof) ADVANCE(172);
      ADVANCE_MAP(
        '"', 3,
        '(', 346,
        ')', 347,
        ',', 325,
        '/', 10,
        '0', 336,
        ':', 334,
        ';', 329,
        '<', 324,
        '=', 345,
        '>', 326,
        '?', 327,
        'D', 13,
        'U', 14,
        '[', 343,
        ']', 344,
        'a', 151,
        'b', 116,
        'c', 120,
        'd', 73,
        'e', 105,
        'f', 20,
        'i', 99,
        'l', 121,
        'm', 74,
        'n', 21,
        'o', 129,
        'r', 42,
        's', 60,
        't', 135,
        'u', 100,
        '{', 352,
        '}', 353,
      );
      if (('\t' <= lookahead && lookahead <= '\r') ||
          lookahead == ' ') SKIP(170);
      if (('1' <= lookahead && lookahead <= '9')) ADVANCE(337);
      END_STATE();
    case 1:
      if (lookahead == ' ') ADVANCE(94);
      END_STATE();
    case 2:
      if (lookahead == '"') ADVANCE(3);
      if (lookahead == '0') ADVANCE(336);
      if (lookahead == '[') ADVANCE(18);
      if (lookahead == 'f') ADVANCE(19);
      if (lookahead == 't') ADVANCE(134);
      if (lookahead == '{') ADVANCE(168);
      if (('\t' <= lookahead && lookahead <= '\r') ||
          lookahead == ' ') SKIP(2);
      if (('1' <= lookahead && lookahead <= '9')) ADVANCE(337);
      END_STATE();
    case 3:
      if (lookahead == '"') ADVANCE(335);
      if (lookahead != 0) ADVANCE(3);
      END_STATE();
    case 4:
      if (lookahead == '(') ADVANCE(346);
      if (lookahead == ')') ADVANCE(347);
      if (lookahead == ',') ADVANCE(325);
      if (lookahead == '<') ADVANCE(324);
      if (lookahead == '>') ADVANCE(326);
      if (lookahead == '?') ADVANCE(327);
      if (lookahead == ']') ADVANCE(344);
      if (('\t' <= lookahead && lookahead <= '\r') ||
          lookahead == ' ') SKIP(5);
      if (('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 5:
      if (lookahead == '(') ADVANCE(346);
      if (lookahead == ')') ADVANCE(347);
      if (lookahead == ',') ADVANCE(325);
      if (lookahead == '<') ADVANCE(324);
      if (lookahead == '>') ADVANCE(326);
      if (lookahead == ']') ADVANCE(344);
      if (('\t' <= lookahead && lookahead <= '\r') ||
          lookahead == ' ') SKIP(5);
      if (('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 6:
      ADVANCE_MAP(
        ')', 347,
        'D', 175,
        'U', 176,
        '[', 343,
        'b', 262,
        'd', 259,
        'f', 240,
        'l', 264,
        'o', 270,
        's', 224,
        'u', 248,
      );
      if (('\t' <= lookahead && lookahead <= '\r') ||
          lookahead == ' ') SKIP(6);
      if (('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 7:
      ADVANCE_MAP(
        '/', 10,
        'D', 175,
        'U', 176,
        '[', 343,
        'a', 286,
        'b', 262,
        'd', 259,
        'f', 240,
        'l', 264,
        'r', 212,
        's', 214,
        'u', 248,
        '}', 353,
      );
      if (('\t' <= lookahead && lookahead <= '\r') ||
          lookahead == ' ') SKIP(7);
      if (('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('c' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 8:
      ADVANCE_MAP(
        '/', 10,
        'D', 175,
        'U', 176,
        '[', 343,
        'a', 286,
        'b', 262,
        'd', 259,
        'f', 240,
        'l', 264,
        'r', 212,
        's', 224,
        'u', 248,
        '}', 353,
      );
      if (('\t' <= lookahead && lookahead <= '\r') ||
          lookahead == ' ') SKIP(8);
      if (('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('c' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 9:
      ADVANCE_MAP(
        '/', 10,
        'D', 175,
        'U', 176,
        '[', 343,
        'b', 262,
        'd', 259,
        'f', 240,
        'l', 264,
        'r', 208,
        's', 224,
        'u', 248,
        '}', 353,
      );
      if (('\t' <= lookahead && lookahead <= '\r') ||
          lookahead == ' ') SKIP(9);
      if (('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 10:
      if (lookahead == '/') ADVANCE(301);
      END_STATE();
    case 11:
      ADVANCE_MAP(
        'D', 175,
        'U', 176,
        '[', 343,
        'b', 262,
        'd', 259,
        'f', 240,
        'l', 264,
        's', 224,
        'u', 248,
      );
      if (('\t' <= lookahead && lookahead <= '\r') ||
          lookahead == ' ') SKIP(11);
      if (('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 12:
      if (lookahead == 'M') ADVANCE(15);
      END_STATE();
    case 13:
      if (lookahead == 'O') ADVANCE(12);
      END_STATE();
    case 14:
      if (lookahead == 'S') ADVANCE(17);
      END_STATE();
    case 15:
      if (lookahead == 'S') ADVANCE(156);
      END_STATE();
    case 16:
      if (lookahead == 'S') ADVANCE(158);
      END_STATE();
    case 17:
      if (lookahead == 'V') ADVANCE(16);
      END_STATE();
    case 18:
      if (lookahead == ']') ADVANCE(342);
      END_STATE();
    case 19:
      if (lookahead == 'a') ADVANCE(88);
      END_STATE();
    case 20:
      if (lookahead == 'a') ADVANCE(88);
      if (lookahead == 'l') ADVANCE(117);
      END_STATE();
    case 21:
      if (lookahead == 'a') ADVANCE(97);
      END_STATE();
    case 22:
      if (lookahead == 'a') ADVANCE(41);
      if (lookahead == 'q') ADVANCE(162);
      END_STATE();
    case 23:
      if (lookahead == 'a') ADVANCE(32);
      END_STATE();
    case 24:
      if (lookahead == 'a') ADVANCE(133);
      END_STATE();
    case 25:
      if (lookahead == 'a') ADVANCE(148);
      END_STATE();
    case 26:
      if (lookahead == 'a') ADVANCE(87);
      END_STATE();
    case 27:
      if (lookahead == 'a') ADVANCE(104);
      END_STATE();
    case 28:
      if (lookahead == 'a') ADVANCE(33);
      END_STATE();
    case 29:
      if (lookahead == 'b') ADVANCE(163);
      END_STATE();
    case 30:
      if (lookahead == 'b') ADVANCE(92);
      END_STATE();
    case 31:
      if (lookahead == 'c') ADVANCE(89);
      if (lookahead == 't') ADVANCE(54);
      END_STATE();
    case 32:
      if (lookahead == 'c') ADVANCE(50);
      END_STATE();
    case 33:
      if (lookahead == 'c') ADVANCE(51);
      END_STATE();
    case 34:
      if (lookahead == 'c') ADVANCE(157);
      END_STATE();
    case 35:
      if (lookahead == 'd') ADVANCE(358);
      END_STATE();
    case 36:
      if (lookahead == 'd') ADVANCE(1);
      END_STATE();
    case 37:
      if (lookahead == 'd') ADVANCE(302);
      END_STATE();
    case 38:
      if (lookahead == 'd') ADVANCE(45);
      if (lookahead == 's') ADVANCE(77);
      END_STATE();
    case 39:
      if (lookahead == 'd') ADVANCE(57);
      END_STATE();
    case 40:
      if (lookahead == 'd') ADVANCE(58);
      END_STATE();
    case 41:
      if (lookahead == 'd') ADVANCE(123);
      END_STATE();
    case 42:
      if (lookahead == 'e') ADVANCE(22);
      END_STATE();
    case 43:
      if (lookahead == 'e') ADVANCE(306);
      END_STATE();
    case 44:
      if (lookahead == 'e') ADVANCE(340);
      END_STATE();
    case 45:
      if (lookahead == 'e') ADVANCE(64);
      END_STATE();
    case 46:
      if (lookahead == 'e') ADVANCE(341);
      END_STATE();
    case 47:
      if (lookahead == 'e') ADVANCE(315);
      END_STATE();
    case 48:
      if (lookahead == 'e') ADVANCE(332);
      END_STATE();
    case 49:
      if (lookahead == 'e') ADVANCE(356);
      END_STATE();
    case 50:
      if (lookahead == 'e') ADVANCE(348);
      END_STATE();
    case 51:
      if (lookahead == 'e') ADVANCE(364);
      END_STATE();
    case 52:
      if (lookahead == 'e') ADVANCE(39);
      END_STATE();
    case 53:
      if (lookahead == 'e') ADVANCE(27);
      END_STATE();
    case 54:
      if (lookahead == 'e') ADVANCE(132);
      END_STATE();
    case 55:
      if (lookahead == 'e') ADVANCE(143);
      END_STATE();
    case 56:
      if (lookahead == 'e') ADVANCE(35);
      END_STATE();
    case 57:
      if (lookahead == 'e') ADVANCE(62);
      END_STATE();
    case 58:
      if (lookahead == 'e') ADVANCE(142);
      END_STATE();
    case 59:
      if (lookahead == 'e') ADVANCE(36);
      END_STATE();
    case 60:
      if (lookahead == 'e') ADVANCE(154);
      if (lookahead == 'h') ADVANCE(119);
      END_STATE();
    case 61:
      if (lookahead == 'e') ADVANCE(37);
      END_STATE();
    case 62:
      if (lookahead == 'f') ADVANCE(367);
      END_STATE();
    case 63:
      if (lookahead == 'f') ADVANCE(23);
      END_STATE();
    case 64:
      if (lookahead == 'f') ADVANCE(82);
      END_STATE();
    case 65:
      if (lookahead == 'g') ADVANCE(311);
      END_STATE();
    case 66:
      if (lookahead == 'g') ADVANCE(320);
      END_STATE();
    case 67:
      if (lookahead == 'g') ADVANCE(322);
      END_STATE();
    case 68:
      if (lookahead == 'g') ADVANCE(317);
      END_STATE();
    case 69:
      if (lookahead == 'g') ADVANCE(318);
      END_STATE();
    case 70:
      if (lookahead == 'g') ADVANCE(319);
      END_STATE();
    case 71:
      if (lookahead == 'g') ADVANCE(114);
      END_STATE();
    case 72:
      if (lookahead == 'h') ADVANCE(128);
      END_STATE();
    case 73:
      if (lookahead == 'i') ADVANCE(34);
      if (lookahead == 'o') ADVANCE(159);
      END_STATE();
    case 74:
      if (lookahead == 'i') ADVANCE(165);
      END_STATE();
    case 75:
      if (lookahead == 'i') ADVANCE(85);
      END_STATE();
    case 76:
      if (lookahead == 'i') ADVANCE(29);
      END_STATE();
    case 77:
      if (lookahead == 'i') ADVANCE(71);
      END_STATE();
    case 78:
      if (lookahead == 'i') ADVANCE(139);
      END_STATE();
    case 79:
      if (lookahead == 'i') ADVANCE(103);
      END_STATE();
    case 80:
      if (lookahead == 'i') ADVANCE(106);
      END_STATE();
    case 81:
      if (lookahead == 'i') ADVANCE(107);
      END_STATE();
    case 82:
      if (lookahead == 'i') ADVANCE(115);
      END_STATE();
    case 83:
      if (lookahead == 'i') ADVANCE(122);
      END_STATE();
    case 84:
      if (lookahead == 'i') ADVANCE(124);
      END_STATE();
    case 85:
      if (lookahead == 'k') ADVANCE(48);
      END_STATE();
    case 86:
      if (lookahead == 'l') ADVANCE(166);
      END_STATE();
    case 87:
      if (lookahead == 'l') ADVANCE(354);
      END_STATE();
    case 88:
      if (lookahead == 'l') ADVANCE(145);
      END_STATE();
    case 89:
      if (lookahead == 'l') ADVANCE(164);
      END_STATE();
    case 90:
      if (lookahead == 'l') ADVANCE(75);
      END_STATE();
    case 91:
      if (lookahead == 'l') ADVANCE(53);
      END_STATE();
    case 92:
      if (lookahead == 'l') ADVANCE(47);
      END_STATE();
    case 93:
      if (lookahead == 'l') ADVANCE(125);
      END_STATE();
    case 94:
      if (lookahead == 'l') ADVANCE(126);
      if (lookahead == 's') ADVANCE(72);
      END_STATE();
    case 95:
      if (lookahead == 'l') ADVANCE(127);
      END_STATE();
    case 96:
      if (lookahead == 'm') ADVANCE(360);
      END_STATE();
    case 97:
      if (lookahead == 'm') ADVANCE(55);
      END_STATE();
    case 98:
      if (lookahead == 'm') ADVANCE(228);
      if (('\t' <= lookahead && lookahead <= '\r') ||
          lookahead == ' ') SKIP(98);
      if (('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 99:
      if (lookahead == 'n') ADVANCE(31);
      END_STATE();
    case 100:
      if (lookahead == 'n') ADVANCE(38);
      END_STATE();
    case 101:
      if (lookahead == 'n') ADVANCE(144);
      END_STATE();
    case 102:
      if (lookahead == 'n') ADVANCE(65);
      END_STATE();
    case 103:
      if (lookahead == 'n') ADVANCE(350);
      END_STATE();
    case 104:
      if (lookahead == 'n') ADVANCE(304);
      END_STATE();
    case 105:
      if (lookahead == 'n') ADVANCE(160);
      END_STATE();
    case 106:
      if (lookahead == 'n') ADVANCE(66);
      END_STATE();
    case 107:
      if (lookahead == 'n') ADVANCE(67);
      END_STATE();
    case 108:
      if (lookahead == 'n') ADVANCE(26);
      END_STATE();
    case 109:
      if (lookahead == 'n') ADVANCE(68);
      END_STATE();
    case 110:
      if (lookahead == 'n') ADVANCE(24);
      END_STATE();
    case 111:
      if (lookahead == 'n') ADVANCE(86);
      END_STATE();
    case 112:
      if (lookahead == 'n') ADVANCE(69);
      END_STATE();
    case 113:
      if (lookahead == 'n') ADVANCE(70);
      END_STATE();
    case 114:
      if (lookahead == 'n') ADVANCE(59);
      END_STATE();
    case 115:
      if (lookahead == 'n') ADVANCE(61);
      END_STATE();
    case 116:
      if (lookahead == 'o') ADVANCE(118);
      if (lookahead == 'y') ADVANCE(152);
      END_STATE();
    case 117:
      if (lookahead == 'o') ADVANCE(25);
      END_STATE();
    case 118:
      if (lookahead == 'o') ADVANCE(91);
      END_STATE();
    case 119:
      if (lookahead == 'o') ADVANCE(137);
      END_STATE();
    case 120:
      if (lookahead == 'o') ADVANCE(101);
      END_STATE();
    case 121:
      if (lookahead == 'o') ADVANCE(102);
      END_STATE();
    case 122:
      if (lookahead == 'o') ADVANCE(108);
      END_STATE();
    case 123:
      if (lookahead == 'o') ADVANCE(111);
      END_STATE();
    case 124:
      if (lookahead == 'o') ADVANCE(110);
      END_STATE();
    case 125:
      if (lookahead == 'o') ADVANCE(109);
      END_STATE();
    case 126:
      if (lookahead == 'o') ADVANCE(112);
      END_STATE();
    case 127:
      if (lookahead == 'o') ADVANCE(113);
      END_STATE();
    case 128:
      if (lookahead == 'o') ADVANCE(138);
      END_STATE();
    case 129:
      if (lookahead == 'p') ADVANCE(153);
      END_STATE();
    case 130:
      if (lookahead == 'p') ADVANCE(52);
      END_STATE();
    case 131:
      if (lookahead == 'p') ADVANCE(28);
      END_STATE();
    case 132:
      if (lookahead == 'r') ADVANCE(63);
      END_STATE();
    case 133:
      if (lookahead == 'r') ADVANCE(167);
      END_STATE();
    case 134:
      if (lookahead == 'r') ADVANCE(161);
      END_STATE();
    case 135:
      if (lookahead == 'r') ADVANCE(161);
      if (lookahead == 'y') ADVANCE(130);
      END_STATE();
    case 136:
      if (lookahead == 'r') ADVANCE(76);
      END_STATE();
    case 137:
      if (lookahead == 'r') ADVANCE(149);
      END_STATE();
    case 138:
      if (lookahead == 'r') ADVANCE(150);
      END_STATE();
    case 139:
      if (lookahead == 'r') ADVANCE(56);
      END_STATE();
    case 140:
      if (lookahead == 'r') ADVANCE(80);
      END_STATE();
    case 141:
      if (lookahead == 'r') ADVANCE(81);
      END_STATE();
    case 142:
      if (lookahead == 's') ADVANCE(328);
      END_STATE();
    case 143:
      if (lookahead == 's') ADVANCE(131);
      END_STATE();
    case 144:
      if (lookahead == 's') ADVANCE(147);
      END_STATE();
    case 145:
      if (lookahead == 's') ADVANCE(46);
      END_STATE();
    case 146:
      if (lookahead == 't') ADVANCE(136);
      END_STATE();
    case 147:
      if (lookahead == 't') ADVANCE(366);
      END_STATE();
    case 148:
      if (lookahead == 't') ADVANCE(313);
      END_STATE();
    case 149:
      if (lookahead == 't') ADVANCE(308);
      END_STATE();
    case 150:
      if (lookahead == 't') ADVANCE(310);
      END_STATE();
    case 151:
      if (lookahead == 't') ADVANCE(146);
      END_STATE();
    case 152:
      if (lookahead == 't') ADVANCE(43);
      END_STATE();
    case 153:
      if (lookahead == 't') ADVANCE(83);
      END_STATE();
    case 154:
      if (lookahead == 't') ADVANCE(90);
      END_STATE();
    case 155:
      if (lookahead == 't') ADVANCE(49);
      END_STATE();
    case 156:
      if (lookahead == 't') ADVANCE(140);
      END_STATE();
    case 157:
      if (lookahead == 't') ADVANCE(84);
      END_STATE();
    case 158:
      if (lookahead == 't') ADVANCE(141);
      END_STATE();
    case 159:
      if (lookahead == 'u') ADVANCE(30);
      END_STATE();
    case 160:
      if (lookahead == 'u') ADVANCE(96);
      END_STATE();
    case 161:
      if (lookahead == 'u') ADVANCE(44);
      END_STATE();
    case 162:
      if (lookahead == 'u') ADVANCE(78);
      END_STATE();
    case 163:
      if (lookahead == 'u') ADVANCE(155);
      END_STATE();
    case 164:
      if (lookahead == 'u') ADVANCE(40);
      END_STATE();
    case 165:
      if (lookahead == 'x') ADVANCE(79);
      END_STATE();
    case 166:
      if (lookahead == 'y') ADVANCE(330);
      END_STATE();
    case 167:
      if (lookahead == 'y') ADVANCE(362);
      END_STATE();
    case 168:
      if (lookahead == '}') ADVANCE(339);
      END_STATE();
    case 169:
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'F') ||
          ('a' <= lookahead && lookahead <= 'f')) ADVANCE(338);
      END_STATE();
    case 170:
      if (eof) ADVANCE(172);
      ADVANCE_MAP(
        '"', 3,
        '(', 346,
        ')', 347,
        ',', 325,
        '/', 10,
        '0', 336,
        ':', 334,
        ';', 329,
        '<', 324,
        '=', 345,
        '>', 326,
        'D', 13,
        'U', 14,
        '[', 343,
        ']', 344,
        'a', 151,
        'b', 116,
        'c', 120,
        'd', 73,
        'e', 105,
        'f', 20,
        'i', 99,
        'l', 121,
        'm', 74,
        'n', 21,
        'o', 129,
        'r', 42,
        's', 60,
        't', 135,
        'u', 100,
        '{', 352,
        '}', 353,
      );
      if (('\t' <= lookahead && lookahead <= '\r') ||
          lookahead == ' ') SKIP(170);
      if (('1' <= lookahead && lookahead <= '9')) ADVANCE(337);
      END_STATE();
    case 171:
      if (eof) ADVANCE(172);
      if (lookahead == '/') ADVANCE(10);
      if (lookahead == '[') ADVANCE(343);
      if (lookahead == 'd') ADVANCE(225);
      if (lookahead == 'e') ADVANCE(246);
      if (lookahead == 'i') ADVANCE(247);
      if (lookahead == 'n') ADVANCE(180);
      if (lookahead == 't') ADVANCE(297);
      if (('\t' <= lookahead && lookahead <= '\r') ||
          lookahead == ' ') SKIP(171);
      if (('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 172:
      ACCEPT_TOKEN(ts_builtin_sym_end);
      END_STATE();
    case 173:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == ' ') ADVANCE(94);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 174:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'M') ADVANCE(177);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 175:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'O') ADVANCE(174);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 176:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'S') ADVANCE(179);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 177:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'S') ADVANCE(289);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 178:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'S') ADVANCE(291);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 179:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'V') ADVANCE(178);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 180:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'a') ADVANCE(245);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('b' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 181:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'a') ADVANCE(191);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('b' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 182:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'a') ADVANCE(273);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('b' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 183:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'a') ADVANCE(198);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('b' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 184:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'a') ADVANCE(238);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('b' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 185:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'a') ADVANCE(281);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('b' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 186:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'a') ADVANCE(250);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('b' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 187:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'a') ADVANCE(192);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('b' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 188:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'b') ADVANCE(295);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 189:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'b') ADVANCE(243);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 190:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'c') ADVANCE(283);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 191:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'c') ADVANCE(202);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 192:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'c') ADVANCE(203);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 193:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'd') ADVANCE(173);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 194:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'd') ADVANCE(303);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 195:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'd') ADVANCE(359);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 196:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'd') ADVANCE(209);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 197:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'd') ADVANCE(211);
      if (lookahead == 's') ADVANCE(230);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 198:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'd') ADVANCE(266);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 199:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'e') ADVANCE(272);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 200:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'e') ADVANCE(279);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 201:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'e') ADVANCE(196);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 202:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'e') ADVANCE(349);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 203:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'e') ADVANCE(365);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 204:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'e') ADVANCE(307);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 205:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'e') ADVANCE(316);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 206:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'e') ADVANCE(333);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 207:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'e') ADVANCE(357);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 208:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'e') ADVANCE(271);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 209:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'e') ADVANCE(217);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 210:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'e') ADVANCE(193);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 211:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'e') ADVANCE(219);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 212:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'e') ADVANCE(183);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 213:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'e') ADVANCE(194);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 214:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'e') ADVANCE(285);
      if (lookahead == 'h') ADVANCE(263);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 215:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'e') ADVANCE(195);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 216:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'e') ADVANCE(186);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 217:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'f') ADVANCE(368);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 218:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'f') ADVANCE(181);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 219:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'f') ADVANCE(235);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 220:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'g') ADVANCE(312);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 221:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'g') ADVANCE(321);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 222:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'g') ADVANCE(323);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 223:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'g') ADVANCE(257);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 224:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'h') ADVANCE(263);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 225:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'i') ADVANCE(190);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 226:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'i') ADVANCE(261);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 227:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'i') ADVANCE(237);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 228:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'i') ADVANCE(296);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 229:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'i') ADVANCE(188);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 230:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'i') ADVANCE(223);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 231:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'i') ADVANCE(276);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 232:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'i') ADVANCE(253);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 233:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'i') ADVANCE(255);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 234:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'i') ADVANCE(251);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 235:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'i') ADVANCE(258);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 236:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'i') ADVANCE(267);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 237:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'k') ADVANCE(206);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 238:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'l') ADVANCE(355);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 239:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'l') ADVANCE(299);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 240:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'l') ADVANCE(265);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 241:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'l') ADVANCE(227);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 242:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'l') ADVANCE(216);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 243:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'l') ADVANCE(205);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 244:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'm') ADVANCE(361);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 245:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'm') ADVANCE(200);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 246:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'n') ADVANCE(293);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 247:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'n') ADVANCE(280);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 248:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'n') ADVANCE(197);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 249:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'n') ADVANCE(220);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 250:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'n') ADVANCE(305);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 251:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'n') ADVANCE(351);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 252:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'n') ADVANCE(182);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 253:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'n') ADVANCE(221);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 254:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'n') ADVANCE(239);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 255:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'n') ADVANCE(222);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 256:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'n') ADVANCE(184);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 257:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'n') ADVANCE(210);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 258:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'n') ADVANCE(213);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 259:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'o') ADVANCE(292);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 260:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'o') ADVANCE(242);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 261:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'o') ADVANCE(252);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 262:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'o') ADVANCE(260);
      if (lookahead == 'y') ADVANCE(287);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 263:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'o') ADVANCE(275);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 264:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'o') ADVANCE(249);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 265:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'o') ADVANCE(185);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 266:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'o') ADVANCE(254);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 267:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'o') ADVANCE(256);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 268:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'p') ADVANCE(201);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 269:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'p') ADVANCE(187);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 270:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'p') ADVANCE(290);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 271:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'q') ADVANCE(294);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 272:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'r') ADVANCE(218);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 273:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'r') ADVANCE(298);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 274:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'r') ADVANCE(229);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 275:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'r') ADVANCE(282);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 276:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'r') ADVANCE(215);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 277:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'r') ADVANCE(232);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 278:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'r') ADVANCE(233);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 279:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 's') ADVANCE(269);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 280:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 't') ADVANCE(199);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 281:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 't') ADVANCE(314);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 282:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 't') ADVANCE(309);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 283:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 't') ADVANCE(226);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 284:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 't') ADVANCE(274);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 285:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 't') ADVANCE(241);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 286:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 't') ADVANCE(284);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 287:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 't') ADVANCE(204);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 288:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 't') ADVANCE(207);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 289:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 't') ADVANCE(277);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 290:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 't') ADVANCE(236);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 291:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 't') ADVANCE(278);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 292:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'u') ADVANCE(189);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 293:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'u') ADVANCE(244);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 294:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'u') ADVANCE(231);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 295:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'u') ADVANCE(288);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 296:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'x') ADVANCE(234);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 297:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'y') ADVANCE(268);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 298:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'y') ADVANCE(363);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 299:
      ACCEPT_TOKEN(sym_identifier);
      if (lookahead == 'y') ADVANCE(331);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 300:
      ACCEPT_TOKEN(sym_identifier);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 301:
      ACCEPT_TOKEN(sym_comment);
      if (lookahead != 0 &&
          lookahead != '\n') ADVANCE(301);
      END_STATE();
    case 302:
      ACCEPT_TOKEN(anon_sym_undefined);
      END_STATE();
    case 303:
      ACCEPT_TOKEN(anon_sym_undefined);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 304:
      ACCEPT_TOKEN(anon_sym_boolean);
      END_STATE();
    case 305:
      ACCEPT_TOKEN(anon_sym_boolean);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 306:
      ACCEPT_TOKEN(anon_sym_byte);
      END_STATE();
    case 307:
      ACCEPT_TOKEN(anon_sym_byte);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 308:
      ACCEPT_TOKEN(anon_sym_short);
      END_STATE();
    case 309:
      ACCEPT_TOKEN(anon_sym_short);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 310:
      ACCEPT_TOKEN(anon_sym_unsignedshort);
      END_STATE();
    case 311:
      ACCEPT_TOKEN(anon_sym_long);
      if (lookahead == ' ') ADVANCE(93);
      END_STATE();
    case 312:
      ACCEPT_TOKEN(anon_sym_long);
      if (lookahead == ' ') ADVANCE(93);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 313:
      ACCEPT_TOKEN(anon_sym_float);
      END_STATE();
    case 314:
      ACCEPT_TOKEN(anon_sym_float);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 315:
      ACCEPT_TOKEN(anon_sym_double);
      END_STATE();
    case 316:
      ACCEPT_TOKEN(anon_sym_double);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 317:
      ACCEPT_TOKEN(anon_sym_longlong);
      END_STATE();
    case 318:
      ACCEPT_TOKEN(anon_sym_unsignedlong);
      if (lookahead == ' ') ADVANCE(95);
      END_STATE();
    case 319:
      ACCEPT_TOKEN(anon_sym_unsignedlonglong);
      END_STATE();
    case 320:
      ACCEPT_TOKEN(anon_sym_DOMString);
      END_STATE();
    case 321:
      ACCEPT_TOKEN(anon_sym_DOMString);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 322:
      ACCEPT_TOKEN(anon_sym_USVString);
      END_STATE();
    case 323:
      ACCEPT_TOKEN(anon_sym_USVString);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 324:
      ACCEPT_TOKEN(anon_sym_LT);
      END_STATE();
    case 325:
      ACCEPT_TOKEN(anon_sym_COMMA);
      END_STATE();
    case 326:
      ACCEPT_TOKEN(anon_sym_GT);
      END_STATE();
    case 327:
      ACCEPT_TOKEN(anon_sym_QMARK);
      END_STATE();
    case 328:
      ACCEPT_TOKEN(anon_sym_includes);
      END_STATE();
    case 329:
      ACCEPT_TOKEN(anon_sym_SEMI);
      END_STATE();
    case 330:
      ACCEPT_TOKEN(anon_sym_readonly);
      END_STATE();
    case 331:
      ACCEPT_TOKEN(anon_sym_readonly);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 332:
      ACCEPT_TOKEN(anon_sym_setlike);
      END_STATE();
    case 333:
      ACCEPT_TOKEN(anon_sym_setlike);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 334:
      ACCEPT_TOKEN(anon_sym_COLON);
      END_STATE();
    case 335:
      ACCEPT_TOKEN(sym_string_literal);
      END_STATE();
    case 336:
      ACCEPT_TOKEN(sym_number_literal);
      if (lookahead == 'x') ADVANCE(169);
      if (('0' <= lookahead && lookahead <= '9')) ADVANCE(337);
      END_STATE();
    case 337:
      ACCEPT_TOKEN(sym_number_literal);
      if (('0' <= lookahead && lookahead <= '9')) ADVANCE(337);
      END_STATE();
    case 338:
      ACCEPT_TOKEN(sym_hex_literal);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'F') ||
          ('a' <= lookahead && lookahead <= 'f')) ADVANCE(338);
      END_STATE();
    case 339:
      ACCEPT_TOKEN(sym_object_literal);
      END_STATE();
    case 340:
      ACCEPT_TOKEN(anon_sym_true);
      END_STATE();
    case 341:
      ACCEPT_TOKEN(anon_sym_false);
      END_STATE();
    case 342:
      ACCEPT_TOKEN(sym_array_literal);
      END_STATE();
    case 343:
      ACCEPT_TOKEN(anon_sym_LBRACK);
      END_STATE();
    case 344:
      ACCEPT_TOKEN(anon_sym_RBRACK);
      END_STATE();
    case 345:
      ACCEPT_TOKEN(anon_sym_EQ);
      END_STATE();
    case 346:
      ACCEPT_TOKEN(anon_sym_LPAREN);
      END_STATE();
    case 347:
      ACCEPT_TOKEN(anon_sym_RPAREN);
      END_STATE();
    case 348:
      ACCEPT_TOKEN(anon_sym_interface);
      END_STATE();
    case 349:
      ACCEPT_TOKEN(anon_sym_interface);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 350:
      ACCEPT_TOKEN(anon_sym_mixin);
      END_STATE();
    case 351:
      ACCEPT_TOKEN(anon_sym_mixin);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 352:
      ACCEPT_TOKEN(anon_sym_LBRACE);
      END_STATE();
    case 353:
      ACCEPT_TOKEN(anon_sym_RBRACE);
      END_STATE();
    case 354:
      ACCEPT_TOKEN(anon_sym_optional);
      END_STATE();
    case 355:
      ACCEPT_TOKEN(anon_sym_optional);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 356:
      ACCEPT_TOKEN(anon_sym_attribute);
      END_STATE();
    case 357:
      ACCEPT_TOKEN(anon_sym_attribute);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 358:
      ACCEPT_TOKEN(anon_sym_required);
      END_STATE();
    case 359:
      ACCEPT_TOKEN(anon_sym_required);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 360:
      ACCEPT_TOKEN(anon_sym_enum);
      END_STATE();
    case 361:
      ACCEPT_TOKEN(anon_sym_enum);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 362:
      ACCEPT_TOKEN(anon_sym_dictionary);
      END_STATE();
    case 363:
      ACCEPT_TOKEN(anon_sym_dictionary);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 364:
      ACCEPT_TOKEN(anon_sym_namespace);
      END_STATE();
    case 365:
      ACCEPT_TOKEN(anon_sym_namespace);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    case 366:
      ACCEPT_TOKEN(anon_sym_const);
      END_STATE();
    case 367:
      ACCEPT_TOKEN(anon_sym_typedef);
      END_STATE();
    case 368:
      ACCEPT_TOKEN(anon_sym_typedef);
      if (('0' <= lookahead && lookahead <= '9') ||
          ('A' <= lookahead && lookahead <= 'Z') ||
          lookahead == '_' ||
          ('a' <= lookahead && lookahead <= 'z')) ADVANCE(300);
      END_STATE();
    default:
      return false;
  }
}

static const TSLexMode ts_lex_modes[STATE_COUNT] = {
  [0] = {.lex_state = 0},
  [1] = {.lex_state = 171},
  [2] = {.lex_state = 7},
  [3] = {.lex_state = 7},
  [4] = {.lex_state = 7},
  [5] = {.lex_state = 7},
  [6] = {.lex_state = 7},
  [7] = {.lex_state = 7},
  [8] = {.lex_state = 7},
  [9] = {.lex_state = 7},
  [10] = {.lex_state = 8},
  [11] = {.lex_state = 8},
  [12] = {.lex_state = 8},
  [13] = {.lex_state = 8},
  [14] = {.lex_state = 8},
  [15] = {.lex_state = 8},
  [16] = {.lex_state = 8},
  [17] = {.lex_state = 8},
  [18] = {.lex_state = 8},
  [19] = {.lex_state = 8},
  [20] = {.lex_state = 9},
  [21] = {.lex_state = 9},
  [22] = {.lex_state = 9},
  [23] = {.lex_state = 6},
  [24] = {.lex_state = 6},
  [25] = {.lex_state = 11},
  [26] = {.lex_state = 11},
  [27] = {.lex_state = 11},
  [28] = {.lex_state = 11},
  [29] = {.lex_state = 11},
  [30] = {.lex_state = 11},
  [31] = {.lex_state = 8},
  [32] = {.lex_state = 8},
  [33] = {.lex_state = 8},
  [34] = {.lex_state = 11},
  [35] = {.lex_state = 8},
  [36] = {.lex_state = 11},
  [37] = {.lex_state = 8},
  [38] = {.lex_state = 8},
  [39] = {.lex_state = 8},
  [40] = {.lex_state = 11},
  [41] = {.lex_state = 11},
  [42] = {.lex_state = 8},
  [43] = {.lex_state = 8},
  [44] = {.lex_state = 11},
  [45] = {.lex_state = 8},
  [46] = {.lex_state = 11},
  [47] = {.lex_state = 8},
  [48] = {.lex_state = 9},
  [49] = {.lex_state = 171},
  [50] = {.lex_state = 9},
  [51] = {.lex_state = 9},
  [52] = {.lex_state = 9},
  [53] = {.lex_state = 8},
  [54] = {.lex_state = 171},
  [55] = {.lex_state = 9},
  [56] = {.lex_state = 8},
  [57] = {.lex_state = 8},
  [58] = {.lex_state = 8},
  [59] = {.lex_state = 11},
  [60] = {.lex_state = 11},
  [61] = {.lex_state = 11},
  [62] = {.lex_state = 11},
  [63] = {.lex_state = 171},
  [64] = {.lex_state = 2},
  [65] = {.lex_state = 171},
  [66] = {.lex_state = 171},
  [67] = {.lex_state = 171},
  [68] = {.lex_state = 171},
  [69] = {.lex_state = 171},
  [70] = {.lex_state = 171},
  [71] = {.lex_state = 171},
  [72] = {.lex_state = 171},
  [73] = {.lex_state = 171},
  [74] = {.lex_state = 171},
  [75] = {.lex_state = 171},
  [76] = {.lex_state = 171},
  [77] = {.lex_state = 171},
  [78] = {.lex_state = 171},
  [79] = {.lex_state = 171},
  [80] = {.lex_state = 171},
  [81] = {.lex_state = 2},
  [82] = {.lex_state = 171},
  [83] = {.lex_state = 171},
  [84] = {.lex_state = 171},
  [85] = {.lex_state = 171},
  [86] = {.lex_state = 171},
  [87] = {.lex_state = 171},
  [88] = {.lex_state = 171},
  [89] = {.lex_state = 171},
  [90] = {.lex_state = 171},
  [91] = {.lex_state = 171},
  [92] = {.lex_state = 171},
  [93] = {.lex_state = 171},
  [94] = {.lex_state = 171},
  [95] = {.lex_state = 4},
  [96] = {.lex_state = 0},
  [97] = {.lex_state = 4},
  [98] = {.lex_state = 0},
  [99] = {.lex_state = 0},
  [100] = {.lex_state = 0},
  [101] = {.lex_state = 0},
  [102] = {.lex_state = 0},
  [103] = {.lex_state = 0},
  [104] = {.lex_state = 0},
  [105] = {.lex_state = 0},
  [106] = {.lex_state = 0},
  [107] = {.lex_state = 4},
  [108] = {.lex_state = 4},
  [109] = {.lex_state = 0},
  [110] = {.lex_state = 4},
  [111] = {.lex_state = 0},
  [112] = {.lex_state = 0},
  [113] = {.lex_state = 4},
  [114] = {.lex_state = 0},
  [115] = {.lex_state = 4},
  [116] = {.lex_state = 4},
  [117] = {.lex_state = 4},
  [118] = {.lex_state = 4},
  [119] = {.lex_state = 4},
  [120] = {.lex_state = 4},
  [121] = {.lex_state = 0},
  [122] = {.lex_state = 0},
  [123] = {.lex_state = 0},
  [124] = {.lex_state = 0},
  [125] = {.lex_state = 0},
  [126] = {.lex_state = 0},
  [127] = {.lex_state = 0},
  [128] = {.lex_state = 0},
  [129] = {.lex_state = 0},
  [130] = {.lex_state = 0},
  [131] = {.lex_state = 0},
  [132] = {.lex_state = 0},
  [133] = {.lex_state = 0},
  [134] = {.lex_state = 0},
  [135] = {.lex_state = 0},
  [136] = {.lex_state = 0},
  [137] = {.lex_state = 0},
  [138] = {.lex_state = 0},
  [139] = {.lex_state = 0},
  [140] = {.lex_state = 4},
  [141] = {.lex_state = 0},
  [142] = {.lex_state = 0},
  [143] = {.lex_state = 0},
  [144] = {.lex_state = 4},
  [145] = {.lex_state = 0},
  [146] = {.lex_state = 0},
  [147] = {.lex_state = 0},
  [148] = {.lex_state = 4},
  [149] = {.lex_state = 0},
  [150] = {.lex_state = 0},
  [151] = {.lex_state = 0},
  [152] = {.lex_state = 0},
  [153] = {.lex_state = 0},
  [154] = {.lex_state = 0},
  [155] = {.lex_state = 98},
  [156] = {.lex_state = 0},
  [157] = {.lex_state = 0},
  [158] = {.lex_state = 0},
  [159] = {.lex_state = 0},
  [160] = {.lex_state = 0},
  [161] = {.lex_state = 4},
  [162] = {.lex_state = 0},
  [163] = {.lex_state = 0},
  [164] = {.lex_state = 0},
  [165] = {.lex_state = 0},
  [166] = {.lex_state = 0},
  [167] = {.lex_state = 0},
  [168] = {.lex_state = 0},
  [169] = {.lex_state = 98},
  [170] = {.lex_state = 0},
  [171] = {.lex_state = 0},
  [172] = {.lex_state = 0},
  [173] = {.lex_state = 0},
  [174] = {.lex_state = 0},
  [175] = {.lex_state = 0},
  [176] = {.lex_state = 0},
  [177] = {.lex_state = 0},
  [178] = {.lex_state = 0},
  [179] = {.lex_state = 0},
  [180] = {.lex_state = 0},
  [181] = {.lex_state = 0},
  [182] = {.lex_state = 0},
  [183] = {.lex_state = 0},
  [184] = {.lex_state = 4},
  [185] = {.lex_state = 0},
  [186] = {.lex_state = 0},
  [187] = {.lex_state = 0},
  [188] = {.lex_state = 0},
  [189] = {.lex_state = 0},
  [190] = {.lex_state = 0},
  [191] = {.lex_state = 0},
  [192] = {.lex_state = 4},
  [193] = {.lex_state = 0},
  [194] = {.lex_state = 4},
  [195] = {.lex_state = 0},
  [196] = {.lex_state = 0},
  [197] = {.lex_state = 0},
  [198] = {.lex_state = 0},
  [199] = {.lex_state = 0},
  [200] = {.lex_state = 0},
  [201] = {.lex_state = 4},
  [202] = {.lex_state = 0},
  [203] = {.lex_state = 0},
  [204] = {.lex_state = 0},
  [205] = {.lex_state = 0},
  [206] = {.lex_state = 0},
  [207] = {.lex_state = 0},
  [208] = {.lex_state = 0},
  [209] = {.lex_state = 4},
  [210] = {.lex_state = 0},
  [211] = {.lex_state = 0},
  [212] = {.lex_state = 0},
  [213] = {.lex_state = 0},
  [214] = {.lex_state = 0},
  [215] = {.lex_state = 0},
  [216] = {.lex_state = 4},
  [217] = {.lex_state = 0},
  [218] = {.lex_state = 0},
  [219] = {.lex_state = 4},
  [220] = {.lex_state = 4},
  [221] = {.lex_state = 4},
  [222] = {.lex_state = 0},
  [223] = {.lex_state = 0},
  [224] = {.lex_state = 0},
  [225] = {.lex_state = 0},
  [226] = {.lex_state = 4},
  [227] = {.lex_state = 0},
  [228] = {.lex_state = 0},
  [229] = {.lex_state = 4},
  [230] = {.lex_state = 0},
  [231] = {.lex_state = 0},
  [232] = {.lex_state = 4},
  [233] = {.lex_state = 0},
  [234] = {.lex_state = 0},
  [235] = {.lex_state = 4},
  [236] = {.lex_state = 4},
  [237] = {.lex_state = 4},
  [238] = {.lex_state = 0},
  [239] = {.lex_state = 0},
  [240] = {.lex_state = 0},
  [241] = {.lex_state = 0},
  [242] = {.lex_state = 0},
  [243] = {.lex_state = 0},
  [244] = {.lex_state = 0},
  [245] = {.lex_state = 0},
  [246] = {.lex_state = 0},
  [247] = {.lex_state = 0},
  [248] = {.lex_state = 4},
  [249] = {.lex_state = 0},
  [250] = {.lex_state = 0},
  [251] = {.lex_state = 4},
  [252] = {.lex_state = 4},
  [253] = {.lex_state = 4},
  [254] = {.lex_state = 4},
  [255] = {.lex_state = 0},
  [256] = {.lex_state = 0},
  [257] = {.lex_state = 0},
  [258] = {.lex_state = 4},
};

static const uint16_t ts_parse_table[LARGE_STATE_COUNT][SYMBOL_COUNT] = {
  [0] = {
    [ts_builtin_sym_end] = ACTIONS(1),
    [sym_comment] = ACTIONS(1),
    [anon_sym_undefined] = ACTIONS(1),
    [anon_sym_boolean] = ACTIONS(1),
    [anon_sym_byte] = ACTIONS(1),
    [anon_sym_short] = ACTIONS(1),
    [anon_sym_unsignedshort] = ACTIONS(1),
    [anon_sym_long] = ACTIONS(1),
    [anon_sym_float] = ACTIONS(1),
    [anon_sym_double] = ACTIONS(1),
    [anon_sym_longlong] = ACTIONS(1),
    [anon_sym_unsignedlong] = ACTIONS(1),
    [anon_sym_unsignedlonglong] = ACTIONS(1),
    [anon_sym_DOMString] = ACTIONS(1),
    [anon_sym_USVString] = ACTIONS(1),
    [anon_sym_LT] = ACTIONS(1),
    [anon_sym_COMMA] = ACTIONS(1),
    [anon_sym_GT] = ACTIONS(1),
    [anon_sym_QMARK] = ACTIONS(1),
    [anon_sym_includes] = ACTIONS(1),
    [anon_sym_SEMI] = ACTIONS(1),
    [anon_sym_readonly] = ACTIONS(1),
    [anon_sym_setlike] = ACTIONS(1),
    [anon_sym_COLON] = ACTIONS(1),
    [sym_string_literal] = ACTIONS(1),
    [sym_number_literal] = ACTIONS(1),
    [sym_hex_literal] = ACTIONS(1),
    [anon_sym_true] = ACTIONS(1),
    [anon_sym_false] = ACTIONS(1),
    [anon_sym_LBRACK] = ACTIONS(1),
    [anon_sym_RBRACK] = ACTIONS(1),
    [anon_sym_EQ] = ACTIONS(1),
    [anon_sym_LPAREN] = ACTIONS(1),
    [anon_sym_RPAREN] = ACTIONS(1),
    [anon_sym_interface] = ACTIONS(1),
    [anon_sym_mixin] = ACTIONS(1),
    [anon_sym_LBRACE] = ACTIONS(1),
    [anon_sym_RBRACE] = ACTIONS(1),
    [anon_sym_optional] = ACTIONS(1),
    [anon_sym_attribute] = ACTIONS(1),
    [anon_sym_required] = ACTIONS(1),
    [anon_sym_enum] = ACTIONS(1),
    [anon_sym_dictionary] = ACTIONS(1),
    [anon_sym_namespace] = ACTIONS(1),
    [anon_sym_const] = ACTIONS(1),
    [anon_sym_typedef] = ACTIONS(1),
  },
  [1] = {
    [sym_source_file] = STATE(250),
    [sym__declaration] = STATE(49),
    [sym_includes_declaration] = STATE(49),
    [sym_attributes] = STATE(165),
    [sym_interface_declaration] = STATE(49),
    [sym_enum_declaration] = STATE(49),
    [sym_dictionary_declaration] = STATE(49),
    [sym_namespace_declaration] = STATE(49),
    [sym_typedef_declaration] = STATE(49),
    [aux_sym_source_file_repeat1] = STATE(49),
    [ts_builtin_sym_end] = ACTIONS(3),
    [sym_identifier] = ACTIONS(5),
    [sym_comment] = ACTIONS(7),
    [anon_sym_LBRACK] = ACTIONS(9),
    [anon_sym_interface] = ACTIONS(11),
    [anon_sym_enum] = ACTIONS(13),
    [anon_sym_dictionary] = ACTIONS(15),
    [anon_sym_namespace] = ACTIONS(17),
    [anon_sym_typedef] = ACTIONS(19),
  },
};

static const uint16_t ts_small_parse_table[] = {
  [0] = 17,
    ACTIONS(21), 1,
      sym_identifier,
    ACTIONS(23), 1,
      sym_comment,
    ACTIONS(29), 1,
      anon_sym_readonly,
    ACTIONS(31), 1,
      anon_sym_setlike,
    ACTIONS(33), 1,
      anon_sym_LBRACK,
    ACTIONS(35), 1,
      anon_sym_RBRACE,
    ACTIONS(37), 1,
      anon_sym_attribute,
    STATE(12), 1,
      sym_setlike_declaration,
    STATE(33), 1,
      sym_operation_declaration,
    STATE(43), 1,
      sym__field_declaration,
    STATE(53), 1,
      sym_attributes,
    STATE(184), 1,
      sym_type,
    STATE(247), 1,
      sym_iterface_decl_list,
    STATE(18), 2,
      sym_interface_member,
      aux_sym_iterface_decl_list_repeat1,
    STATE(107), 2,
      sym_primitive_type,
      sym_parameterized,
    ACTIONS(27), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(25), 10,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [65] = 17,
    ACTIONS(21), 1,
      sym_identifier,
    ACTIONS(23), 1,
      sym_comment,
    ACTIONS(29), 1,
      anon_sym_readonly,
    ACTIONS(31), 1,
      anon_sym_setlike,
    ACTIONS(33), 1,
      anon_sym_LBRACK,
    ACTIONS(35), 1,
      anon_sym_RBRACE,
    ACTIONS(37), 1,
      anon_sym_attribute,
    STATE(14), 1,
      sym_setlike_declaration,
    STATE(33), 1,
      sym_operation_declaration,
    STATE(43), 1,
      sym__field_declaration,
    STATE(53), 1,
      sym_attributes,
    STATE(182), 1,
      sym_iterface_decl_list,
    STATE(184), 1,
      sym_type,
    STATE(18), 2,
      sym_interface_member,
      aux_sym_iterface_decl_list_repeat1,
    STATE(107), 2,
      sym_primitive_type,
      sym_parameterized,
    ACTIONS(27), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(25), 10,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [130] = 17,
    ACTIONS(21), 1,
      sym_identifier,
    ACTIONS(23), 1,
      sym_comment,
    ACTIONS(29), 1,
      anon_sym_readonly,
    ACTIONS(31), 1,
      anon_sym_setlike,
    ACTIONS(33), 1,
      anon_sym_LBRACK,
    ACTIONS(35), 1,
      anon_sym_RBRACE,
    ACTIONS(37), 1,
      anon_sym_attribute,
    STATE(13), 1,
      sym_setlike_declaration,
    STATE(33), 1,
      sym_operation_declaration,
    STATE(43), 1,
      sym__field_declaration,
    STATE(53), 1,
      sym_attributes,
    STATE(184), 1,
      sym_type,
    STATE(206), 1,
      sym_iterface_decl_list,
    STATE(18), 2,
      sym_interface_member,
      aux_sym_iterface_decl_list_repeat1,
    STATE(107), 2,
      sym_primitive_type,
      sym_parameterized,
    ACTIONS(27), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(25), 10,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [195] = 17,
    ACTIONS(21), 1,
      sym_identifier,
    ACTIONS(23), 1,
      sym_comment,
    ACTIONS(29), 1,
      anon_sym_readonly,
    ACTIONS(31), 1,
      anon_sym_setlike,
    ACTIONS(33), 1,
      anon_sym_LBRACK,
    ACTIONS(35), 1,
      anon_sym_RBRACE,
    ACTIONS(37), 1,
      anon_sym_attribute,
    STATE(10), 1,
      sym_setlike_declaration,
    STATE(33), 1,
      sym_operation_declaration,
    STATE(43), 1,
      sym__field_declaration,
    STATE(53), 1,
      sym_attributes,
    STATE(180), 1,
      sym_iterface_decl_list,
    STATE(184), 1,
      sym_type,
    STATE(18), 2,
      sym_interface_member,
      aux_sym_iterface_decl_list_repeat1,
    STATE(107), 2,
      sym_primitive_type,
      sym_parameterized,
    ACTIONS(27), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(25), 10,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [260] = 17,
    ACTIONS(21), 1,
      sym_identifier,
    ACTIONS(23), 1,
      sym_comment,
    ACTIONS(29), 1,
      anon_sym_readonly,
    ACTIONS(31), 1,
      anon_sym_setlike,
    ACTIONS(33), 1,
      anon_sym_LBRACK,
    ACTIONS(35), 1,
      anon_sym_RBRACE,
    ACTIONS(37), 1,
      anon_sym_attribute,
    STATE(11), 1,
      sym_setlike_declaration,
    STATE(33), 1,
      sym_operation_declaration,
    STATE(43), 1,
      sym__field_declaration,
    STATE(53), 1,
      sym_attributes,
    STATE(184), 1,
      sym_type,
    STATE(213), 1,
      sym_iterface_decl_list,
    STATE(18), 2,
      sym_interface_member,
      aux_sym_iterface_decl_list_repeat1,
    STATE(107), 2,
      sym_primitive_type,
      sym_parameterized,
    ACTIONS(27), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(25), 10,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [325] = 17,
    ACTIONS(21), 1,
      sym_identifier,
    ACTIONS(23), 1,
      sym_comment,
    ACTIONS(29), 1,
      anon_sym_readonly,
    ACTIONS(31), 1,
      anon_sym_setlike,
    ACTIONS(33), 1,
      anon_sym_LBRACK,
    ACTIONS(35), 1,
      anon_sym_RBRACE,
    ACTIONS(37), 1,
      anon_sym_attribute,
    STATE(15), 1,
      sym_setlike_declaration,
    STATE(33), 1,
      sym_operation_declaration,
    STATE(43), 1,
      sym__field_declaration,
    STATE(53), 1,
      sym_attributes,
    STATE(184), 1,
      sym_type,
    STATE(243), 1,
      sym_iterface_decl_list,
    STATE(18), 2,
      sym_interface_member,
      aux_sym_iterface_decl_list_repeat1,
    STATE(107), 2,
      sym_primitive_type,
      sym_parameterized,
    ACTIONS(27), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(25), 10,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [390] = 17,
    ACTIONS(21), 1,
      sym_identifier,
    ACTIONS(23), 1,
      sym_comment,
    ACTIONS(29), 1,
      anon_sym_readonly,
    ACTIONS(31), 1,
      anon_sym_setlike,
    ACTIONS(33), 1,
      anon_sym_LBRACK,
    ACTIONS(35), 1,
      anon_sym_RBRACE,
    ACTIONS(37), 1,
      anon_sym_attribute,
    STATE(16), 1,
      sym_setlike_declaration,
    STATE(33), 1,
      sym_operation_declaration,
    STATE(43), 1,
      sym__field_declaration,
    STATE(53), 1,
      sym_attributes,
    STATE(183), 1,
      sym_iterface_decl_list,
    STATE(184), 1,
      sym_type,
    STATE(18), 2,
      sym_interface_member,
      aux_sym_iterface_decl_list_repeat1,
    STATE(107), 2,
      sym_primitive_type,
      sym_parameterized,
    ACTIONS(27), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(25), 10,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [455] = 17,
    ACTIONS(21), 1,
      sym_identifier,
    ACTIONS(23), 1,
      sym_comment,
    ACTIONS(29), 1,
      anon_sym_readonly,
    ACTIONS(31), 1,
      anon_sym_setlike,
    ACTIONS(33), 1,
      anon_sym_LBRACK,
    ACTIONS(35), 1,
      anon_sym_RBRACE,
    ACTIONS(37), 1,
      anon_sym_attribute,
    STATE(17), 1,
      sym_setlike_declaration,
    STATE(33), 1,
      sym_operation_declaration,
    STATE(43), 1,
      sym__field_declaration,
    STATE(53), 1,
      sym_attributes,
    STATE(184), 1,
      sym_type,
    STATE(255), 1,
      sym_iterface_decl_list,
    STATE(18), 2,
      sym_interface_member,
      aux_sym_iterface_decl_list_repeat1,
    STATE(107), 2,
      sym_primitive_type,
      sym_parameterized,
    ACTIONS(27), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(25), 10,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [520] = 15,
    ACTIONS(21), 1,
      sym_identifier,
    ACTIONS(23), 1,
      sym_comment,
    ACTIONS(33), 1,
      anon_sym_LBRACK,
    ACTIONS(35), 1,
      anon_sym_RBRACE,
    ACTIONS(37), 1,
      anon_sym_attribute,
    ACTIONS(39), 1,
      anon_sym_readonly,
    STATE(33), 1,
      sym_operation_declaration,
    STATE(43), 1,
      sym__field_declaration,
    STATE(53), 1,
      sym_attributes,
    STATE(184), 1,
      sym_type,
    STATE(208), 1,
      sym_iterface_decl_list,
    STATE(18), 2,
      sym_interface_member,
      aux_sym_iterface_decl_list_repeat1,
    STATE(107), 2,
      sym_primitive_type,
      sym_parameterized,
    ACTIONS(27), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(25), 10,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [579] = 15,
    ACTIONS(21), 1,
      sym_identifier,
    ACTIONS(23), 1,
      sym_comment,
    ACTIONS(33), 1,
      anon_sym_LBRACK,
    ACTIONS(35), 1,
      anon_sym_RBRACE,
    ACTIONS(37), 1,
      anon_sym_attribute,
    ACTIONS(39), 1,
      anon_sym_readonly,
    STATE(33), 1,
      sym_operation_declaration,
    STATE(43), 1,
      sym__field_declaration,
    STATE(53), 1,
      sym_attributes,
    STATE(184), 1,
      sym_type,
    STATE(231), 1,
      sym_iterface_decl_list,
    STATE(18), 2,
      sym_interface_member,
      aux_sym_iterface_decl_list_repeat1,
    STATE(107), 2,
      sym_primitive_type,
      sym_parameterized,
    ACTIONS(27), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(25), 10,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [638] = 15,
    ACTIONS(21), 1,
      sym_identifier,
    ACTIONS(23), 1,
      sym_comment,
    ACTIONS(33), 1,
      anon_sym_LBRACK,
    ACTIONS(35), 1,
      anon_sym_RBRACE,
    ACTIONS(37), 1,
      anon_sym_attribute,
    ACTIONS(39), 1,
      anon_sym_readonly,
    STATE(33), 1,
      sym_operation_declaration,
    STATE(43), 1,
      sym__field_declaration,
    STATE(53), 1,
      sym_attributes,
    STATE(177), 1,
      sym_iterface_decl_list,
    STATE(184), 1,
      sym_type,
    STATE(18), 2,
      sym_interface_member,
      aux_sym_iterface_decl_list_repeat1,
    STATE(107), 2,
      sym_primitive_type,
      sym_parameterized,
    ACTIONS(27), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(25), 10,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [697] = 15,
    ACTIONS(21), 1,
      sym_identifier,
    ACTIONS(23), 1,
      sym_comment,
    ACTIONS(33), 1,
      anon_sym_LBRACK,
    ACTIONS(35), 1,
      anon_sym_RBRACE,
    ACTIONS(37), 1,
      anon_sym_attribute,
    ACTIONS(39), 1,
      anon_sym_readonly,
    STATE(33), 1,
      sym_operation_declaration,
    STATE(43), 1,
      sym__field_declaration,
    STATE(53), 1,
      sym_attributes,
    STATE(184), 1,
      sym_type,
    STATE(198), 1,
      sym_iterface_decl_list,
    STATE(18), 2,
      sym_interface_member,
      aux_sym_iterface_decl_list_repeat1,
    STATE(107), 2,
      sym_primitive_type,
      sym_parameterized,
    ACTIONS(27), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(25), 10,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [756] = 15,
    ACTIONS(21), 1,
      sym_identifier,
    ACTIONS(23), 1,
      sym_comment,
    ACTIONS(33), 1,
      anon_sym_LBRACK,
    ACTIONS(35), 1,
      anon_sym_RBRACE,
    ACTIONS(37), 1,
      anon_sym_attribute,
    ACTIONS(39), 1,
      anon_sym_readonly,
    STATE(33), 1,
      sym_operation_declaration,
    STATE(43), 1,
      sym__field_declaration,
    STATE(53), 1,
      sym_attributes,
    STATE(184), 1,
      sym_type,
    STATE(210), 1,
      sym_iterface_decl_list,
    STATE(18), 2,
      sym_interface_member,
      aux_sym_iterface_decl_list_repeat1,
    STATE(107), 2,
      sym_primitive_type,
      sym_parameterized,
    ACTIONS(27), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(25), 10,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [815] = 15,
    ACTIONS(21), 1,
      sym_identifier,
    ACTIONS(23), 1,
      sym_comment,
    ACTIONS(33), 1,
      anon_sym_LBRACK,
    ACTIONS(35), 1,
      anon_sym_RBRACE,
    ACTIONS(37), 1,
      anon_sym_attribute,
    ACTIONS(39), 1,
      anon_sym_readonly,
    STATE(33), 1,
      sym_operation_declaration,
    STATE(43), 1,
      sym__field_declaration,
    STATE(53), 1,
      sym_attributes,
    STATE(184), 1,
      sym_type,
    STATE(217), 1,
      sym_iterface_decl_list,
    STATE(18), 2,
      sym_interface_member,
      aux_sym_iterface_decl_list_repeat1,
    STATE(107), 2,
      sym_primitive_type,
      sym_parameterized,
    ACTIONS(27), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(25), 10,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [874] = 15,
    ACTIONS(21), 1,
      sym_identifier,
    ACTIONS(23), 1,
      sym_comment,
    ACTIONS(33), 1,
      anon_sym_LBRACK,
    ACTIONS(35), 1,
      anon_sym_RBRACE,
    ACTIONS(37), 1,
      anon_sym_attribute,
    ACTIONS(39), 1,
      anon_sym_readonly,
    STATE(33), 1,
      sym_operation_declaration,
    STATE(43), 1,
      sym__field_declaration,
    STATE(53), 1,
      sym_attributes,
    STATE(184), 1,
      sym_type,
    STATE(244), 1,
      sym_iterface_decl_list,
    STATE(18), 2,
      sym_interface_member,
      aux_sym_iterface_decl_list_repeat1,
    STATE(107), 2,
      sym_primitive_type,
      sym_parameterized,
    ACTIONS(27), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(25), 10,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [933] = 15,
    ACTIONS(21), 1,
      sym_identifier,
    ACTIONS(23), 1,
      sym_comment,
    ACTIONS(33), 1,
      anon_sym_LBRACK,
    ACTIONS(35), 1,
      anon_sym_RBRACE,
    ACTIONS(37), 1,
      anon_sym_attribute,
    ACTIONS(39), 1,
      anon_sym_readonly,
    STATE(33), 1,
      sym_operation_declaration,
    STATE(43), 1,
      sym__field_declaration,
    STATE(53), 1,
      sym_attributes,
    STATE(184), 1,
      sym_type,
    STATE(211), 1,
      sym_iterface_decl_list,
    STATE(18), 2,
      sym_interface_member,
      aux_sym_iterface_decl_list_repeat1,
    STATE(107), 2,
      sym_primitive_type,
      sym_parameterized,
    ACTIONS(27), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(25), 10,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [992] = 14,
    ACTIONS(21), 1,
      sym_identifier,
    ACTIONS(33), 1,
      anon_sym_LBRACK,
    ACTIONS(37), 1,
      anon_sym_attribute,
    ACTIONS(39), 1,
      anon_sym_readonly,
    ACTIONS(41), 1,
      sym_comment,
    ACTIONS(43), 1,
      anon_sym_RBRACE,
    STATE(33), 1,
      sym_operation_declaration,
    STATE(43), 1,
      sym__field_declaration,
    STATE(53), 1,
      sym_attributes,
    STATE(184), 1,
      sym_type,
    STATE(19), 2,
      sym_interface_member,
      aux_sym_iterface_decl_list_repeat1,
    STATE(107), 2,
      sym_primitive_type,
      sym_parameterized,
    ACTIONS(27), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(25), 10,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [1048] = 14,
    ACTIONS(45), 1,
      sym_identifier,
    ACTIONS(48), 1,
      sym_comment,
    ACTIONS(57), 1,
      anon_sym_readonly,
    ACTIONS(60), 1,
      anon_sym_LBRACK,
    ACTIONS(63), 1,
      anon_sym_RBRACE,
    ACTIONS(65), 1,
      anon_sym_attribute,
    STATE(33), 1,
      sym_operation_declaration,
    STATE(43), 1,
      sym__field_declaration,
    STATE(53), 1,
      sym_attributes,
    STATE(184), 1,
      sym_type,
    STATE(19), 2,
      sym_interface_member,
      aux_sym_iterface_decl_list_repeat1,
    STATE(107), 2,
      sym_primitive_type,
      sym_parameterized,
    ACTIONS(54), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(51), 10,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [1104] = 12,
    ACTIONS(21), 1,
      sym_identifier,
    ACTIONS(68), 1,
      sym_comment,
    ACTIONS(70), 1,
      anon_sym_LBRACK,
    ACTIONS(72), 1,
      anon_sym_RBRACE,
    ACTIONS(74), 1,
      anon_sym_required,
    STATE(50), 1,
      sym__dict_field_declaration,
    STATE(59), 1,
      sym_attributes,
    STATE(201), 1,
      sym_type,
    STATE(21), 2,
      sym_dictionary_member,
      aux_sym_dictionary_decl_list_repeat1,
    STATE(107), 2,
      sym_primitive_type,
      sym_parameterized,
    ACTIONS(27), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(25), 10,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [1154] = 12,
    ACTIONS(21), 1,
      sym_identifier,
    ACTIONS(70), 1,
      anon_sym_LBRACK,
    ACTIONS(74), 1,
      anon_sym_required,
    ACTIONS(76), 1,
      sym_comment,
    ACTIONS(78), 1,
      anon_sym_RBRACE,
    STATE(50), 1,
      sym__dict_field_declaration,
    STATE(59), 1,
      sym_attributes,
    STATE(201), 1,
      sym_type,
    STATE(22), 2,
      sym_dictionary_member,
      aux_sym_dictionary_decl_list_repeat1,
    STATE(107), 2,
      sym_primitive_type,
      sym_parameterized,
    ACTIONS(27), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(25), 10,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [1204] = 12,
    ACTIONS(80), 1,
      sym_identifier,
    ACTIONS(83), 1,
      sym_comment,
    ACTIONS(92), 1,
      anon_sym_LBRACK,
    ACTIONS(95), 1,
      anon_sym_RBRACE,
    ACTIONS(97), 1,
      anon_sym_required,
    STATE(50), 1,
      sym__dict_field_declaration,
    STATE(59), 1,
      sym_attributes,
    STATE(201), 1,
      sym_type,
    STATE(22), 2,
      sym_dictionary_member,
      aux_sym_dictionary_decl_list_repeat1,
    STATE(107), 2,
      sym_primitive_type,
      sym_parameterized,
    ACTIONS(89), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(86), 10,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [1254] = 10,
    ACTIONS(21), 1,
      sym_identifier,
    ACTIONS(70), 1,
      anon_sym_LBRACK,
    ACTIONS(100), 1,
      anon_sym_RPAREN,
    ACTIONS(102), 1,
      anon_sym_optional,
    STATE(59), 1,
      sym_attributes,
    STATE(123), 1,
      sym_operation_parameter,
    STATE(192), 1,
      sym_type,
    STATE(107), 2,
      sym_primitive_type,
      sym_parameterized,
    ACTIONS(27), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(25), 10,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [1297] = 9,
    ACTIONS(21), 1,
      sym_identifier,
    ACTIONS(70), 1,
      anon_sym_LBRACK,
    ACTIONS(102), 1,
      anon_sym_optional,
    STATE(59), 1,
      sym_attributes,
    STATE(157), 1,
      sym_operation_parameter,
    STATE(192), 1,
      sym_type,
    STATE(107), 2,
      sym_primitive_type,
      sym_parameterized,
    ACTIONS(27), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(25), 10,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [1337] = 7,
    ACTIONS(21), 1,
      sym_identifier,
    ACTIONS(70), 1,
      anon_sym_LBRACK,
    STATE(59), 1,
      sym_attributes,
    STATE(194), 1,
      sym_type,
    STATE(107), 2,
      sym_primitive_type,
      sym_parameterized,
    ACTIONS(27), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(25), 10,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [1371] = 7,
    ACTIONS(21), 1,
      sym_identifier,
    ACTIONS(70), 1,
      anon_sym_LBRACK,
    STATE(59), 1,
      sym_attributes,
    STATE(258), 1,
      sym_type,
    STATE(107), 2,
      sym_primitive_type,
      sym_parameterized,
    ACTIONS(27), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(25), 10,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [1405] = 7,
    ACTIONS(21), 1,
      sym_identifier,
    ACTIONS(70), 1,
      anon_sym_LBRACK,
    STATE(59), 1,
      sym_attributes,
    STATE(219), 1,
      sym_type,
    STATE(107), 2,
      sym_primitive_type,
      sym_parameterized,
    ACTIONS(27), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(25), 10,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [1439] = 7,
    ACTIONS(21), 1,
      sym_identifier,
    ACTIONS(70), 1,
      anon_sym_LBRACK,
    STATE(59), 1,
      sym_attributes,
    STATE(186), 1,
      sym_type,
    STATE(107), 2,
      sym_primitive_type,
      sym_parameterized,
    ACTIONS(27), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(25), 10,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [1473] = 7,
    ACTIONS(21), 1,
      sym_identifier,
    ACTIONS(70), 1,
      anon_sym_LBRACK,
    STATE(59), 1,
      sym_attributes,
    STATE(237), 1,
      sym_type,
    STATE(107), 2,
      sym_primitive_type,
      sym_parameterized,
    ACTIONS(27), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(25), 10,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [1507] = 7,
    ACTIONS(21), 1,
      sym_identifier,
    ACTIONS(70), 1,
      anon_sym_LBRACK,
    STATE(59), 1,
      sym_attributes,
    STATE(232), 1,
      sym_type,
    STATE(107), 2,
      sym_primitive_type,
      sym_parameterized,
    ACTIONS(27), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(25), 10,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [1541] = 2,
    ACTIONS(106), 6,
      sym_comment,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
      anon_sym_LBRACK,
      anon_sym_RBRACE,
    ACTIONS(104), 13,
      sym_identifier,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
      anon_sym_readonly,
      anon_sym_attribute,
  [1565] = 2,
    ACTIONS(110), 6,
      sym_comment,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
      anon_sym_LBRACK,
      anon_sym_RBRACE,
    ACTIONS(108), 13,
      sym_identifier,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
      anon_sym_readonly,
      anon_sym_attribute,
  [1589] = 2,
    ACTIONS(114), 6,
      sym_comment,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
      anon_sym_LBRACK,
      anon_sym_RBRACE,
    ACTIONS(112), 13,
      sym_identifier,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
      anon_sym_readonly,
      anon_sym_attribute,
  [1613] = 7,
    ACTIONS(21), 1,
      sym_identifier,
    ACTIONS(70), 1,
      anon_sym_LBRACK,
    STATE(59), 1,
      sym_attributes,
    STATE(225), 1,
      sym_type,
    STATE(107), 2,
      sym_primitive_type,
      sym_parameterized,
    ACTIONS(27), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(25), 10,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [1647] = 2,
    ACTIONS(118), 6,
      sym_comment,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
      anon_sym_LBRACK,
      anon_sym_RBRACE,
    ACTIONS(116), 13,
      sym_identifier,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
      anon_sym_readonly,
      anon_sym_attribute,
  [1671] = 7,
    ACTIONS(21), 1,
      sym_identifier,
    ACTIONS(70), 1,
      anon_sym_LBRACK,
    STATE(59), 1,
      sym_attributes,
    STATE(171), 1,
      sym_type,
    STATE(107), 2,
      sym_primitive_type,
      sym_parameterized,
    ACTIONS(27), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(25), 10,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [1705] = 2,
    ACTIONS(122), 6,
      sym_comment,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
      anon_sym_LBRACK,
      anon_sym_RBRACE,
    ACTIONS(120), 13,
      sym_identifier,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
      anon_sym_readonly,
      anon_sym_attribute,
  [1729] = 2,
    ACTIONS(126), 6,
      sym_comment,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
      anon_sym_LBRACK,
      anon_sym_RBRACE,
    ACTIONS(124), 13,
      sym_identifier,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
      anon_sym_readonly,
      anon_sym_attribute,
  [1753] = 2,
    ACTIONS(130), 6,
      sym_comment,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
      anon_sym_LBRACK,
      anon_sym_RBRACE,
    ACTIONS(128), 13,
      sym_identifier,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
      anon_sym_readonly,
      anon_sym_attribute,
  [1777] = 7,
    ACTIONS(21), 1,
      sym_identifier,
    ACTIONS(70), 1,
      anon_sym_LBRACK,
    STATE(59), 1,
      sym_attributes,
    STATE(254), 1,
      sym_type,
    STATE(107), 2,
      sym_primitive_type,
      sym_parameterized,
    ACTIONS(27), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(25), 10,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [1811] = 7,
    ACTIONS(21), 1,
      sym_identifier,
    ACTIONS(70), 1,
      anon_sym_LBRACK,
    STATE(59), 1,
      sym_attributes,
    STATE(221), 1,
      sym_type,
    STATE(107), 2,
      sym_primitive_type,
      sym_parameterized,
    ACTIONS(27), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(25), 10,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [1845] = 2,
    ACTIONS(134), 6,
      sym_comment,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
      anon_sym_LBRACK,
      anon_sym_RBRACE,
    ACTIONS(132), 13,
      sym_identifier,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
      anon_sym_readonly,
      anon_sym_attribute,
  [1869] = 2,
    ACTIONS(138), 6,
      sym_comment,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
      anon_sym_LBRACK,
      anon_sym_RBRACE,
    ACTIONS(136), 13,
      sym_identifier,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
      anon_sym_readonly,
      anon_sym_attribute,
  [1893] = 7,
    ACTIONS(21), 1,
      sym_identifier,
    ACTIONS(70), 1,
      anon_sym_LBRACK,
    STATE(59), 1,
      sym_attributes,
    STATE(226), 1,
      sym_type,
    STATE(107), 2,
      sym_primitive_type,
      sym_parameterized,
    ACTIONS(27), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(25), 10,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [1927] = 2,
    ACTIONS(142), 6,
      sym_comment,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
      anon_sym_LBRACK,
      anon_sym_RBRACE,
    ACTIONS(140), 13,
      sym_identifier,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
      anon_sym_readonly,
      anon_sym_attribute,
  [1951] = 7,
    ACTIONS(21), 1,
      sym_identifier,
    ACTIONS(70), 1,
      anon_sym_LBRACK,
    STATE(59), 1,
      sym_attributes,
    STATE(136), 1,
      sym_type,
    STATE(107), 2,
      sym_primitive_type,
      sym_parameterized,
    ACTIONS(27), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(25), 10,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [1985] = 2,
    ACTIONS(146), 6,
      sym_comment,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
      anon_sym_LBRACK,
      anon_sym_RBRACE,
    ACTIONS(144), 13,
      sym_identifier,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
      anon_sym_readonly,
      anon_sym_attribute,
  [2009] = 2,
    ACTIONS(150), 6,
      sym_comment,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
      anon_sym_LBRACK,
      anon_sym_RBRACE,
    ACTIONS(148), 12,
      sym_identifier,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
      anon_sym_required,
  [2032] = 11,
    ACTIONS(5), 1,
      sym_identifier,
    ACTIONS(9), 1,
      anon_sym_LBRACK,
    ACTIONS(11), 1,
      anon_sym_interface,
    ACTIONS(13), 1,
      anon_sym_enum,
    ACTIONS(15), 1,
      anon_sym_dictionary,
    ACTIONS(17), 1,
      anon_sym_namespace,
    ACTIONS(19), 1,
      anon_sym_typedef,
    ACTIONS(152), 1,
      ts_builtin_sym_end,
    ACTIONS(154), 1,
      sym_comment,
    STATE(165), 1,
      sym_attributes,
    STATE(54), 8,
      sym__declaration,
      sym_includes_declaration,
      sym_interface_declaration,
      sym_enum_declaration,
      sym_dictionary_declaration,
      sym_namespace_declaration,
      sym_typedef_declaration,
      aux_sym_source_file_repeat1,
  [2073] = 2,
    ACTIONS(158), 6,
      sym_comment,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
      anon_sym_LBRACK,
      anon_sym_RBRACE,
    ACTIONS(156), 12,
      sym_identifier,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
      anon_sym_required,
  [2096] = 2,
    ACTIONS(162), 6,
      sym_comment,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
      anon_sym_LBRACK,
      anon_sym_RBRACE,
    ACTIONS(160), 12,
      sym_identifier,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
      anon_sym_required,
  [2119] = 2,
    ACTIONS(166), 6,
      sym_comment,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
      anon_sym_LBRACK,
      anon_sym_RBRACE,
    ACTIONS(164), 12,
      sym_identifier,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
      anon_sym_required,
  [2142] = 6,
    ACTIONS(168), 1,
      sym_identifier,
    ACTIONS(170), 1,
      anon_sym_readonly,
    ACTIONS(172), 1,
      anon_sym_attribute,
    STATE(118), 2,
      sym_primitive_type,
      sym_parameterized,
    ACTIONS(27), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(25), 10,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [2173] = 11,
    ACTIONS(174), 1,
      ts_builtin_sym_end,
    ACTIONS(176), 1,
      sym_identifier,
    ACTIONS(179), 1,
      sym_comment,
    ACTIONS(182), 1,
      anon_sym_LBRACK,
    ACTIONS(185), 1,
      anon_sym_interface,
    ACTIONS(188), 1,
      anon_sym_enum,
    ACTIONS(191), 1,
      anon_sym_dictionary,
    ACTIONS(194), 1,
      anon_sym_namespace,
    ACTIONS(197), 1,
      anon_sym_typedef,
    STATE(165), 1,
      sym_attributes,
    STATE(54), 8,
      sym__declaration,
      sym_includes_declaration,
      sym_interface_declaration,
      sym_enum_declaration,
      sym_dictionary_declaration,
      sym_namespace_declaration,
      sym_typedef_declaration,
      aux_sym_source_file_repeat1,
  [2214] = 2,
    ACTIONS(202), 6,
      sym_comment,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
      anon_sym_LBRACK,
      anon_sym_RBRACE,
    ACTIONS(200), 12,
      sym_identifier,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
      anon_sym_required,
  [2237] = 2,
    ACTIONS(206), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(204), 13,
      sym_identifier,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
      anon_sym_readonly,
      anon_sym_attribute,
  [2258] = 2,
    ACTIONS(210), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(208), 13,
      sym_identifier,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
      anon_sym_readonly,
      anon_sym_attribute,
  [2279] = 2,
    ACTIONS(214), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(212), 13,
      sym_identifier,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
      anon_sym_readonly,
      anon_sym_attribute,
  [2300] = 4,
    ACTIONS(168), 1,
      sym_identifier,
    STATE(118), 2,
      sym_primitive_type,
      sym_parameterized,
    ACTIONS(27), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(25), 10,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [2325] = 2,
    ACTIONS(210), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(208), 11,
      sym_identifier,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [2344] = 2,
    ACTIONS(214), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(212), 11,
      sym_identifier,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [2363] = 2,
    ACTIONS(206), 3,
      anon_sym_unsignedshort,
      anon_sym_longlong,
      anon_sym_unsignedlonglong,
    ACTIONS(204), 11,
      sym_identifier,
      anon_sym_undefined,
      anon_sym_boolean,
      anon_sym_byte,
      anon_sym_short,
      anon_sym_long,
      anon_sym_float,
      anon_sym_double,
      anon_sym_unsignedlong,
      anon_sym_DOMString,
      anon_sym_USVString,
  [2382] = 2,
    ACTIONS(216), 3,
      ts_builtin_sym_end,
      sym_comment,
      anon_sym_LBRACK,
    ACTIONS(218), 6,
      sym_identifier,
      anon_sym_interface,
      anon_sym_enum,
      anon_sym_dictionary,
      anon_sym_namespace,
      anon_sym_typedef,
  [2396] = 4,
    ACTIONS(222), 1,
      sym_number_literal,
    ACTIONS(224), 2,
      anon_sym_true,
      anon_sym_false,
    STATE(204), 2,
      sym_boolean_literal,
      sym__literal,
    ACTIONS(220), 4,
      sym_string_literal,
      sym_hex_literal,
      sym_object_literal,
      sym_array_literal,
  [2414] = 2,
    ACTIONS(226), 3,
      ts_builtin_sym_end,
      sym_comment,
      anon_sym_LBRACK,
    ACTIONS(228), 6,
      sym_identifier,
      anon_sym_interface,
      anon_sym_enum,
      anon_sym_dictionary,
      anon_sym_namespace,
      anon_sym_typedef,
  [2428] = 2,
    ACTIONS(230), 3,
      ts_builtin_sym_end,
      sym_comment,
      anon_sym_LBRACK,
    ACTIONS(232), 6,
      sym_identifier,
      anon_sym_interface,
      anon_sym_enum,
      anon_sym_dictionary,
      anon_sym_namespace,
      anon_sym_typedef,
  [2442] = 2,
    ACTIONS(234), 3,
      ts_builtin_sym_end,
      sym_comment,
      anon_sym_LBRACK,
    ACTIONS(236), 6,
      sym_identifier,
      anon_sym_interface,
      anon_sym_enum,
      anon_sym_dictionary,
      anon_sym_namespace,
      anon_sym_typedef,
  [2456] = 2,
    ACTIONS(238), 3,
      ts_builtin_sym_end,
      sym_comment,
      anon_sym_LBRACK,
    ACTIONS(240), 6,
      sym_identifier,
      anon_sym_interface,
      anon_sym_enum,
      anon_sym_dictionary,
      anon_sym_namespace,
      anon_sym_typedef,
  [2470] = 2,
    ACTIONS(242), 3,
      ts_builtin_sym_end,
      sym_comment,
      anon_sym_LBRACK,
    ACTIONS(244), 6,
      sym_identifier,
      anon_sym_interface,
      anon_sym_enum,
      anon_sym_dictionary,
      anon_sym_namespace,
      anon_sym_typedef,
  [2484] = 2,
    ACTIONS(246), 3,
      ts_builtin_sym_end,
      sym_comment,
      anon_sym_LBRACK,
    ACTIONS(248), 6,
      sym_identifier,
      anon_sym_interface,
      anon_sym_enum,
      anon_sym_dictionary,
      anon_sym_namespace,
      anon_sym_typedef,
  [2498] = 2,
    ACTIONS(250), 3,
      ts_builtin_sym_end,
      sym_comment,
      anon_sym_LBRACK,
    ACTIONS(252), 6,
      sym_identifier,
      anon_sym_interface,
      anon_sym_enum,
      anon_sym_dictionary,
      anon_sym_namespace,
      anon_sym_typedef,
  [2512] = 2,
    ACTIONS(254), 3,
      ts_builtin_sym_end,
      sym_comment,
      anon_sym_LBRACK,
    ACTIONS(256), 6,
      sym_identifier,
      anon_sym_interface,
      anon_sym_enum,
      anon_sym_dictionary,
      anon_sym_namespace,
      anon_sym_typedef,
  [2526] = 2,
    ACTIONS(258), 3,
      ts_builtin_sym_end,
      sym_comment,
      anon_sym_LBRACK,
    ACTIONS(260), 6,
      sym_identifier,
      anon_sym_interface,
      anon_sym_enum,
      anon_sym_dictionary,
      anon_sym_namespace,
      anon_sym_typedef,
  [2540] = 2,
    ACTIONS(262), 3,
      ts_builtin_sym_end,
      sym_comment,
      anon_sym_LBRACK,
    ACTIONS(264), 6,
      sym_identifier,
      anon_sym_interface,
      anon_sym_enum,
      anon_sym_dictionary,
      anon_sym_namespace,
      anon_sym_typedef,
  [2554] = 2,
    ACTIONS(266), 3,
      ts_builtin_sym_end,
      sym_comment,
      anon_sym_LBRACK,
    ACTIONS(268), 6,
      sym_identifier,
      anon_sym_interface,
      anon_sym_enum,
      anon_sym_dictionary,
      anon_sym_namespace,
      anon_sym_typedef,
  [2568] = 2,
    ACTIONS(270), 3,
      ts_builtin_sym_end,
      sym_comment,
      anon_sym_LBRACK,
    ACTIONS(272), 6,
      sym_identifier,
      anon_sym_interface,
      anon_sym_enum,
      anon_sym_dictionary,
      anon_sym_namespace,
      anon_sym_typedef,
  [2582] = 2,
    ACTIONS(274), 3,
      ts_builtin_sym_end,
      sym_comment,
      anon_sym_LBRACK,
    ACTIONS(276), 6,
      sym_identifier,
      anon_sym_interface,
      anon_sym_enum,
      anon_sym_dictionary,
      anon_sym_namespace,
      anon_sym_typedef,
  [2596] = 2,
    ACTIONS(278), 3,
      ts_builtin_sym_end,
      sym_comment,
      anon_sym_LBRACK,
    ACTIONS(280), 6,
      sym_identifier,
      anon_sym_interface,
      anon_sym_enum,
      anon_sym_dictionary,
      anon_sym_namespace,
      anon_sym_typedef,
  [2610] = 2,
    ACTIONS(282), 3,
      ts_builtin_sym_end,
      sym_comment,
      anon_sym_LBRACK,
    ACTIONS(284), 6,
      sym_identifier,
      anon_sym_interface,
      anon_sym_enum,
      anon_sym_dictionary,
      anon_sym_namespace,
      anon_sym_typedef,
  [2624] = 2,
    ACTIONS(286), 3,
      ts_builtin_sym_end,
      sym_comment,
      anon_sym_LBRACK,
    ACTIONS(288), 6,
      sym_identifier,
      anon_sym_interface,
      anon_sym_enum,
      anon_sym_dictionary,
      anon_sym_namespace,
      anon_sym_typedef,
  [2638] = 4,
    ACTIONS(292), 1,
      sym_number_literal,
    ACTIONS(224), 2,
      anon_sym_true,
      anon_sym_false,
    STATE(162), 2,
      sym_boolean_literal,
      sym__literal,
    ACTIONS(290), 4,
      sym_string_literal,
      sym_hex_literal,
      sym_object_literal,
      sym_array_literal,
  [2656] = 2,
    ACTIONS(294), 3,
      ts_builtin_sym_end,
      sym_comment,
      anon_sym_LBRACK,
    ACTIONS(296), 6,
      sym_identifier,
      anon_sym_interface,
      anon_sym_enum,
      anon_sym_dictionary,
      anon_sym_namespace,
      anon_sym_typedef,
  [2670] = 2,
    ACTIONS(298), 3,
      ts_builtin_sym_end,
      sym_comment,
      anon_sym_LBRACK,
    ACTIONS(300), 6,
      sym_identifier,
      anon_sym_interface,
      anon_sym_enum,
      anon_sym_dictionary,
      anon_sym_namespace,
      anon_sym_typedef,
  [2684] = 2,
    ACTIONS(302), 3,
      ts_builtin_sym_end,
      sym_comment,
      anon_sym_LBRACK,
    ACTIONS(304), 6,
      sym_identifier,
      anon_sym_interface,
      anon_sym_enum,
      anon_sym_dictionary,
      anon_sym_namespace,
      anon_sym_typedef,
  [2698] = 2,
    ACTIONS(306), 3,
      ts_builtin_sym_end,
      sym_comment,
      anon_sym_LBRACK,
    ACTIONS(308), 6,
      sym_identifier,
      anon_sym_interface,
      anon_sym_enum,
      anon_sym_dictionary,
      anon_sym_namespace,
      anon_sym_typedef,
  [2712] = 2,
    ACTIONS(310), 3,
      ts_builtin_sym_end,
      sym_comment,
      anon_sym_LBRACK,
    ACTIONS(312), 6,
      sym_identifier,
      anon_sym_interface,
      anon_sym_enum,
      anon_sym_dictionary,
      anon_sym_namespace,
      anon_sym_typedef,
  [2726] = 2,
    ACTIONS(314), 3,
      ts_builtin_sym_end,
      sym_comment,
      anon_sym_LBRACK,
    ACTIONS(316), 6,
      sym_identifier,
      anon_sym_interface,
      anon_sym_enum,
      anon_sym_dictionary,
      anon_sym_namespace,
      anon_sym_typedef,
  [2740] = 2,
    ACTIONS(318), 3,
      ts_builtin_sym_end,
      sym_comment,
      anon_sym_LBRACK,
    ACTIONS(320), 6,
      sym_identifier,
      anon_sym_interface,
      anon_sym_enum,
      anon_sym_dictionary,
      anon_sym_namespace,
      anon_sym_typedef,
  [2754] = 2,
    ACTIONS(322), 3,
      ts_builtin_sym_end,
      sym_comment,
      anon_sym_LBRACK,
    ACTIONS(324), 6,
      sym_identifier,
      anon_sym_interface,
      anon_sym_enum,
      anon_sym_dictionary,
      anon_sym_namespace,
      anon_sym_typedef,
  [2768] = 2,
    ACTIONS(326), 3,
      ts_builtin_sym_end,
      sym_comment,
      anon_sym_LBRACK,
    ACTIONS(328), 6,
      sym_identifier,
      anon_sym_interface,
      anon_sym_enum,
      anon_sym_dictionary,
      anon_sym_namespace,
      anon_sym_typedef,
  [2782] = 2,
    ACTIONS(330), 3,
      ts_builtin_sym_end,
      sym_comment,
      anon_sym_LBRACK,
    ACTIONS(332), 6,
      sym_identifier,
      anon_sym_interface,
      anon_sym_enum,
      anon_sym_dictionary,
      anon_sym_namespace,
      anon_sym_typedef,
  [2796] = 2,
    ACTIONS(334), 3,
      ts_builtin_sym_end,
      sym_comment,
      anon_sym_LBRACK,
    ACTIONS(336), 6,
      sym_identifier,
      anon_sym_interface,
      anon_sym_enum,
      anon_sym_dictionary,
      anon_sym_namespace,
      anon_sym_typedef,
  [2810] = 2,
    ACTIONS(338), 3,
      ts_builtin_sym_end,
      sym_comment,
      anon_sym_LBRACK,
    ACTIONS(340), 6,
      sym_identifier,
      anon_sym_interface,
      anon_sym_enum,
      anon_sym_dictionary,
      anon_sym_namespace,
      anon_sym_typedef,
  [2824] = 2,
    ACTIONS(342), 3,
      ts_builtin_sym_end,
      sym_comment,
      anon_sym_LBRACK,
    ACTIONS(344), 6,
      sym_identifier,
      anon_sym_interface,
      anon_sym_enum,
      anon_sym_dictionary,
      anon_sym_namespace,
      anon_sym_typedef,
  [2838] = 4,
    ACTIONS(348), 1,
      anon_sym_LT,
    ACTIONS(350), 1,
      anon_sym_QMARK,
    STATE(116), 1,
      sym_type_parameter_list,
    ACTIONS(346), 3,
      sym_identifier,
      anon_sym_COMMA,
      anon_sym_GT,
  [2853] = 5,
    ACTIONS(352), 1,
      anon_sym_SEMI,
    ACTIONS(354), 1,
      anon_sym_COLON,
    ACTIONS(356), 1,
      anon_sym_LBRACE,
    STATE(106), 1,
      sym__inherits,
    STATE(112), 2,
      sym_dictionary_decl_list,
      aux_sym_dictionary_declaration_repeat1,
  [2870] = 4,
    ACTIONS(348), 1,
      anon_sym_LT,
    ACTIONS(360), 1,
      anon_sym_QMARK,
    STATE(116), 1,
      sym_type_parameter_list,
    ACTIONS(358), 3,
      sym_identifier,
      anon_sym_COMMA,
      anon_sym_GT,
  [2885] = 5,
    ACTIONS(362), 1,
      sym_comment,
    ACTIONS(364), 1,
      anon_sym_COMMA,
    ACTIONS(366), 1,
      sym_string_literal,
    ACTIONS(368), 1,
      anon_sym_RBRACE,
    STATE(101), 1,
      aux_sym_enum_declaration_repeat1,
  [2901] = 5,
    ACTIONS(366), 1,
      sym_string_literal,
    ACTIONS(370), 1,
      sym_comment,
    ACTIONS(372), 1,
      anon_sym_COMMA,
    ACTIONS(374), 1,
      anon_sym_RBRACE,
    STATE(98), 1,
      aux_sym_enum_declaration_repeat1,
  [2917] = 5,
    ACTIONS(376), 1,
      sym_comment,
    ACTIONS(378), 1,
      anon_sym_RBRACE,
    ACTIONS(380), 1,
      anon_sym_const,
    STATE(103), 1,
      aux_sym_namespace_declaration_repeat1,
    STATE(135), 1,
      sym__namespace_member,
  [2933] = 4,
    ACTIONS(382), 1,
      sym_comment,
    ACTIONS(387), 1,
      sym_string_literal,
    STATE(101), 1,
      aux_sym_enum_declaration_repeat1,
    ACTIONS(385), 2,
      anon_sym_COMMA,
      anon_sym_RBRACE,
  [2947] = 5,
    ACTIONS(380), 1,
      anon_sym_const,
    ACTIONS(390), 1,
      sym_comment,
    ACTIONS(392), 1,
      anon_sym_RBRACE,
    STATE(105), 1,
      aux_sym_namespace_declaration_repeat1,
    STATE(135), 1,
      sym__namespace_member,
  [2963] = 5,
    ACTIONS(380), 1,
      anon_sym_const,
    ACTIONS(394), 1,
      sym_comment,
    ACTIONS(396), 1,
      anon_sym_RBRACE,
    STATE(104), 1,
      aux_sym_namespace_declaration_repeat1,
    STATE(135), 1,
      sym__namespace_member,
  [2979] = 5,
    ACTIONS(398), 1,
      sym_comment,
    ACTIONS(401), 1,
      anon_sym_RBRACE,
    ACTIONS(403), 1,
      anon_sym_const,
    STATE(104), 1,
      aux_sym_namespace_declaration_repeat1,
    STATE(135), 1,
      sym__namespace_member,
  [2995] = 5,
    ACTIONS(380), 1,
      anon_sym_const,
    ACTIONS(394), 1,
      sym_comment,
    ACTIONS(406), 1,
      anon_sym_RBRACE,
    STATE(104), 1,
      aux_sym_namespace_declaration_repeat1,
    STATE(135), 1,
      sym__namespace_member,
  [3011] = 3,
    ACTIONS(356), 1,
      anon_sym_LBRACE,
    ACTIONS(408), 1,
      anon_sym_SEMI,
    STATE(111), 2,
      sym_dictionary_decl_list,
      aux_sym_dictionary_declaration_repeat1,
  [3022] = 2,
    ACTIONS(350), 1,
      anon_sym_QMARK,
    ACTIONS(346), 3,
      sym_identifier,
      anon_sym_COMMA,
      anon_sym_GT,
  [3031] = 1,
    ACTIONS(410), 4,
      sym_identifier,
      anon_sym_COMMA,
      anon_sym_GT,
      anon_sym_QMARK,
  [3038] = 3,
    ACTIONS(412), 1,
      anon_sym_SEMI,
    ACTIONS(414), 1,
      anon_sym_LBRACE,
    STATE(109), 2,
      sym_dictionary_decl_list,
      aux_sym_dictionary_declaration_repeat1,
  [3049] = 1,
    ACTIONS(417), 4,
      sym_identifier,
      anon_sym_COMMA,
      anon_sym_GT,
      anon_sym_QMARK,
  [3056] = 3,
    ACTIONS(356), 1,
      anon_sym_LBRACE,
    ACTIONS(419), 1,
      anon_sym_SEMI,
    STATE(109), 2,
      sym_dictionary_decl_list,
      aux_sym_dictionary_declaration_repeat1,
  [3067] = 3,
    ACTIONS(356), 1,
      anon_sym_LBRACE,
    ACTIONS(421), 1,
      anon_sym_SEMI,
    STATE(109), 2,
      sym_dictionary_decl_list,
      aux_sym_dictionary_declaration_repeat1,
  [3078] = 3,
    ACTIONS(423), 1,
      sym_identifier,
    ACTIONS(425), 1,
      anon_sym_LPAREN,
    STATE(164), 2,
      sym__attribute_value,
      sym_attribute_value_set,
  [3089] = 3,
    ACTIONS(429), 1,
      anon_sym_EQ,
    STATE(160), 1,
      sym__parameter_initializer,
    ACTIONS(427), 2,
      anon_sym_COMMA,
      anon_sym_RPAREN,
  [3100] = 4,
    ACTIONS(431), 1,
      sym_identifier,
    ACTIONS(433), 1,
      anon_sym_RBRACK,
    STATE(126), 1,
      sym_attribute,
    STATE(159), 1,
      sym__attribute_with_value,
  [3113] = 1,
    ACTIONS(435), 4,
      sym_identifier,
      anon_sym_COMMA,
      anon_sym_GT,
      anon_sym_QMARK,
  [3120] = 1,
    ACTIONS(437), 4,
      sym_identifier,
      anon_sym_COMMA,
      anon_sym_GT,
      anon_sym_QMARK,
  [3127] = 2,
    ACTIONS(360), 1,
      anon_sym_QMARK,
    ACTIONS(358), 3,
      sym_identifier,
      anon_sym_COMMA,
      anon_sym_GT,
  [3136] = 4,
    ACTIONS(431), 1,
      sym_identifier,
    ACTIONS(439), 1,
      anon_sym_RBRACK,
    STATE(131), 1,
      sym_attribute,
    STATE(159), 1,
      sym__attribute_with_value,
  [3149] = 4,
    ACTIONS(431), 1,
      sym_identifier,
    ACTIONS(441), 1,
      anon_sym_RBRACK,
    STATE(138), 1,
      sym_attribute,
    STATE(159), 1,
      sym__attribute_with_value,
  [3162] = 1,
    ACTIONS(385), 4,
      sym_comment,
      anon_sym_COMMA,
      sym_string_literal,
      anon_sym_RBRACE,
  [3169] = 3,
    ACTIONS(429), 1,
      anon_sym_EQ,
    STATE(156), 1,
      sym__parameter_initializer,
    ACTIONS(443), 2,
      anon_sym_COMMA,
      anon_sym_RPAREN,
  [3180] = 3,
    ACTIONS(445), 1,
      anon_sym_COMMA,
    ACTIONS(447), 1,
      anon_sym_RPAREN,
    STATE(150), 1,
      aux_sym_operation_declaration_repeat1,
  [3190] = 3,
    ACTIONS(449), 1,
      anon_sym_COMMA,
    ACTIONS(451), 1,
      anon_sym_RBRACK,
    STATE(129), 1,
      aux_sym_attributes_repeat1,
  [3200] = 3,
    ACTIONS(449), 1,
      anon_sym_COMMA,
    ACTIONS(453), 1,
      anon_sym_RBRACK,
    STATE(129), 1,
      aux_sym_attributes_repeat1,
  [3210] = 3,
    ACTIONS(449), 1,
      anon_sym_COMMA,
    ACTIONS(455), 1,
      anon_sym_RBRACK,
    STATE(125), 1,
      aux_sym_attributes_repeat1,
  [3220] = 3,
    ACTIONS(457), 1,
      anon_sym_SEMI,
    ACTIONS(459), 1,
      anon_sym_EQ,
    STATE(200), 1,
      sym__dict_field_initializer,
  [3230] = 3,
    ACTIONS(461), 1,
      anon_sym_COMMA,
    ACTIONS(464), 1,
      anon_sym_GT,
    STATE(128), 1,
      aux_sym_type_parameter_list_repeat1,
  [3240] = 3,
    ACTIONS(466), 1,
      anon_sym_COMMA,
    ACTIONS(469), 1,
      anon_sym_RBRACK,
    STATE(129), 1,
      aux_sym_attributes_repeat1,
  [3250] = 3,
    ACTIONS(449), 1,
      anon_sym_COMMA,
    ACTIONS(471), 1,
      anon_sym_RBRACK,
    STATE(129), 1,
      aux_sym_attributes_repeat1,
  [3260] = 3,
    ACTIONS(449), 1,
      anon_sym_COMMA,
    ACTIONS(473), 1,
      anon_sym_RBRACK,
    STATE(130), 1,
      aux_sym_attributes_repeat1,
  [3270] = 3,
    ACTIONS(459), 1,
      anon_sym_EQ,
    ACTIONS(475), 1,
      anon_sym_SEMI,
    STATE(202), 1,
      sym__dict_field_initializer,
  [3280] = 2,
    ACTIONS(479), 1,
      anon_sym_EQ,
    ACTIONS(477), 2,
      anon_sym_COMMA,
      anon_sym_RBRACK,
  [3288] = 1,
    ACTIONS(481), 3,
      anon_sym_COMMA,
      anon_sym_SEMI,
      anon_sym_RPAREN,
  [3294] = 1,
    ACTIONS(483), 3,
      sym_comment,
      anon_sym_RBRACE,
      anon_sym_const,
  [3300] = 3,
    ACTIONS(485), 1,
      anon_sym_COMMA,
    ACTIONS(487), 1,
      anon_sym_GT,
    STATE(137), 1,
      aux_sym_type_parameter_list_repeat1,
  [3310] = 3,
    ACTIONS(485), 1,
      anon_sym_COMMA,
    ACTIONS(489), 1,
      anon_sym_GT,
    STATE(128), 1,
      aux_sym_type_parameter_list_repeat1,
  [3320] = 3,
    ACTIONS(449), 1,
      anon_sym_COMMA,
    ACTIONS(491), 1,
      anon_sym_RBRACK,
    STATE(124), 1,
      aux_sym_attributes_repeat1,
  [3330] = 1,
    ACTIONS(493), 3,
      sym_comment,
      anon_sym_RBRACE,
      anon_sym_const,
  [3336] = 1,
    ACTIONS(495), 3,
      sym_identifier,
      anon_sym_COMMA,
      anon_sym_GT,
  [3342] = 3,
    ACTIONS(497), 1,
      anon_sym_COMMA,
    ACTIONS(500), 1,
      anon_sym_RPAREN,
    STATE(141), 1,
      aux_sym_operation_declaration_repeat1,
  [3352] = 3,
    ACTIONS(502), 1,
      anon_sym_COLON,
    ACTIONS(504), 1,
      anon_sym_LBRACE,
    STATE(218), 1,
      sym_implements,
  [3362] = 3,
    ACTIONS(502), 1,
      anon_sym_COLON,
    ACTIONS(506), 1,
      anon_sym_LBRACE,
    STATE(214), 1,
      sym_implements,
  [3372] = 1,
    ACTIONS(508), 3,
      sym_identifier,
      anon_sym_COMMA,
      anon_sym_GT,
  [3378] = 3,
    ACTIONS(502), 1,
      anon_sym_COLON,
    ACTIONS(510), 1,
      anon_sym_LBRACE,
    STATE(181), 1,
      sym_implements,
  [3388] = 3,
    ACTIONS(502), 1,
      anon_sym_COLON,
    ACTIONS(512), 1,
      anon_sym_LBRACE,
    STATE(240), 1,
      sym_implements,
  [3398] = 3,
    ACTIONS(514), 1,
      anon_sym_COMMA,
    ACTIONS(516), 1,
      anon_sym_RPAREN,
    STATE(151), 1,
      aux_sym_attribute_value_set_repeat1,
  [3408] = 3,
    ACTIONS(431), 1,
      sym_identifier,
    STATE(159), 1,
      sym__attribute_with_value,
    STATE(166), 1,
      sym_attribute,
  [3418] = 3,
    ACTIONS(514), 1,
      anon_sym_COMMA,
    ACTIONS(518), 1,
      anon_sym_RPAREN,
    STATE(147), 1,
      aux_sym_attribute_value_set_repeat1,
  [3428] = 3,
    ACTIONS(445), 1,
      anon_sym_COMMA,
    ACTIONS(520), 1,
      anon_sym_RPAREN,
    STATE(141), 1,
      aux_sym_operation_declaration_repeat1,
  [3438] = 3,
    ACTIONS(522), 1,
      anon_sym_COMMA,
    ACTIONS(525), 1,
      anon_sym_RPAREN,
    STATE(151), 1,
      aux_sym_attribute_value_set_repeat1,
  [3448] = 1,
    ACTIONS(527), 2,
      anon_sym_COMMA,
      anon_sym_RBRACK,
  [3453] = 1,
    ACTIONS(214), 2,
      anon_sym_interface,
      anon_sym_namespace,
  [3458] = 1,
    ACTIONS(529), 2,
      anon_sym_COMMA,
      anon_sym_RBRACK,
  [3463] = 2,
    ACTIONS(531), 1,
      sym_identifier,
    ACTIONS(533), 1,
      anon_sym_mixin,
  [3470] = 1,
    ACTIONS(535), 2,
      anon_sym_COMMA,
      anon_sym_RPAREN,
  [3475] = 1,
    ACTIONS(500), 2,
      anon_sym_COMMA,
      anon_sym_RPAREN,
  [3480] = 2,
    ACTIONS(537), 1,
      sym_number_literal,
    ACTIONS(539), 1,
      sym_hex_literal,
  [3487] = 1,
    ACTIONS(541), 2,
      anon_sym_COMMA,
      anon_sym_RBRACK,
  [3492] = 1,
    ACTIONS(543), 2,
      anon_sym_COMMA,
      anon_sym_RPAREN,
  [3497] = 2,
    ACTIONS(545), 1,
      sym_identifier,
    ACTIONS(547), 1,
      anon_sym_RPAREN,
  [3504] = 1,
    ACTIONS(549), 2,
      anon_sym_COMMA,
      anon_sym_RPAREN,
  [3509] = 1,
    ACTIONS(210), 2,
      anon_sym_interface,
      anon_sym_namespace,
  [3514] = 1,
    ACTIONS(551), 2,
      anon_sym_COMMA,
      anon_sym_RBRACK,
  [3519] = 2,
    ACTIONS(553), 1,
      anon_sym_interface,
    ACTIONS(555), 1,
      anon_sym_namespace,
  [3526] = 1,
    ACTIONS(469), 2,
      anon_sym_COMMA,
      anon_sym_RBRACK,
  [3531] = 1,
    ACTIONS(557), 2,
      anon_sym_SEMI,
      anon_sym_LBRACE,
  [3536] = 1,
    ACTIONS(206), 2,
      anon_sym_interface,
      anon_sym_namespace,
  [3541] = 2,
    ACTIONS(559), 1,
      sym_identifier,
    ACTIONS(561), 1,
      anon_sym_mixin,
  [3548] = 1,
    ACTIONS(563), 2,
      anon_sym_SEMI,
      anon_sym_LBRACE,
  [3553] = 1,
    ACTIONS(464), 2,
      anon_sym_COMMA,
      anon_sym_GT,
  [3558] = 2,
    ACTIONS(565), 1,
      anon_sym_setlike,
    ACTIONS(567), 1,
      anon_sym_attribute,
  [3565] = 1,
    ACTIONS(569), 2,
      anon_sym_SEMI,
      anon_sym_LBRACE,
  [3570] = 1,
    ACTIONS(525), 2,
      anon_sym_COMMA,
      anon_sym_RPAREN,
  [3575] = 1,
    ACTIONS(571), 2,
      anon_sym_COMMA,
      anon_sym_RBRACK,
  [3580] = 1,
    ACTIONS(573), 1,
      anon_sym_SEMI,
  [3584] = 1,
    ACTIONS(575), 1,
      anon_sym_SEMI,
  [3588] = 1,
    ACTIONS(577), 1,
      anon_sym_COMMA,
  [3592] = 1,
    ACTIONS(579), 1,
      anon_sym_RBRACE,
  [3596] = 1,
    ACTIONS(581), 1,
      anon_sym_SEMI,
  [3600] = 1,
    ACTIONS(583), 1,
      anon_sym_LBRACE,
  [3604] = 1,
    ACTIONS(585), 1,
      anon_sym_SEMI,
  [3608] = 1,
    ACTIONS(587), 1,
      anon_sym_SEMI,
  [3612] = 1,
    ACTIONS(589), 1,
      sym_identifier,
  [3616] = 1,
    ACTIONS(591), 1,
      anon_sym_SEMI,
  [3620] = 1,
    ACTIONS(593), 1,
      anon_sym_GT,
  [3624] = 1,
    ACTIONS(595), 1,
      anon_sym_SEMI,
  [3628] = 1,
    ACTIONS(597), 1,
      anon_sym_SEMI,
  [3632] = 1,
    ACTIONS(599), 1,
      anon_sym_SEMI,
  [3636] = 1,
    ACTIONS(601), 1,
      anon_sym_RBRACE,
  [3640] = 1,
    ACTIONS(603), 1,
      anon_sym_LT,
  [3644] = 1,
    ACTIONS(605), 1,
      sym_identifier,
  [3648] = 1,
    ACTIONS(607), 1,
      anon_sym_SEMI,
  [3652] = 1,
    ACTIONS(609), 1,
      sym_identifier,
  [3656] = 1,
    ACTIONS(611), 1,
      anon_sym_SEMI,
  [3660] = 1,
    ACTIONS(613), 1,
      anon_sym_LBRACE,
  [3664] = 1,
    ACTIONS(615), 1,
      anon_sym_SEMI,
  [3668] = 1,
    ACTIONS(617), 1,
      anon_sym_SEMI,
  [3672] = 1,
    ACTIONS(619), 1,
      anon_sym_EQ,
  [3676] = 1,
    ACTIONS(621), 1,
      anon_sym_SEMI,
  [3680] = 1,
    ACTIONS(623), 1,
      sym_identifier,
  [3684] = 1,
    ACTIONS(625), 1,
      anon_sym_SEMI,
  [3688] = 1,
    ACTIONS(627), 1,
      anon_sym_SEMI,
  [3692] = 1,
    ACTIONS(629), 1,
      anon_sym_SEMI,
  [3696] = 1,
    ACTIONS(631), 1,
      anon_sym_SEMI,
  [3700] = 1,
    ACTIONS(633), 1,
      anon_sym_SEMI,
  [3704] = 1,
    ACTIONS(635), 1,
      anon_sym_LBRACE,
  [3708] = 1,
    ACTIONS(637), 1,
      anon_sym_SEMI,
  [3712] = 1,
    ACTIONS(639), 1,
      sym_identifier,
  [3716] = 1,
    ACTIONS(641), 1,
      anon_sym_SEMI,
  [3720] = 1,
    ACTIONS(643), 1,
      anon_sym_SEMI,
  [3724] = 1,
    ACTIONS(645), 1,
      anon_sym_SEMI,
  [3728] = 1,
    ACTIONS(647), 1,
      anon_sym_SEMI,
  [3732] = 1,
    ACTIONS(649), 1,
      anon_sym_LBRACE,
  [3736] = 1,
    ACTIONS(651), 1,
      anon_sym_SEMI,
  [3740] = 1,
    ACTIONS(653), 1,
      sym_identifier,
  [3744] = 1,
    ACTIONS(655), 1,
      anon_sym_SEMI,
  [3748] = 1,
    ACTIONS(657), 1,
      anon_sym_LBRACE,
  [3752] = 1,
    ACTIONS(659), 1,
      sym_identifier,
  [3756] = 1,
    ACTIONS(661), 1,
      sym_identifier,
  [3760] = 1,
    ACTIONS(663), 1,
      sym_identifier,
  [3764] = 1,
    ACTIONS(665), 1,
      anon_sym_SEMI,
  [3768] = 1,
    ACTIONS(667), 1,
      anon_sym_SEMI,
  [3772] = 1,
    ACTIONS(669), 1,
      anon_sym_SEMI,
  [3776] = 1,
    ACTIONS(671), 1,
      anon_sym_GT,
  [3780] = 1,
    ACTIONS(673), 1,
      sym_identifier,
  [3784] = 1,
    ACTIONS(675), 1,
      anon_sym_SEMI,
  [3788] = 1,
    ACTIONS(677), 1,
      anon_sym_SEMI,
  [3792] = 1,
    ACTIONS(679), 1,
      sym_identifier,
  [3796] = 1,
    ACTIONS(681), 1,
      anon_sym_LT,
  [3800] = 1,
    ACTIONS(683), 1,
      anon_sym_SEMI,
  [3804] = 1,
    ACTIONS(685), 1,
      sym_identifier,
  [3808] = 1,
    ACTIONS(687), 1,
      anon_sym_LBRACE,
  [3812] = 1,
    ACTIONS(689), 1,
      anon_sym_LBRACE,
  [3816] = 1,
    ACTIONS(691), 1,
      sym_identifier,
  [3820] = 1,
    ACTIONS(693), 1,
      sym_identifier,
  [3824] = 1,
    ACTIONS(695), 1,
      sym_identifier,
  [3828] = 1,
    ACTIONS(697), 1,
      anon_sym_SEMI,
  [3832] = 1,
    ACTIONS(699), 1,
      anon_sym_SEMI,
  [3836] = 1,
    ACTIONS(701), 1,
      anon_sym_LBRACE,
  [3840] = 1,
    ACTIONS(703), 1,
      anon_sym_LPAREN,
  [3844] = 1,
    ACTIONS(567), 1,
      anon_sym_attribute,
  [3848] = 1,
    ACTIONS(705), 1,
      anon_sym_SEMI,
  [3852] = 1,
    ACTIONS(707), 1,
      anon_sym_SEMI,
  [3856] = 1,
    ACTIONS(709), 1,
      anon_sym_attribute,
  [3860] = 1,
    ACTIONS(711), 1,
      anon_sym_SEMI,
  [3864] = 1,
    ACTIONS(713), 1,
      anon_sym_SEMI,
  [3868] = 1,
    ACTIONS(715), 1,
      sym_identifier,
  [3872] = 1,
    ACTIONS(717), 1,
      anon_sym_SEMI,
  [3876] = 1,
    ACTIONS(719), 1,
      ts_builtin_sym_end,
  [3880] = 1,
    ACTIONS(721), 1,
      sym_identifier,
  [3884] = 1,
    ACTIONS(723), 1,
      sym_identifier,
  [3888] = 1,
    ACTIONS(725), 1,
      sym_identifier,
  [3892] = 1,
    ACTIONS(727), 1,
      sym_identifier,
  [3896] = 1,
    ACTIONS(729), 1,
      anon_sym_SEMI,
  [3900] = 1,
    ACTIONS(731), 1,
      anon_sym_SEMI,
  [3904] = 1,
    ACTIONS(733), 1,
      anon_sym_includes,
  [3908] = 1,
    ACTIONS(735), 1,
      sym_identifier,
};

static const uint32_t ts_small_parse_table_map[] = {
  [SMALL_STATE(2)] = 0,
  [SMALL_STATE(3)] = 65,
  [SMALL_STATE(4)] = 130,
  [SMALL_STATE(5)] = 195,
  [SMALL_STATE(6)] = 260,
  [SMALL_STATE(7)] = 325,
  [SMALL_STATE(8)] = 390,
  [SMALL_STATE(9)] = 455,
  [SMALL_STATE(10)] = 520,
  [SMALL_STATE(11)] = 579,
  [SMALL_STATE(12)] = 638,
  [SMALL_STATE(13)] = 697,
  [SMALL_STATE(14)] = 756,
  [SMALL_STATE(15)] = 815,
  [SMALL_STATE(16)] = 874,
  [SMALL_STATE(17)] = 933,
  [SMALL_STATE(18)] = 992,
  [SMALL_STATE(19)] = 1048,
  [SMALL_STATE(20)] = 1104,
  [SMALL_STATE(21)] = 1154,
  [SMALL_STATE(22)] = 1204,
  [SMALL_STATE(23)] = 1254,
  [SMALL_STATE(24)] = 1297,
  [SMALL_STATE(25)] = 1337,
  [SMALL_STATE(26)] = 1371,
  [SMALL_STATE(27)] = 1405,
  [SMALL_STATE(28)] = 1439,
  [SMALL_STATE(29)] = 1473,
  [SMALL_STATE(30)] = 1507,
  [SMALL_STATE(31)] = 1541,
  [SMALL_STATE(32)] = 1565,
  [SMALL_STATE(33)] = 1589,
  [SMALL_STATE(34)] = 1613,
  [SMALL_STATE(35)] = 1647,
  [SMALL_STATE(36)] = 1671,
  [SMALL_STATE(37)] = 1705,
  [SMALL_STATE(38)] = 1729,
  [SMALL_STATE(39)] = 1753,
  [SMALL_STATE(40)] = 1777,
  [SMALL_STATE(41)] = 1811,
  [SMALL_STATE(42)] = 1845,
  [SMALL_STATE(43)] = 1869,
  [SMALL_STATE(44)] = 1893,
  [SMALL_STATE(45)] = 1927,
  [SMALL_STATE(46)] = 1951,
  [SMALL_STATE(47)] = 1985,
  [SMALL_STATE(48)] = 2009,
  [SMALL_STATE(49)] = 2032,
  [SMALL_STATE(50)] = 2073,
  [SMALL_STATE(51)] = 2096,
  [SMALL_STATE(52)] = 2119,
  [SMALL_STATE(53)] = 2142,
  [SMALL_STATE(54)] = 2173,
  [SMALL_STATE(55)] = 2214,
  [SMALL_STATE(56)] = 2237,
  [SMALL_STATE(57)] = 2258,
  [SMALL_STATE(58)] = 2279,
  [SMALL_STATE(59)] = 2300,
  [SMALL_STATE(60)] = 2325,
  [SMALL_STATE(61)] = 2344,
  [SMALL_STATE(62)] = 2363,
  [SMALL_STATE(63)] = 2382,
  [SMALL_STATE(64)] = 2396,
  [SMALL_STATE(65)] = 2414,
  [SMALL_STATE(66)] = 2428,
  [SMALL_STATE(67)] = 2442,
  [SMALL_STATE(68)] = 2456,
  [SMALL_STATE(69)] = 2470,
  [SMALL_STATE(70)] = 2484,
  [SMALL_STATE(71)] = 2498,
  [SMALL_STATE(72)] = 2512,
  [SMALL_STATE(73)] = 2526,
  [SMALL_STATE(74)] = 2540,
  [SMALL_STATE(75)] = 2554,
  [SMALL_STATE(76)] = 2568,
  [SMALL_STATE(77)] = 2582,
  [SMALL_STATE(78)] = 2596,
  [SMALL_STATE(79)] = 2610,
  [SMALL_STATE(80)] = 2624,
  [SMALL_STATE(81)] = 2638,
  [SMALL_STATE(82)] = 2656,
  [SMALL_STATE(83)] = 2670,
  [SMALL_STATE(84)] = 2684,
  [SMALL_STATE(85)] = 2698,
  [SMALL_STATE(86)] = 2712,
  [SMALL_STATE(87)] = 2726,
  [SMALL_STATE(88)] = 2740,
  [SMALL_STATE(89)] = 2754,
  [SMALL_STATE(90)] = 2768,
  [SMALL_STATE(91)] = 2782,
  [SMALL_STATE(92)] = 2796,
  [SMALL_STATE(93)] = 2810,
  [SMALL_STATE(94)] = 2824,
  [SMALL_STATE(95)] = 2838,
  [SMALL_STATE(96)] = 2853,
  [SMALL_STATE(97)] = 2870,
  [SMALL_STATE(98)] = 2885,
  [SMALL_STATE(99)] = 2901,
  [SMALL_STATE(100)] = 2917,
  [SMALL_STATE(101)] = 2933,
  [SMALL_STATE(102)] = 2947,
  [SMALL_STATE(103)] = 2963,
  [SMALL_STATE(104)] = 2979,
  [SMALL_STATE(105)] = 2995,
  [SMALL_STATE(106)] = 3011,
  [SMALL_STATE(107)] = 3022,
  [SMALL_STATE(108)] = 3031,
  [SMALL_STATE(109)] = 3038,
  [SMALL_STATE(110)] = 3049,
  [SMALL_STATE(111)] = 3056,
  [SMALL_STATE(112)] = 3067,
  [SMALL_STATE(113)] = 3078,
  [SMALL_STATE(114)] = 3089,
  [SMALL_STATE(115)] = 3100,
  [SMALL_STATE(116)] = 3113,
  [SMALL_STATE(117)] = 3120,
  [SMALL_STATE(118)] = 3127,
  [SMALL_STATE(119)] = 3136,
  [SMALL_STATE(120)] = 3149,
  [SMALL_STATE(121)] = 3162,
  [SMALL_STATE(122)] = 3169,
  [SMALL_STATE(123)] = 3180,
  [SMALL_STATE(124)] = 3190,
  [SMALL_STATE(125)] = 3200,
  [SMALL_STATE(126)] = 3210,
  [SMALL_STATE(127)] = 3220,
  [SMALL_STATE(128)] = 3230,
  [SMALL_STATE(129)] = 3240,
  [SMALL_STATE(130)] = 3250,
  [SMALL_STATE(131)] = 3260,
  [SMALL_STATE(132)] = 3270,
  [SMALL_STATE(133)] = 3280,
  [SMALL_STATE(134)] = 3288,
  [SMALL_STATE(135)] = 3294,
  [SMALL_STATE(136)] = 3300,
  [SMALL_STATE(137)] = 3310,
  [SMALL_STATE(138)] = 3320,
  [SMALL_STATE(139)] = 3330,
  [SMALL_STATE(140)] = 3336,
  [SMALL_STATE(141)] = 3342,
  [SMALL_STATE(142)] = 3352,
  [SMALL_STATE(143)] = 3362,
  [SMALL_STATE(144)] = 3372,
  [SMALL_STATE(145)] = 3378,
  [SMALL_STATE(146)] = 3388,
  [SMALL_STATE(147)] = 3398,
  [SMALL_STATE(148)] = 3408,
  [SMALL_STATE(149)] = 3418,
  [SMALL_STATE(150)] = 3428,
  [SMALL_STATE(151)] = 3438,
  [SMALL_STATE(152)] = 3448,
  [SMALL_STATE(153)] = 3453,
  [SMALL_STATE(154)] = 3458,
  [SMALL_STATE(155)] = 3463,
  [SMALL_STATE(156)] = 3470,
  [SMALL_STATE(157)] = 3475,
  [SMALL_STATE(158)] = 3480,
  [SMALL_STATE(159)] = 3487,
  [SMALL_STATE(160)] = 3492,
  [SMALL_STATE(161)] = 3497,
  [SMALL_STATE(162)] = 3504,
  [SMALL_STATE(163)] = 3509,
  [SMALL_STATE(164)] = 3514,
  [SMALL_STATE(165)] = 3519,
  [SMALL_STATE(166)] = 3526,
  [SMALL_STATE(167)] = 3531,
  [SMALL_STATE(168)] = 3536,
  [SMALL_STATE(169)] = 3541,
  [SMALL_STATE(170)] = 3548,
  [SMALL_STATE(171)] = 3553,
  [SMALL_STATE(172)] = 3558,
  [SMALL_STATE(173)] = 3565,
  [SMALL_STATE(174)] = 3570,
  [SMALL_STATE(175)] = 3575,
  [SMALL_STATE(176)] = 3580,
  [SMALL_STATE(177)] = 3584,
  [SMALL_STATE(178)] = 3588,
  [SMALL_STATE(179)] = 3592,
  [SMALL_STATE(180)] = 3596,
  [SMALL_STATE(181)] = 3600,
  [SMALL_STATE(182)] = 3604,
  [SMALL_STATE(183)] = 3608,
  [SMALL_STATE(184)] = 3612,
  [SMALL_STATE(185)] = 3616,
  [SMALL_STATE(186)] = 3620,
  [SMALL_STATE(187)] = 3624,
  [SMALL_STATE(188)] = 3628,
  [SMALL_STATE(189)] = 3632,
  [SMALL_STATE(190)] = 3636,
  [SMALL_STATE(191)] = 3640,
  [SMALL_STATE(192)] = 3644,
  [SMALL_STATE(193)] = 3648,
  [SMALL_STATE(194)] = 3652,
  [SMALL_STATE(195)] = 3656,
  [SMALL_STATE(196)] = 3660,
  [SMALL_STATE(197)] = 3664,
  [SMALL_STATE(198)] = 3668,
  [SMALL_STATE(199)] = 3672,
  [SMALL_STATE(200)] = 3676,
  [SMALL_STATE(201)] = 3680,
  [SMALL_STATE(202)] = 3684,
  [SMALL_STATE(203)] = 3688,
  [SMALL_STATE(204)] = 3692,
  [SMALL_STATE(205)] = 3696,
  [SMALL_STATE(206)] = 3700,
  [SMALL_STATE(207)] = 3704,
  [SMALL_STATE(208)] = 3708,
  [SMALL_STATE(209)] = 3712,
  [SMALL_STATE(210)] = 3716,
  [SMALL_STATE(211)] = 3720,
  [SMALL_STATE(212)] = 3724,
  [SMALL_STATE(213)] = 3728,
  [SMALL_STATE(214)] = 3732,
  [SMALL_STATE(215)] = 3736,
  [SMALL_STATE(216)] = 3740,
  [SMALL_STATE(217)] = 3744,
  [SMALL_STATE(218)] = 3748,
  [SMALL_STATE(219)] = 3752,
  [SMALL_STATE(220)] = 3756,
  [SMALL_STATE(221)] = 3760,
  [SMALL_STATE(222)] = 3764,
  [SMALL_STATE(223)] = 3768,
  [SMALL_STATE(224)] = 3772,
  [SMALL_STATE(225)] = 3776,
  [SMALL_STATE(226)] = 3780,
  [SMALL_STATE(227)] = 3784,
  [SMALL_STATE(228)] = 3788,
  [SMALL_STATE(229)] = 3792,
  [SMALL_STATE(230)] = 3796,
  [SMALL_STATE(231)] = 3800,
  [SMALL_STATE(232)] = 3804,
  [SMALL_STATE(233)] = 3808,
  [SMALL_STATE(234)] = 3812,
  [SMALL_STATE(235)] = 3816,
  [SMALL_STATE(236)] = 3820,
  [SMALL_STATE(237)] = 3824,
  [SMALL_STATE(238)] = 3828,
  [SMALL_STATE(239)] = 3832,
  [SMALL_STATE(240)] = 3836,
  [SMALL_STATE(241)] = 3840,
  [SMALL_STATE(242)] = 3844,
  [SMALL_STATE(243)] = 3848,
  [SMALL_STATE(244)] = 3852,
  [SMALL_STATE(245)] = 3856,
  [SMALL_STATE(246)] = 3860,
  [SMALL_STATE(247)] = 3864,
  [SMALL_STATE(248)] = 3868,
  [SMALL_STATE(249)] = 3872,
  [SMALL_STATE(250)] = 3876,
  [SMALL_STATE(251)] = 3880,
  [SMALL_STATE(252)] = 3884,
  [SMALL_STATE(253)] = 3888,
  [SMALL_STATE(254)] = 3892,
  [SMALL_STATE(255)] = 3896,
  [SMALL_STATE(256)] = 3900,
  [SMALL_STATE(257)] = 3904,
  [SMALL_STATE(258)] = 3908,
};

static const TSParseActionEntry ts_parse_actions[] = {
  [0] = {.entry = {.count = 0, .reusable = false}},
  [1] = {.entry = {.count = 1, .reusable = false}}, RECOVER(),
  [3] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_source_file, 0, 0, 0),
  [5] = {.entry = {.count = 1, .reusable = false}}, SHIFT(257),
  [7] = {.entry = {.count = 1, .reusable = true}}, SHIFT(49),
  [9] = {.entry = {.count = 1, .reusable = true}}, SHIFT(120),
  [11] = {.entry = {.count = 1, .reusable = false}}, SHIFT(169),
  [13] = {.entry = {.count = 1, .reusable = false}}, SHIFT(253),
  [15] = {.entry = {.count = 1, .reusable = false}}, SHIFT(252),
  [17] = {.entry = {.count = 1, .reusable = false}}, SHIFT(251),
  [19] = {.entry = {.count = 1, .reusable = false}}, SHIFT(30),
  [21] = {.entry = {.count = 1, .reusable = false}}, SHIFT(95),
  [23] = {.entry = {.count = 1, .reusable = true}}, SHIFT(18),
  [25] = {.entry = {.count = 1, .reusable = false}}, SHIFT(108),
  [27] = {.entry = {.count = 1, .reusable = true}}, SHIFT(108),
  [29] = {.entry = {.count = 1, .reusable = false}}, SHIFT(172),
  [31] = {.entry = {.count = 1, .reusable = false}}, SHIFT(191),
  [33] = {.entry = {.count = 1, .reusable = true}}, SHIFT(115),
  [35] = {.entry = {.count = 1, .reusable = true}}, SHIFT(189),
  [37] = {.entry = {.count = 1, .reusable = false}}, SHIFT(29),
  [39] = {.entry = {.count = 1, .reusable = false}}, SHIFT(242),
  [41] = {.entry = {.count = 1, .reusable = true}}, SHIFT(19),
  [43] = {.entry = {.count = 1, .reusable = true}}, SHIFT(246),
  [45] = {.entry = {.count = 2, .reusable = false}}, REDUCE(aux_sym_iterface_decl_list_repeat1, 2, 0, 0), SHIFT_REPEAT(95),
  [48] = {.entry = {.count = 2, .reusable = true}}, REDUCE(aux_sym_iterface_decl_list_repeat1, 2, 0, 0), SHIFT_REPEAT(19),
  [51] = {.entry = {.count = 2, .reusable = false}}, REDUCE(aux_sym_iterface_decl_list_repeat1, 2, 0, 0), SHIFT_REPEAT(108),
  [54] = {.entry = {.count = 2, .reusable = true}}, REDUCE(aux_sym_iterface_decl_list_repeat1, 2, 0, 0), SHIFT_REPEAT(108),
  [57] = {.entry = {.count = 2, .reusable = false}}, REDUCE(aux_sym_iterface_decl_list_repeat1, 2, 0, 0), SHIFT_REPEAT(242),
  [60] = {.entry = {.count = 2, .reusable = true}}, REDUCE(aux_sym_iterface_decl_list_repeat1, 2, 0, 0), SHIFT_REPEAT(115),
  [63] = {.entry = {.count = 1, .reusable = true}}, REDUCE(aux_sym_iterface_decl_list_repeat1, 2, 0, 0),
  [65] = {.entry = {.count = 2, .reusable = false}}, REDUCE(aux_sym_iterface_decl_list_repeat1, 2, 0, 0), SHIFT_REPEAT(29),
  [68] = {.entry = {.count = 1, .reusable = true}}, SHIFT(21),
  [70] = {.entry = {.count = 1, .reusable = true}}, SHIFT(119),
  [72] = {.entry = {.count = 1, .reusable = true}}, SHIFT(167),
  [74] = {.entry = {.count = 1, .reusable = false}}, SHIFT(26),
  [76] = {.entry = {.count = 1, .reusable = true}}, SHIFT(22),
  [78] = {.entry = {.count = 1, .reusable = true}}, SHIFT(173),
  [80] = {.entry = {.count = 2, .reusable = false}}, REDUCE(aux_sym_dictionary_decl_list_repeat1, 2, 0, 0), SHIFT_REPEAT(95),
  [83] = {.entry = {.count = 2, .reusable = true}}, REDUCE(aux_sym_dictionary_decl_list_repeat1, 2, 0, 0), SHIFT_REPEAT(22),
  [86] = {.entry = {.count = 2, .reusable = false}}, REDUCE(aux_sym_dictionary_decl_list_repeat1, 2, 0, 0), SHIFT_REPEAT(108),
  [89] = {.entry = {.count = 2, .reusable = true}}, REDUCE(aux_sym_dictionary_decl_list_repeat1, 2, 0, 0), SHIFT_REPEAT(108),
  [92] = {.entry = {.count = 2, .reusable = true}}, REDUCE(aux_sym_dictionary_decl_list_repeat1, 2, 0, 0), SHIFT_REPEAT(119),
  [95] = {.entry = {.count = 1, .reusable = true}}, REDUCE(aux_sym_dictionary_decl_list_repeat1, 2, 0, 0),
  [97] = {.entry = {.count = 2, .reusable = false}}, REDUCE(aux_sym_dictionary_decl_list_repeat1, 2, 0, 0), SHIFT_REPEAT(26),
  [100] = {.entry = {.count = 1, .reusable = true}}, SHIFT(176),
  [102] = {.entry = {.count = 1, .reusable = false}}, SHIFT(27),
  [104] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym__field_declaration, 4, 0, 0),
  [106] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym__field_declaration, 4, 0, 0),
  [108] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym__field_declaration, 5, 0, 43),
  [110] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym__field_declaration, 5, 0, 43),
  [112] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_interface_member, 1, 0, 0),
  [114] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_interface_member, 1, 0, 0),
  [116] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_operation_declaration, 5, 0, 42),
  [118] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_operation_declaration, 5, 0, 42),
  [120] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_setlike_declaration, 5, 0, 41),
  [122] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_setlike_declaration, 5, 0, 41),
  [124] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym__field_declaration, 5, 0, 40),
  [126] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym__field_declaration, 5, 0, 40),
  [128] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_setlike_declaration, 6, 0, 49),
  [130] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_setlike_declaration, 6, 0, 49),
  [132] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_operation_declaration, 6, 0, 51),
  [134] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_operation_declaration, 6, 0, 51),
  [136] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_interface_member, 1, 0, 11),
  [138] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_interface_member, 1, 0, 11),
  [140] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_operation_declaration, 7, 0, 56),
  [142] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_operation_declaration, 7, 0, 56),
  [144] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym__field_declaration, 6, 0, 52),
  [146] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym__field_declaration, 6, 0, 52),
  [148] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym__dict_field_declaration, 3, 0, 26),
  [150] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym__dict_field_declaration, 3, 0, 26),
  [152] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_source_file, 1, 0, 0),
  [154] = {.entry = {.count = 1, .reusable = true}}, SHIFT(54),
  [156] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_dictionary_member, 1, 0, 13),
  [158] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_dictionary_member, 1, 0, 13),
  [160] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym__dict_field_declaration, 4, 0, 35),
  [162] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym__dict_field_declaration, 4, 0, 35),
  [164] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym__dict_field_declaration, 4, 0, 33),
  [166] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym__dict_field_declaration, 4, 0, 33),
  [168] = {.entry = {.count = 1, .reusable = false}}, SHIFT(97),
  [170] = {.entry = {.count = 1, .reusable = false}}, SHIFT(245),
  [172] = {.entry = {.count = 1, .reusable = false}}, SHIFT(41),
  [174] = {.entry = {.count = 1, .reusable = true}}, REDUCE(aux_sym_source_file_repeat1, 2, 0, 0),
  [176] = {.entry = {.count = 2, .reusable = false}}, REDUCE(aux_sym_source_file_repeat1, 2, 0, 0), SHIFT_REPEAT(257),
  [179] = {.entry = {.count = 2, .reusable = true}}, REDUCE(aux_sym_source_file_repeat1, 2, 0, 0), SHIFT_REPEAT(54),
  [182] = {.entry = {.count = 2, .reusable = true}}, REDUCE(aux_sym_source_file_repeat1, 2, 0, 0), SHIFT_REPEAT(120),
  [185] = {.entry = {.count = 2, .reusable = false}}, REDUCE(aux_sym_source_file_repeat1, 2, 0, 0), SHIFT_REPEAT(169),
  [188] = {.entry = {.count = 2, .reusable = false}}, REDUCE(aux_sym_source_file_repeat1, 2, 0, 0), SHIFT_REPEAT(253),
  [191] = {.entry = {.count = 2, .reusable = false}}, REDUCE(aux_sym_source_file_repeat1, 2, 0, 0), SHIFT_REPEAT(252),
  [194] = {.entry = {.count = 2, .reusable = false}}, REDUCE(aux_sym_source_file_repeat1, 2, 0, 0), SHIFT_REPEAT(251),
  [197] = {.entry = {.count = 2, .reusable = false}}, REDUCE(aux_sym_source_file_repeat1, 2, 0, 0), SHIFT_REPEAT(30),
  [200] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym__dict_field_declaration, 5, 0, 45),
  [202] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym__dict_field_declaration, 5, 0, 45),
  [204] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_attributes, 4, 0, 0),
  [206] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_attributes, 4, 0, 0),
  [208] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_attributes, 2, 0, 0),
  [210] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_attributes, 2, 0, 0),
  [212] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_attributes, 3, 0, 0),
  [214] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_attributes, 3, 0, 0),
  [216] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_interface_declaration, 7, 0, 31),
  [218] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_interface_declaration, 7, 0, 31),
  [220] = {.entry = {.count = 1, .reusable = true}}, SHIFT(204),
  [222] = {.entry = {.count = 1, .reusable = false}}, SHIFT(204),
  [224] = {.entry = {.count = 1, .reusable = true}}, SHIFT(134),
  [226] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_enum_declaration, 5, 0, 4),
  [228] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_enum_declaration, 5, 0, 4),
  [230] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_interface_declaration, 7, 0, 30),
  [232] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_interface_declaration, 7, 0, 30),
  [234] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_dictionary_declaration, 5, 0, 20),
  [236] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_dictionary_declaration, 5, 0, 20),
  [238] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_interface_declaration, 7, 0, 32),
  [240] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_interface_declaration, 7, 0, 32),
  [242] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_enum_declaration, 7, 0, 25),
  [244] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_enum_declaration, 7, 0, 25),
  [246] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_includes_declaration, 4, 0, 8),
  [248] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_includes_declaration, 4, 0, 8),
  [250] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_interface_declaration, 7, 0, 36),
  [252] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_interface_declaration, 7, 0, 36),
  [254] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_interface_declaration, 7, 0, 37),
  [256] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_interface_declaration, 7, 0, 37),
  [258] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_interface_declaration, 9, 0, 54),
  [260] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_interface_declaration, 9, 0, 54),
  [262] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_interface_declaration, 6, 0, 22),
  [264] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_interface_declaration, 6, 0, 22),
  [266] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_interface_declaration, 7, 0, 38),
  [268] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_interface_declaration, 7, 0, 38),
  [270] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_interface_declaration, 6, 0, 28),
  [272] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_interface_declaration, 6, 0, 28),
  [274] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_namespace_declaration, 5, 0, 4),
  [276] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_namespace_declaration, 5, 0, 4),
  [278] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_namespace_declaration, 6, 0, 27),
  [280] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_namespace_declaration, 6, 0, 27),
  [282] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_namespace_declaration, 6, 0, 29),
  [284] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_namespace_declaration, 6, 0, 29),
  [286] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_interface_declaration, 8, 0, 44),
  [288] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_interface_declaration, 8, 0, 44),
  [290] = {.entry = {.count = 1, .reusable = true}}, SHIFT(162),
  [292] = {.entry = {.count = 1, .reusable = false}}, SHIFT(162),
  [294] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_interface_declaration, 5, 0, 19),
  [296] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_interface_declaration, 5, 0, 19),
  [298] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_enum_declaration, 6, 0, 25),
  [300] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_enum_declaration, 6, 0, 25),
  [302] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_interface_declaration, 6, 0, 23),
  [304] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_interface_declaration, 6, 0, 23),
  [306] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_interface_declaration, 8, 0, 48),
  [308] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_interface_declaration, 8, 0, 48),
  [310] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_dictionary_declaration, 4, 0, 14),
  [312] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_dictionary_declaration, 4, 0, 14),
  [314] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_typedef_declaration, 4, 0, 17),
  [316] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_typedef_declaration, 4, 0, 17),
  [318] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_dictionary_declaration, 4, 0, 15),
  [320] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_dictionary_declaration, 4, 0, 15),
  [322] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_interface_declaration, 8, 0, 47),
  [324] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_interface_declaration, 8, 0, 47),
  [326] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_enum_declaration, 6, 0, 4),
  [328] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_enum_declaration, 6, 0, 4),
  [330] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_namespace_declaration, 7, 0, 39),
  [332] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_namespace_declaration, 7, 0, 39),
  [334] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_dictionary_declaration, 3, 0, 4),
  [336] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_dictionary_declaration, 3, 0, 4),
  [338] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_interface_declaration, 8, 0, 46),
  [340] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_interface_declaration, 8, 0, 46),
  [342] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_interface_declaration, 6, 0, 24),
  [344] = {.entry = {.count = 1, .reusable = false}}, REDUCE(sym_interface_declaration, 6, 0, 24),
  [346] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_type, 1, 0, 3),
  [348] = {.entry = {.count = 1, .reusable = true}}, SHIFT(46),
  [350] = {.entry = {.count = 1, .reusable = true}}, SHIFT(144),
  [352] = {.entry = {.count = 1, .reusable = true}}, SHIFT(92),
  [354] = {.entry = {.count = 1, .reusable = true}}, SHIFT(216),
  [356] = {.entry = {.count = 1, .reusable = true}}, SHIFT(20),
  [358] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_type, 2, 0, 7),
  [360] = {.entry = {.count = 1, .reusable = true}}, SHIFT(140),
  [362] = {.entry = {.count = 1, .reusable = true}}, SHIFT(101),
  [364] = {.entry = {.count = 1, .reusable = true}}, SHIFT(190),
  [366] = {.entry = {.count = 1, .reusable = true}}, SHIFT(178),
  [368] = {.entry = {.count = 1, .reusable = true}}, SHIFT(193),
  [370] = {.entry = {.count = 1, .reusable = true}}, SHIFT(98),
  [372] = {.entry = {.count = 1, .reusable = true}}, SHIFT(179),
  [374] = {.entry = {.count = 1, .reusable = true}}, SHIFT(197),
  [376] = {.entry = {.count = 1, .reusable = true}}, SHIFT(103),
  [378] = {.entry = {.count = 1, .reusable = true}}, SHIFT(238),
  [380] = {.entry = {.count = 1, .reusable = true}}, SHIFT(40),
  [382] = {.entry = {.count = 2, .reusable = true}}, REDUCE(aux_sym_enum_declaration_repeat1, 2, 0, 0), SHIFT_REPEAT(101),
  [385] = {.entry = {.count = 1, .reusable = true}}, REDUCE(aux_sym_enum_declaration_repeat1, 2, 0, 0),
  [387] = {.entry = {.count = 2, .reusable = true}}, REDUCE(aux_sym_enum_declaration_repeat1, 2, 0, 0), SHIFT_REPEAT(178),
  [390] = {.entry = {.count = 1, .reusable = true}}, SHIFT(105),
  [392] = {.entry = {.count = 1, .reusable = true}}, SHIFT(203),
  [394] = {.entry = {.count = 1, .reusable = true}}, SHIFT(104),
  [396] = {.entry = {.count = 1, .reusable = true}}, SHIFT(185),
  [398] = {.entry = {.count = 2, .reusable = true}}, REDUCE(aux_sym_namespace_declaration_repeat1, 2, 0, 21), SHIFT_REPEAT(104),
  [401] = {.entry = {.count = 1, .reusable = true}}, REDUCE(aux_sym_namespace_declaration_repeat1, 2, 0, 21),
  [403] = {.entry = {.count = 2, .reusable = true}}, REDUCE(aux_sym_namespace_declaration_repeat1, 2, 0, 21), SHIFT_REPEAT(40),
  [406] = {.entry = {.count = 1, .reusable = true}}, SHIFT(249),
  [408] = {.entry = {.count = 1, .reusable = true}}, SHIFT(86),
  [410] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_primitive_type, 1, 0, 0),
  [412] = {.entry = {.count = 1, .reusable = true}}, REDUCE(aux_sym_dictionary_declaration_repeat1, 2, 0, 0),
  [414] = {.entry = {.count = 2, .reusable = true}}, REDUCE(aux_sym_dictionary_declaration_repeat1, 2, 0, 0), SHIFT_REPEAT(20),
  [417] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_type_parameter_list, 3, 0, 0),
  [419] = {.entry = {.count = 1, .reusable = true}}, SHIFT(67),
  [421] = {.entry = {.count = 1, .reusable = true}}, SHIFT(88),
  [423] = {.entry = {.count = 1, .reusable = true}}, SHIFT(164),
  [425] = {.entry = {.count = 1, .reusable = true}}, SHIFT(161),
  [427] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_operation_parameter, 3, 0, 50),
  [429] = {.entry = {.count = 1, .reusable = true}}, SHIFT(81),
  [431] = {.entry = {.count = 1, .reusable = true}}, SHIFT(133),
  [433] = {.entry = {.count = 1, .reusable = true}}, SHIFT(57),
  [435] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_parameterized, 2, 0, 6),
  [437] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_type_parameter_list, 4, 0, 0),
  [439] = {.entry = {.count = 1, .reusable = true}}, SHIFT(60),
  [441] = {.entry = {.count = 1, .reusable = true}}, SHIFT(163),
  [443] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_operation_parameter, 2, 0, 26),
  [445] = {.entry = {.count = 1, .reusable = true}}, SHIFT(24),
  [447] = {.entry = {.count = 1, .reusable = true}}, SHIFT(222),
  [449] = {.entry = {.count = 1, .reusable = true}}, SHIFT(148),
  [451] = {.entry = {.count = 1, .reusable = true}}, SHIFT(168),
  [453] = {.entry = {.count = 1, .reusable = true}}, SHIFT(56),
  [455] = {.entry = {.count = 1, .reusable = true}}, SHIFT(58),
  [457] = {.entry = {.count = 1, .reusable = true}}, SHIFT(48),
  [459] = {.entry = {.count = 1, .reusable = true}}, SHIFT(64),
  [461] = {.entry = {.count = 2, .reusable = true}}, REDUCE(aux_sym_type_parameter_list_repeat1, 2, 0, 0), SHIFT_REPEAT(36),
  [464] = {.entry = {.count = 1, .reusable = true}}, REDUCE(aux_sym_type_parameter_list_repeat1, 2, 0, 0),
  [466] = {.entry = {.count = 2, .reusable = true}}, REDUCE(aux_sym_attributes_repeat1, 2, 0, 0), SHIFT_REPEAT(148),
  [469] = {.entry = {.count = 1, .reusable = true}}, REDUCE(aux_sym_attributes_repeat1, 2, 0, 0),
  [471] = {.entry = {.count = 1, .reusable = true}}, SHIFT(62),
  [473] = {.entry = {.count = 1, .reusable = true}}, SHIFT(61),
  [475] = {.entry = {.count = 1, .reusable = true}}, SHIFT(52),
  [477] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_attribute, 1, 0, 1),
  [479] = {.entry = {.count = 1, .reusable = true}}, SHIFT(113),
  [481] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_boolean_literal, 1, 0, 0),
  [483] = {.entry = {.count = 1, .reusable = true}}, REDUCE(aux_sym_namespace_declaration_repeat1, 1, 0, 16),
  [485] = {.entry = {.count = 1, .reusable = true}}, SHIFT(36),
  [487] = {.entry = {.count = 1, .reusable = true}}, SHIFT(110),
  [489] = {.entry = {.count = 1, .reusable = true}}, SHIFT(117),
  [491] = {.entry = {.count = 1, .reusable = true}}, SHIFT(153),
  [493] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym__namespace_member, 6, 0, 53),
  [495] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_type, 3, 0, 18),
  [497] = {.entry = {.count = 2, .reusable = true}}, REDUCE(aux_sym_operation_declaration_repeat1, 2, 0, 0), SHIFT_REPEAT(24),
  [500] = {.entry = {.count = 1, .reusable = true}}, REDUCE(aux_sym_operation_declaration_repeat1, 2, 0, 0),
  [502] = {.entry = {.count = 1, .reusable = true}}, SHIFT(220),
  [504] = {.entry = {.count = 1, .reusable = true}}, SHIFT(8),
  [506] = {.entry = {.count = 1, .reusable = true}}, SHIFT(7),
  [508] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_type, 2, 0, 5),
  [510] = {.entry = {.count = 1, .reusable = true}}, SHIFT(9),
  [512] = {.entry = {.count = 1, .reusable = true}}, SHIFT(3),
  [514] = {.entry = {.count = 1, .reusable = true}}, SHIFT(236),
  [516] = {.entry = {.count = 1, .reusable = true}}, SHIFT(175),
  [518] = {.entry = {.count = 1, .reusable = true}}, SHIFT(154),
  [520] = {.entry = {.count = 1, .reusable = true}}, SHIFT(239),
  [522] = {.entry = {.count = 2, .reusable = true}}, REDUCE(aux_sym_attribute_value_set_repeat1, 2, 0, 0), SHIFT_REPEAT(236),
  [525] = {.entry = {.count = 1, .reusable = true}}, REDUCE(aux_sym_attribute_value_set_repeat1, 2, 0, 0),
  [527] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_attribute_value_set, 2, 0, 0),
  [529] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_attribute_value_set, 3, 0, 0),
  [531] = {.entry = {.count = 1, .reusable = false}}, SHIFT(143),
  [533] = {.entry = {.count = 1, .reusable = false}}, SHIFT(209),
  [535] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_operation_parameter, 3, 0, 35),
  [537] = {.entry = {.count = 1, .reusable = false}}, SHIFT(228),
  [539] = {.entry = {.count = 1, .reusable = true}}, SHIFT(228),
  [541] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_attribute, 1, 0, 2),
  [543] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_operation_parameter, 4, 0, 55),
  [545] = {.entry = {.count = 1, .reusable = true}}, SHIFT(149),
  [547] = {.entry = {.count = 1, .reusable = true}}, SHIFT(152),
  [549] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym__parameter_initializer, 2, 0, 34),
  [551] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym__attribute_with_value, 3, 0, 9),
  [553] = {.entry = {.count = 1, .reusable = true}}, SHIFT(155),
  [555] = {.entry = {.count = 1, .reusable = true}}, SHIFT(229),
  [557] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_dictionary_decl_list, 2, 0, 0),
  [559] = {.entry = {.count = 1, .reusable = false}}, SHIFT(142),
  [561] = {.entry = {.count = 1, .reusable = false}}, SHIFT(235),
  [563] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym__inherits, 2, 0, 12),
  [565] = {.entry = {.count = 1, .reusable = true}}, SHIFT(230),
  [567] = {.entry = {.count = 1, .reusable = true}}, SHIFT(44),
  [569] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_dictionary_decl_list, 3, 0, 0),
  [571] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_attribute_value_set, 4, 0, 0),
  [573] = {.entry = {.count = 1, .reusable = true}}, SHIFT(35),
  [575] = {.entry = {.count = 1, .reusable = true}}, SHIFT(66),
  [577] = {.entry = {.count = 1, .reusable = true}}, SHIFT(121),
  [579] = {.entry = {.count = 1, .reusable = true}}, SHIFT(256),
  [581] = {.entry = {.count = 1, .reusable = true}}, SHIFT(72),
  [583] = {.entry = {.count = 1, .reusable = true}}, SHIFT(4),
  [585] = {.entry = {.count = 1, .reusable = true}}, SHIFT(75),
  [587] = {.entry = {.count = 1, .reusable = true}}, SHIFT(82),
  [589] = {.entry = {.count = 1, .reusable = true}}, SHIFT(241),
  [591] = {.entry = {.count = 1, .reusable = true}}, SHIFT(91),
  [593] = {.entry = {.count = 1, .reusable = true}}, SHIFT(215),
  [595] = {.entry = {.count = 1, .reusable = true}}, SHIFT(38),
  [597] = {.entry = {.count = 1, .reusable = true}}, SHIFT(37),
  [599] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_iterface_decl_list, 1, 0, 0),
  [601] = {.entry = {.count = 1, .reusable = true}}, SHIFT(205),
  [603] = {.entry = {.count = 1, .reusable = true}}, SHIFT(34),
  [605] = {.entry = {.count = 1, .reusable = true}}, SHIFT(122),
  [607] = {.entry = {.count = 1, .reusable = true}}, SHIFT(83),
  [609] = {.entry = {.count = 1, .reusable = true}}, SHIFT(224),
  [611] = {.entry = {.count = 1, .reusable = true}}, SHIFT(32),
  [613] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_implements, 2, 0, 10),
  [615] = {.entry = {.count = 1, .reusable = true}}, SHIFT(65),
  [617] = {.entry = {.count = 1, .reusable = true}}, SHIFT(80),
  [619] = {.entry = {.count = 1, .reusable = true}}, SHIFT(158),
  [621] = {.entry = {.count = 1, .reusable = true}}, SHIFT(51),
  [623] = {.entry = {.count = 1, .reusable = true}}, SHIFT(127),
  [625] = {.entry = {.count = 1, .reusable = true}}, SHIFT(55),
  [627] = {.entry = {.count = 1, .reusable = true}}, SHIFT(77),
  [629] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym__dict_field_initializer, 2, 0, 34),
  [631] = {.entry = {.count = 1, .reusable = true}}, SHIFT(69),
  [633] = {.entry = {.count = 1, .reusable = true}}, SHIFT(68),
  [635] = {.entry = {.count = 1, .reusable = true}}, SHIFT(100),
  [637] = {.entry = {.count = 1, .reusable = true}}, SHIFT(93),
  [639] = {.entry = {.count = 1, .reusable = true}}, SHIFT(146),
  [641] = {.entry = {.count = 1, .reusable = true}}, SHIFT(89),
  [643] = {.entry = {.count = 1, .reusable = true}}, SHIFT(63),
  [645] = {.entry = {.count = 1, .reusable = true}}, SHIFT(87),
  [647] = {.entry = {.count = 1, .reusable = true}}, SHIFT(85),
  [649] = {.entry = {.count = 1, .reusable = true}}, SHIFT(5),
  [651] = {.entry = {.count = 1, .reusable = true}}, SHIFT(39),
  [653] = {.entry = {.count = 1, .reusable = true}}, SHIFT(170),
  [655] = {.entry = {.count = 1, .reusable = true}}, SHIFT(71),
  [657] = {.entry = {.count = 1, .reusable = true}}, SHIFT(2),
  [659] = {.entry = {.count = 1, .reusable = true}}, SHIFT(114),
  [661] = {.entry = {.count = 1, .reusable = true}}, SHIFT(196),
  [663] = {.entry = {.count = 1, .reusable = true}}, SHIFT(195),
  [665] = {.entry = {.count = 1, .reusable = true}}, SHIFT(42),
  [667] = {.entry = {.count = 1, .reusable = true}}, SHIFT(31),
  [669] = {.entry = {.count = 1, .reusable = true}}, SHIFT(47),
  [671] = {.entry = {.count = 1, .reusable = true}}, SHIFT(188),
  [673] = {.entry = {.count = 1, .reusable = true}}, SHIFT(187),
  [675] = {.entry = {.count = 1, .reusable = true}}, SHIFT(70),
  [677] = {.entry = {.count = 1, .reusable = true}}, SHIFT(139),
  [679] = {.entry = {.count = 1, .reusable = true}}, SHIFT(207),
  [681] = {.entry = {.count = 1, .reusable = true}}, SHIFT(28),
  [683] = {.entry = {.count = 1, .reusable = true}}, SHIFT(73),
  [685] = {.entry = {.count = 1, .reusable = true}}, SHIFT(212),
  [687] = {.entry = {.count = 1, .reusable = true}}, SHIFT(102),
  [689] = {.entry = {.count = 1, .reusable = true}}, SHIFT(99),
  [691] = {.entry = {.count = 1, .reusable = true}}, SHIFT(145),
  [693] = {.entry = {.count = 1, .reusable = true}}, SHIFT(174),
  [695] = {.entry = {.count = 1, .reusable = true}}, SHIFT(223),
  [697] = {.entry = {.count = 1, .reusable = true}}, SHIFT(79),
  [699] = {.entry = {.count = 1, .reusable = true}}, SHIFT(45),
  [701] = {.entry = {.count = 1, .reusable = true}}, SHIFT(6),
  [703] = {.entry = {.count = 1, .reusable = true}}, SHIFT(23),
  [705] = {.entry = {.count = 1, .reusable = true}}, SHIFT(76),
  [707] = {.entry = {.count = 1, .reusable = true}}, SHIFT(74),
  [709] = {.entry = {.count = 1, .reusable = true}}, SHIFT(25),
  [711] = {.entry = {.count = 1, .reusable = true}}, REDUCE(sym_iterface_decl_list, 2, 0, 0),
  [713] = {.entry = {.count = 1, .reusable = true}}, SHIFT(84),
  [715] = {.entry = {.count = 1, .reusable = true}}, SHIFT(227),
  [717] = {.entry = {.count = 1, .reusable = true}}, SHIFT(78),
  [719] = {.entry = {.count = 1, .reusable = true}},  ACCEPT_INPUT(),
  [721] = {.entry = {.count = 1, .reusable = true}}, SHIFT(233),
  [723] = {.entry = {.count = 1, .reusable = true}}, SHIFT(96),
  [725] = {.entry = {.count = 1, .reusable = true}}, SHIFT(234),
  [727] = {.entry = {.count = 1, .reusable = true}}, SHIFT(199),
  [729] = {.entry = {.count = 1, .reusable = true}}, SHIFT(94),
  [731] = {.entry = {.count = 1, .reusable = true}}, SHIFT(90),
  [733] = {.entry = {.count = 1, .reusable = true}}, SHIFT(248),
  [735] = {.entry = {.count = 1, .reusable = true}}, SHIFT(132),
};

#ifdef __cplusplus
extern "C" {
#endif
#ifdef TREE_SITTER_HIDE_SYMBOLS
#define TS_PUBLIC
#elif defined(_WIN32)
#define TS_PUBLIC __declspec(dllexport)
#else
#define TS_PUBLIC __attribute__((visibility("default")))
#endif

TS_PUBLIC const TSLanguage *tree_sitter_idl(void) {
  static const TSLanguage language = {
    .version = LANGUAGE_VERSION,
    .symbol_count = SYMBOL_COUNT,
    .alias_count = ALIAS_COUNT,
    .token_count = TOKEN_COUNT,
    .external_token_count = EXTERNAL_TOKEN_COUNT,
    .state_count = STATE_COUNT,
    .large_state_count = LARGE_STATE_COUNT,
    .production_id_count = PRODUCTION_ID_COUNT,
    .field_count = FIELD_COUNT,
    .max_alias_sequence_length = MAX_ALIAS_SEQUENCE_LENGTH,
    .parse_table = &ts_parse_table[0][0],
    .small_parse_table = ts_small_parse_table,
    .small_parse_table_map = ts_small_parse_table_map,
    .parse_actions = ts_parse_actions,
    .symbol_names = ts_symbol_names,
    .field_names = ts_field_names,
    .field_map_slices = ts_field_map_slices,
    .field_map_entries = ts_field_map_entries,
    .symbol_metadata = ts_symbol_metadata,
    .public_symbol_map = ts_symbol_map,
    .alias_map = ts_non_terminal_alias_map,
    .alias_sequences = &ts_alias_sequences[0][0],
    .lex_modes = ts_lex_modes,
    .lex_fn = ts_lex,
    .primary_state_ids = ts_primary_state_ids,
  };
  return &language;
}
#ifdef __cplusplus
}
#endif
