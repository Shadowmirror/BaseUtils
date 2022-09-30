plugins {
    id("com.android.library")
    kotlin("android")
    publish
}

android {
    namespace = "miao.kmirror.library"
    compileSdk = 32

    defaultConfig {
        minSdk = 21
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    viewBinding {
        enable = true
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
    publishing {
        singleVariant("release") {
            withSourcesJar()
            withJavadocJar()
        }
    }
}

dependencies {
    implementation(DependencyConfig.AndroidX.CoreKtx)
    implementation(DependencyConfig.AndroidX.AppCompat)
    implementation(DependencyConfig.JetPack.ViewModel)
    implementation(DependencyConfig.GitHub.OkHttp)
    implementation(DependencyConfig.GitHub.OkHttpInterceptorLogging)
    implementation(DependencyConfig.GitHub.RetrofitConverterGson)
    implementation(DependencyConfig.GitHub.Retrofit)
}