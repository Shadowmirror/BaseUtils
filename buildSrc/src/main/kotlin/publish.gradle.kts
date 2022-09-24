
plugins {
    id("maven-publish")
}

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
