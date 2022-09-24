plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "miao.kmirror.baseutils"
    compileSdk = 32

    defaultConfig {
        applicationId = "miao.kmirror.baseutils"
        minSdk = 21
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(DependencyConfig.AndroidX.CoreKtx)
    implementation(DependencyConfig.AndroidX.AppCompat)
    implementation(DependencyConfig.Android.Material)
    implementation(DependencyConfig.AndroidX.ConstraintLayout)
    implementation(project(mapOf("path" to ":library")))
    implementation("com.github.Shadowmirror:BaseUtils:0.0.9")
    testImplementation(DependencyConfig.Test.Junit)
    androidTestImplementation(DependencyConfig.Test.TestExtJunit)
    androidTestImplementation(DependencyConfig.Test.TestEspresso)
}