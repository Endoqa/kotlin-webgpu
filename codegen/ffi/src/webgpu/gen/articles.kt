package webgpu.gen

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.jsonPrimitive
import java.io.File

data class Article(
    val name: String,
    val path: String
)


private fun loadArticles(indexPath: File = File("articles.json")): MutableList<Article> {
    val index = Json.decodeFromString<JsonArray>(indexPath.readText())

    val articles = mutableListOf<Article>()

    for (topLevel in index) {
        require(topLevel is JsonArray)
        loadArticle(topLevel, articles)
    }

    return articles
}

val articles by lazy {
    loadArticles()
}

fun searchArticle(name: String): String {
    val removeHyphen = name.replace("-", "")
    val article = articles.find { it.name.contains(removeHyphen, ignoreCase = true) }

    return (article ?: secondarySearch(name))?.path ?: error(removeHyphen)
}

private fun secondarySearch(name: String): Article? {
    return articles.find {
        it.path.endsWith(name, ignoreCase = true)
    }
}

private fun loadArticle(array: JsonArray, articles: MutableList<Article>) {
    val name = array[0].jsonPrimitive.content
    val path = array[1].jsonPrimitive.content
    articles.add(Article(name.replace("-", "").replace(" ", ""), path))

    val child = array[2]

    if (child is JsonNull) return
    require(child is JsonArray)

    child.forEach { loadArticle(it as JsonArray, articles) }
}