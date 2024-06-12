package idl

data class Dictionary(
    val name: String,
    val inherits: String?,
    val members: MutableList<DictionaryMember>,
) : Decl


class DictionaryMember(
    val name: String,
    val type: Type,
    val required: Boolean,
    val default: Literal?,
) : Decl