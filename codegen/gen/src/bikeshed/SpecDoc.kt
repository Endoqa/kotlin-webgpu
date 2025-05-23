package bikeshed

data class SpecDoc(
    val dict: List<DictDocs>
) {
    fun getDict(name: String) = dict.firstOrNull { it.name == name }
}