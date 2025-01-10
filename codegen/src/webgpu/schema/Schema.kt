package webgpu.schema

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Schema(
    val copyright: String,
    val name: Name,
    @SerialName("enum_prefix")
    val enumPrefix: String,
    val doc: String,
    val typedefs: List<Typedef>,
    val constants: List<Constant>,
    val enums: List<Enum>,
    val bitflags: List<Bitflag>,
    val structs: List<Struct>,
    val callbacks: List<Callback>,
    val functions: List<Function>,
    val objects: List<Object>,
)


@Serializable
data class Typedef(
    val name: Name,
    val doc: String,
    val type: PrimitiveType
)


@Serializable
data class Constant(
    val name: Name,
    val value: Value64,
    val doc: String
)

@Serializable
data class Enum(
    val name: Name,
    val doc: String,
    val extended: Boolean?,
    val entries: List<EnumEntry?>?
)

@Serializable
data class EnumEntry(
    val name: Name,
    val doc: String,
    val value: Value16?
)

@Serializable
data class Bitflag(
    val name: Name,
    val doc: String,
    val extended: Boolean?,
    val entries: List<BitflagEntry>
)

@Serializable
data class BitflagEntry(
    val name: Name,
    val doc: String,
    val value: Value64?,
    @SerialName("value_combination")
    val valueCombination: List<Name>?
)


@Serializable
data class Struct(
    val name: Name,
    val doc: String,
    val type: StructType,
    val extends: List<String>?,
    @SerialName("free_members")
    val freeMembers: Boolean?,
    val members: List<ParameterType>?
)

@Serializable
enum class StructType {
    @SerialName("extensible")
    Extensible,

    @SerialName("extensible_callback_arg")
    ExtensibleCallbackArg,

    @SerialName("extension")
    Extension,

    @SerialName("standalone")
    Standalone
}

@Serializable
data class Object(
    val name: Name,
    val doc: String,
    val extended: Boolean?,
    val namespace: String?,
    val methods: List<Function>?
)