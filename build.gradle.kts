buildscript {
    dependencies {
        classpath(libs.kotlin.gradlePlugin)
        classpath(libs.androidx.navigationPlugin)
    }
}
// TODO: Remove once https://youtrack.jetbrains.com/issue/KTIJ-19369 is fixed
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlin) apply false
    alias(libs.plugins.hilt) apply false
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}