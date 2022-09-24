
plugins {
    id("maven-publish")
}
publishing {
    publications {
        create<MavenPublication>("release") {
            afterEvaluate {
                if (plugins.hasPlugin("com.android.library")) {
                    from(components["release"])
                } else {
                    from(components["java"])
                }
            }
        }
    }
}
