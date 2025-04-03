repositories {
    mavenCentral()
}


kotlin {
    sourceSets {
        val jvmMain by getting {

            dependencies {
                val lwjglNatives = "natives-linux"

                implementation(libs.lwjgl.core)
                runtimeOnly(dependencies.variantOf(libs.lwjgl.core) {
                    classifier(lwjglNatives)
                })

                implementation(libs.lwjgl.glfw)
                runtimeOnly(dependencies.variantOf(libs.lwjgl.glfw) {
                    classifier(lwjglNatives)
                })

            }
        }


    }
}