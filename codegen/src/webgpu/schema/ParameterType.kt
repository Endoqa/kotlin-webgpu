package webgpu.schema

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonPrimitive

@Serializable
data class ParameterType(
    val name: Name,
    val doc: String,
    val type: Type,
    @SerialName("passed_with_ownership")
    val passedWithOwnership: Boolean?,
    val pointer: Pointer?,
    val optional: Boolean?,
    val namespace: String?,
    val default: JsonPrimitive?
)

typealias FunctionParameterType = ParameterType