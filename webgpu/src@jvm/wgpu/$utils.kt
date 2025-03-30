package wgpu


import java.lang.foreign.Arena


internal inline fun <R> unsafe(action: (Arena) -> R): R {
    return Arena.ofConfined().use(action)
}

internal inline fun <R> unsafeScope(action: Arena.() -> R): R {
    return Arena.ofConfined().use(action)
}
