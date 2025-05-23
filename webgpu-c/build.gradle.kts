plugins {
    id("maven-publish")
}

kotlin {
    explicitApi()
}

group = "io.endoqa.wgpu"
version = "1.0"

publishing {
    repositories {
        mavenLocal()
    }
}