package wgpu.gen.common

/**
 * Converts a kebab-case string to camelCase.
 * For example, "foo-bar-baz" becomes "fooBarBaz".
 *
 * @param value The kebab-case string to convert
 * @return The camelCase version of the input string
 */
fun kebabToCamelCase(value: String): String {
    val parts = value.split("-")
    return if (parts.isEmpty()) {
        ""
    } else {
        parts.first().lowercase() + parts.drop(1).joinToString("") { part ->
            part.replaceFirstChar { it.uppercase() }
        }
    }
}

/**
 * Converts a kebab-case string to PascalCase.
 * For example, "foo-bar-baz" becomes "FooBarBaz".
 *
 * @param value The kebab-case string to convert
 * @return The PascalCase version of the input string
 */
fun kebabToPascalCase(value: String): String {
    return value.split("-").joinToString("") { part ->
        part.replaceFirstChar { it.uppercase() }
    }
}

/**
 * Removes hyphens from a string.
 * For example, "foo-bar-baz" becomes "foobarbaz".
 *
 * @param value The string to process
 * @return The string with hyphens removed
 */
fun removeHyphens(value: String): String {
    return value.split("-").joinToString("")
}
