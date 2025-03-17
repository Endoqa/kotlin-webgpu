package webgpu.schema

import kotlinx.serialization.Serializable

@Serializable
data class Callback(
    val name: Name,
    val doc: String,
    val style: CallbackStyle,
    val args: List<FunctionParameterType>?
)