
plugins {
    id("maven-publish")
}

group = "com.github.shadowmirror"

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.github.shadowmirror"
            artifactId = "BaseUtils"
            version = "0.0.9"
            afterEvaluate {
                from(components["release"])
            }
        }
    }
}
