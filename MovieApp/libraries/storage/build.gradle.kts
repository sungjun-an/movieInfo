plugins {
    id("com.android.library")
}

android {
    namespace = "com.example.movieapp.libraries.storage"
}
apply(from = "../../base-build.gradle")

dependencies {
    implementation(project(path = ":libraries:storage-contract"))
}