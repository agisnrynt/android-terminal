plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.example.toyboxrun"
    compileSdk = 35   // must be >= targetSdk; use latest

    defaultConfig {
        applicationId = "com.example.toyboxrun"
        minSdk = 33          // ← changed here
        targetSdk = 35       // recommended / required for new Play uploads in 2026
        versionCode = 1
        versionName = "1.0"

        resConfigs("en")     // only English strings → saves size
        vectorDrawables.useSupportLibrary = false
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlin {
        jvmTarget = "17"
    }
}

dependencies {
    // zero external deps
}