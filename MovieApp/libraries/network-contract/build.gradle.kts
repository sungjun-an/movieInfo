plugins {
    id("com.android.library")
}

apply(from = "../../base-build.gradle")

android {
    namespace = "com.example.movieapp.libraries.network_contract"
}

dependencies {
    implementation(libs.gson)
}