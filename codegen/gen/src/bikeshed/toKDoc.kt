package bikeshed


fun toKDoc(comment: String): String {
    var comment = comment

    val normalize = "\\[=(.+)=]".toRegex()
    comment = normalize.replace(comment) {
        it.groupValues[1]
    }

    val methodRef = "\\{\\{(\\w+)/(\\w+)\\(\\)}}".toRegex()
    comment = methodRef.replace(comment) {
        "[wgpu.${it.groupValues[1]}.${it.groupValues[2]}]"
    }

    val fieldRef = "\\{\\{(\\w+)/(\\w+)}}".toRegex()
    comment = fieldRef.replace(comment) {
        "[wgpu.${it.groupValues[1]}.${it.groupValues[2]}]"
    }




    // {{(text)}}
    val classRef = "\\{\\{(\\w+)}}".toRegex()
    comment = classRef.replace(comment) {
        "[wgpu.${it.groupValues[1]}]"
    }

    println(comment)

    return comment
}