package webgpu.schema

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class CallbackStyle(val string: String) {
    @SerialName("callback_mode")
    CallbackMode("callback_mode"),

    @SerialName("immediate")
    Immediate("immediate")
}