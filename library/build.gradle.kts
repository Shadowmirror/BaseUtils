import com.android.build.gradle.internal.scope.publishArtifactToConfiguration
import com.android.build.gradle.internal.utils.publishingFeatureOptIn

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

val versionCode = 5
val versionName = "0.0.5"


android {
    compileSdk = 32

    defaultConfig {
        minSdk = 21
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.6.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                components["release"]
                groupId = "miao.kmirror"
                artifactId = "BaseUtils"
                version = versionName
            }
            create<MavenPublication>("debug"){
                components["debug"]
                groupId = "miao.kmirror"+ "-debug"
                artifactId = "BaseUtils" + "-debug"
                version = versionName
            }
        }
    }
}


