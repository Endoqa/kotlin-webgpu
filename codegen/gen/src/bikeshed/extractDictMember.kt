package bikeshed

import com.fleeksoft.ksoup.nodes.Element
import com.fleeksoft.ksoup.nodes.TextNode

data class DictMember(val name: String, val kdoc: String)

data class DictDocs(
    val name: String,
    val members: List<DictMember>
) {
    fun getMember(name: String) = members.first { it.name == name }
}

fun extractDictMemberDocs(bs: Element) : DictDocs {
    val forDict = bs.attr("dfn-for")
    println("For dict: $forDict")



    val body = bs.html().trimIndent()


    val lines = body.lines()

    val rawMembers = mutableListOf<List<String>>()

    var member = mutableListOf<String>()
    for (line in lines) {
        if (line.startsWith(": ")) {
            if (member.isNotEmpty()) {
                rawMembers.add(member)
                member = mutableListOf()
            }

            member.add(line.trim())
        } else {
            if (line != "::") {
                member.add(line)
            }
        }
    }

    if (member.isNotEmpty()) {
        rawMembers.add(member)
    }



    val members = rawMembers.map {
        val name = it[0]
        // pattern for <dfn>(name)</dfn>
        val pattern = "<dfn>(.+?)</dfn>".toRegex()
        val nameMatch = pattern.find(name)
        val nameInTag = nameMatch!!.groupValues[1]


        val comment = it.drop(1).joinToString("\n").trimIndent()
        DictMember(nameInTag, toKDoc(comment))
    }

    return DictDocs(forDict, members)
}


