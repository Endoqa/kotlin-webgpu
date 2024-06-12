package idl.parser

import java.util.*

fun String.removeQuotes(): String {
    return this.removeSurrounding("\"")
}

fun String.hyphenToCamelCase(): String {
    return this.split("-").joinToString(separator = "") { word ->
        word.replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(
                Locale.getDefault()
            ) else it.toString()
        }
    }
}