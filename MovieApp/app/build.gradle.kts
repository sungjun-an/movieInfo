plugins {
    alias(libs.plugins.android.application)
}

apply(from = "../base-build.gradle")

android {
    namespace = "com.example.movieapp"
}

dependencies {
    implementation(project(path = ":features:detail"))
    implementation(project(path = ":features:feed"))
    implementation(project(path = ":libraries:network"))
    implementation(project(path = ":libraries:network-contract"))
    implementation(project(path = ":libraries:storage"))
    implementation(project(path = ":libraries:storage-contract"))
}