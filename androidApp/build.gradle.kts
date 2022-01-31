plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlin-kapt")
    id("kotlin-android")
}

android {
    compileSdk = 32
    defaultConfig {
        applicationId = "com.example.kmm_demo.android"
        minSdk = 23
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.4.0")
    implementation("androidx.appcompat:appcompat:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.2")

    // ViewBinding
    implementation("com.github.kirich1409:viewbindingpropertydelegate-noreflection:1.4.4")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.4.0")

    // DI
    val koinVersion = "3.1.5"
    implementation("io.insert-koin:koin-android:$koinVersion")

    // Glide
    val glideVersion = "4.11.0"
    implementation("com.github.bumptech.glide:glide:$glideVersion")
    kapt("com.github.bumptech.glide:compiler:$glideVersion")

    // Navigation
    implementation("com.github.terrakok:cicerone:6.6")
}
