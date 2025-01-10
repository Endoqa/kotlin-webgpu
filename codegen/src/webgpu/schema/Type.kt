package webgpu.schema

import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.decodeFromJsonElement

@Serializable(with = TypeSerializer::class)
sealed interface Type


@Serializable
enum class PrimitiveType(val string: String) : Type {
    @SerialName("c_void")
    CVoid("c_void"),

    @SerialName("bool")
    Bool("bool"),

    @SerialName("nullable_string")
    NullableString("nullable_string"),

    @SerialName("string_with_default_empty")
    StringWithDefaultEmpty("string_with_default_empty"),

    @SerialName("out_string")
    OutString("out_string"),

    @SerialName("uint16")
    UInt16("uint16"),

    @SerialName("uint32")
    UInt32("uint32"),

    @SerialName("uint64")
    UInt64("uint64"),

    @SerialName("usize")
    USize("usize"),

    @SerialName("int16")
    Int16("int16"),

    @SerialName("int32")
    Int32("int32"),

    @SerialName("float32")
    Float32("float32"),

    @SerialName("nullable_float32")
    NullableFloat32("nullable_float32"),

    @SerialName("float64")
    Float64("float64"),

    @SerialName("float64_supertype")
    Float64SuperType("float64_supertype"),

    @SerialName("array<bool>")
    ArrayBool("array<bool>"),

    @SerialName("array<string>")
    ArrayString("array<string>"),

    @SerialName("array<uint16>")
    ArrayUInt16("array<uint16>"),

    @SerialName("array<uint32>")
    ArrayUInt32("array<uint32>"),

    @SerialName("array<uint64>")
    ArrayUInt64("array<uint64>"),

    @SerialName("array<usize>")
    ArrayUSize("array<usize>"),

    @SerialName("array<int16>")
    ArrayInt16("array<int16>"),

    @SerialName("array<int32>")
    ArrayInt32("array<int32>"),

    @SerialName("array<float32>")
    ArrayFloat32("array<float32>"),

    @SerialName("array<float64>")
    ArrayFloat64("array<float64>")
}


@Serializable
enum class TypeNamespace {
    @SerialName("typedef")
    Typedef,

    @SerialName("enum")
    Enum,

    @SerialName("bitflag")
    Bitflag,

    @SerialName("struct")
    Struct,

    @SerialName("function_type")
    FunctionType,

    @SerialName("object")
    Object
}

@Serializable
data class ComplexType(
    val isArray: Boolean,
    val namespace: TypeNamespace, //Todo: replace with enums
    val name: String,
) : Type

@Serializable(with = CallbackTypeSerializer::class)
@JvmInline
value class CallbackType(
    val name: String
) : Type


private val complexTypePattern =
    Regex("^(array<)?(typedef.|enum.|bitflag.|struct.|function_type.|object.)([a-zA-Z0-9]([a-zA-Z0-9_]*[a-zA-Z0-9])?)(>)?$")

private val callbackTypePattern = Regex("^(callback.)([a-zA-Z0-9]([a-zA-Z0-9_]*[a-zA-Z0-9])?)$")


object CallbackTypeSerializer : KSerializer<CallbackType> {
    override val descriptor: SerialDescriptor = JsonPrimitive.serializer().descriptor

    override fun serialize(encoder: Encoder, value: CallbackType) {
        encoder.encodeString("callback.${value.name}")
    }

    override fun deserialize(decoder: Decoder): CallbackType {
        val str = decoder.decodeString()
        val matches = callbackTypePattern.matchEntire(str)
        if (matches != null) {
            return CallbackType(matches.groupValues[2])
        }

        error("Invalid")
    }
}

object TypeSerializer : KSerializer<Type> {
    override val descriptor: SerialDescriptor = JsonPrimitive.serializer().descriptor

    override fun serialize(encoder: Encoder, value: Type) {
        when (value) {
            is CallbackType -> {
                encoder.encodeString("callback.${value.name}")
            }

            is ComplexType -> {
                val identifier = "${value.namespace.name.lowercase()}.${value.name}"
                val str = if (value.isArray) "array<${identifier}>" else identifier
                encoder.encodeString(str)
            }

            is PrimitiveType -> {
                val idx = PrimitiveType.entries.indexOf(value)
                encoder.encodeEnum(PrimitiveType.serializer().descriptor, idx)
            }
        }
    }

    override fun deserialize(decoder: Decoder): Type {
        val str = decoder.decodeString()

        val matchesComplexType = complexTypePattern.matchEntire(str)
        if (matchesComplexType != null) {
            return parseComplexType(matchesComplexType)
        }

        val matchesCallbackType = callbackTypePattern.matchEntire(str)
        if (matchesCallbackType != null) {
            return parseCallbackType(matchesCallbackType)
        }


        return Json.decodeFromJsonElement<PrimitiveType>(JsonPrimitive(str))

    }


    private fun parseComplexType(m: MatchResult): ComplexType {

        val groups = m.groupValues

        val isArray = groups[1] == "array<"
        val namespaceStr = groups[2].dropLast(1)

        val namespace = Json.decodeFromJsonElement<TypeNamespace>(JsonPrimitive(namespaceStr))

        val name = groups[3]

        return ComplexType(isArray, namespace, name)
    }

    private fun parseCallbackType(m: MatchResult): CallbackType {

        val groups = m.groupValues
        val name = groups[2]

        return CallbackType(name)
    }

}