import org.gradle.kotlin.dsl.`kotlin-dsl`

plugins {
    `kotlin-dsl`
}

dependencies {
    implementation(kotlin("script-runtime"))
}

repositories {
    mavenCentral()
    google()
}