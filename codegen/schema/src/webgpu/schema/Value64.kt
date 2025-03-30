package webgpu.schema

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.decodeFromJsonElement

@Serializable(with = Value64Serializer::class)
sealed interface Value64 {

    @JvmInline
    @Serializable
    value class Integer(val value: ULong) : Value64

    @Serializable
    enum class Constant() : Value64 {
        @SerialName("usize_max")
        USizeMax,

        @SerialName("uint32_max")
        UInt32Max,

        @SerialName("uint64_max")
        UInt64Max,

        @SerialName("nan")
        NaN,
    }
}

object Value64Serializer : KSerializer<Value64> {
    override val descriptor: SerialDescriptor = JsonPrimitive.serializer().descriptor

    override fun serialize(encoder: Encoder, value: Value64) {
        when (value) {
            is Value64.Integer -> {
                encoder.encodeLong(value.value.toLong())
            }

            is Value64.Constant -> {
                val idx = Value64.Constant.entries.indexOf(value)
                encoder.encodeEnum(Value64.Constant.serializer().descriptor, idx)
            }
        }
    }

    @OptIn(InternalSerializationApi::class)
    override fun deserialize(decoder: Decoder): Value64 {
        val v = decoder.decodeSerializableValue(JsonPrimitive.serializer())

        return if (v.isString) {
            Json.decodeFromJsonElement<Value64.Constant>(v)
        } else {
            Json.decodeFromJsonElement<Value64.Integer>(v)
        }
    }

}