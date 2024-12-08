package webgpu.schema

import kotlinx.serialization.Serializable

import kotlinx.serialization.SerialName

@Serializable
enum class Pointer(val string: String) {
    @SerialName("mutable")
    Mutable("mutable"),

    @SerialName("immutable")
    Immutable("immutable")
}