
plugins {
    id("maven-publish")
}

group = "com.github.shadowmirror"

publishing {
    publications {
        register<MavenPublication>("release") {
            groupId = "com.github.shadowmirror"
            artifactId = "BaseUtils"
            version = "1.0.0"
            afterEvaluate {
                from(components["release"])
            }
        }
    }
}
