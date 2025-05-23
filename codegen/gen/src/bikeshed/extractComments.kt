package bikeshed

import com.fleeksoft.ksoup.Ksoup
import com.fleeksoft.ksoup.nodes.Document
import java.io.File

fun extractComments(html: Document): SpecDoc {
    html.outputSettings().prettyPrint(false)


    val dict = html
        .select("dl[dfn-type=dict-member]")
        .map {
            extractDictMemberDocs(it)
        }

    return SpecDoc(dict)
}


fun main() {
    extractComments(Ksoup.parse(File("../index.bs").readText()))
}