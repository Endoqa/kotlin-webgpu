package webgpu.schema

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Pointer(val string: String) {
    @SerialName("mutable")
    Mutable("mutable"),

    @SerialName("immutable")
    Immutable("immutable")
}