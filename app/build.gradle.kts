// TODO: Remove once https://youtrack.jetbrains.com/issue/KTIJ-19369 is fixed
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.hilt)
    kotlin("android")
    kotlin("kapt")
}

android {

    namespace = "com.turtle.multimodulehilt"
    compileSdk = libs.versions.compileSdkVersion.get().toInt()

    defaultConfig {

        applicationId = "com.turtle.multimodulehilt"
        minSdk = libs.versions.minSdkVersion.get().toInt()
        targetSdk = libs.versions.targetSdkVersion.get().toInt()
        versionCode = libs.versions.versionCode.get().toInt()
        versionName = libs.versions.versionName.get()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        dataBinding = true
    }

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

// TODO: Remove once https://youtrack.jetbrains.com/issue/KTIJ-19369 is fixed
@Suppress("DSL_SCOPE_VIOLATION")
dependencies {

    implementation(projects.core.common)
    implementation(projects.core.database)
    implementation(projects.core.model)
    implementation(projects.core.network)
    implementation(projects.core.domain)
    implementation(projects.core.data)
    implementation(projects.feature.avengers)
    implementation(projects.feature.heros)
    implementation(projects.feature.news)

    implementation(libs.androidx.core)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.navigation.fragment)
    implementation(libs.androidx.navigation.ui)

    implementation(libs.google.material)

    implementation(libs.google.hilt)
    kapt(libs.google.hilt.compiler)

    implementation(libs.bundles.reactivex)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.junit)
    androidTestImplementation(libs.androidx.test.espresso)

}