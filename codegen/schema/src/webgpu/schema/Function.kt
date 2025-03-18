package webgpu.schema

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Function(
    val name: Name,
    val doc: String,
    val returns: FunctionReturn?,
    val callback: CallbackType?,
    val args: List<FunctionParameterType>?
)

@Serializable
data class FunctionReturn(
    val doc: String,
    val type: Type,
    @SerialName("passed_with_ownership")
    val passedWithOwnership: Boolean?,
    val pointer: Pointer?,
    val optional: Boolean?
)
