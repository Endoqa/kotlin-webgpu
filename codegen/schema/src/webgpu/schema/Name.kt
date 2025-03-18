package webgpu.schema

import kotlinx.serialization.Serializable


@Serializable
@JvmInline
value class Name(val name: String) {


    val camelCase: String
        get() {
            return name
                .split('_')
                .joinToString("") { part ->
                    part.replaceFirstChar {
                        it.uppercase()
                    }
                }
                .replaceFirstChar {
                    it.lowercase()
                }
        }


    val pascalCase: String
        get() = camelCase.replaceFirstChar { it.uppercase() }

}

fun singularize(s: String): String {
    return when (s) {
        "entries" -> "entry"

        else -> s.removeSuffix("s")
    }
}