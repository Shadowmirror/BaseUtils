plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "miao.kmirror.netdemo"
    compileSdk = 32

    defaultConfig {
        applicationId = "miao.kmirror.netdemo"
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

    viewBinding {
        enable = true
    }
}

dependencies {

    implementation(DependencyConfig.GitHub.OkHttp)
    implementation(DependencyConfig.GitHub.OkHttpInterceptorLogging)
    implementation(DependencyConfig.GitHub.RetrofitConverterGson)
    implementation(DependencyConfig.GitHub.Retrofit)

    implementation(DependencyConfig.JetPack.ViewModel)
    implementation(DependencyConfig.JetPack.LiveData)
    implementation(DependencyConfig.JetPack.ViewModelSavedState)
    implementation(DependencyConfig.JetPack.PagingRuntime)


    implementation(DependencyConfig.AndroidX.ActivityKtx)


    implementation(DependencyConfig.AndroidX.CoreKtx)
    implementation(DependencyConfig.AndroidX.AppCompat)
    implementation(DependencyConfig.Android.Material)
    implementation(DependencyConfig.AndroidX.ConstraintLayout)
    implementation(project(mapOf("path" to ":library")))
    testImplementation(DependencyConfig.Test.Junit)
    androidTestImplementation(DependencyConfig.Test.TestExtJunit)
    androidTestImplementation(DependencyConfig.Test.TestEspresso)
}