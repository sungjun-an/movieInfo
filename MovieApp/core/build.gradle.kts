plugins {
    id("com.android.library")
}

apply(from = "../base-build.gradle")

android {
    namespace = "com.example.movieapp.core"
}

dependencies {
    implementation(project(path = ":libraries:network-contract"))
    implementation(project(path = ":libraries:storage-contract"))
    api(project(path = ":ui_components"))

    implementation(libs.gson)
}