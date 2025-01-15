plugins {
    id("com.android.library")
}

android {
    namespace = "com.example.movieapp.libraries.network"
    buildFeatures {
        buildConfig = true
    }
}

apply(from = "../../base-build.gradle")

dependencies {
    implementation(project(path = ":libraries:network-contract"))
    // retrofit
    implementation(libs.bundles.retrofit)
    implementation(libs.gson)
}