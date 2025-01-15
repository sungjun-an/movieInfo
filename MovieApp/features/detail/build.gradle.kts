plugins {
    id("com.android.library")
}

android {
    namespace = "com.example.movieapp.features.detail"
}
apply(from = "../../base-build.gradle")

dependencies {
    implementation(project(path = ":core"))
}