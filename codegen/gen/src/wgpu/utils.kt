package wgpu

fun singularize(s: String): String {
    return when (s) {
        "entries" -> "entry"

        else -> s.removeSuffix("s")
    }
}