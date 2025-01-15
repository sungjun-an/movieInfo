plugins {
    id("com.android.library")
}

android {
    namespace = "com.example.movieapp.features.feed"
}
apply(from = "../../base-build.gradle")

dependencies {
    implementation(project(path = ":core"))
}