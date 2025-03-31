plugins {
    id("org.jetbrains.dokka") version "2.0.0" apply false
}

subprojects {
    apply(plugin = "org.jetbrains.dokka")
}