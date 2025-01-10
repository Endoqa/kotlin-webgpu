package webgpu.gen


val functionRegex = Regex("@ref\\s+(wgpu\\w+)")
val enumRegex = Regex("@ref\\s+(WGPU\\w+)_(\\w+)")

val objectRegex = Regex("@ref\\s+(WGPU\\w+)")
val articleRegex = Regex("@ref\\s([\\w-]*)")

// [name](@ref ArticleName)
val namedArticleRegex = Regex("\\[(\\w+)]\\(@ref (\\w+)\\)")


// @ref WGPUObject `fieldName`
val objectFieldRegex = Regex("@ref\\s+(WGPU\\w+)\\s+`(\\w+)`")


val inlineEnumRegex = Regex("`(WGPU\\w+)_(\\w+)`")

val inlineReferenceRegex = Regex("`(\\w+)`")

fun transformDoc(doc: String): String {
    return doc
        .replace(inlineEnumRegex) { match ->
            "[${match.groupValues[1]}.${match.groupValues[2]}]"
        }
        .replace(objectFieldRegex) { match ->
            "[${match.groupValues[1]}.${match.groupValues[2]}]"
        }
        .replace(namedArticleRegex) { match ->
            "[${match.groupValues[1]}](https://webgpu-native.github.io/webgpu-headers/articles.html)"
        }
        .replace(inlineReferenceRegex) { match ->
            "[${match.groupValues[1]}]"
        }
        .replace(functionRegex) { match ->
            "[${match.groupValues[1]}]"
        }
        .replace(enumRegex) { match ->
            "[${match.groupValues[1]}.${match.groupValues[2]}]"
        }
        .replace(objectRegex) { match ->
            "[${match.groupValues[1]}]"
        }
        .replace(articleRegex) { match ->
            "[${match.groupValues[1]}](https://webgpu-native.github.io/webgpu-headers/articles.html)"
        }
}
