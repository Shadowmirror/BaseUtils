pluginManagement {
    repositories {
        maven("https://maven.aliyun.com/repository/google")
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        maven("https://maven.aliyun.com/repository/google")
        mavenCentral()
        maven("https://jitpack.io")
    }
}
rootProject.name = "BaseUtils"
include(
    "app"
)
include(":library")

include(":netdemo")
