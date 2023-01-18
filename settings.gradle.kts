enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}

rootProject.name = "MultiModuleHilt"

val modules = arrayOf(
        ":app",
        ":core", ":core:model", ":core:common", ":core:database", ":core:network",
        ":feature:bookmarks"
)

include(*modules)
