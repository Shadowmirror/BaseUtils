/* To test everything builds and artifacts are published to
 * mavenLocal ($HOME/.m2/repository),
 * run `./gradlew publishToMavenLocal` at the root of the project.
 */

// Required plugin for publishing library module
apply plugin: 'maven-publish'

// Replace nisrulz with <your_github_username>
final group = "com.github.shadowmirror"
final artifact = "BastUtils"
final versionCode = 3
final versionName = "0.0.3"

android {
    defaultConfig {
        // define version
        buildConfigField 'int', 'VERSION_CODE', "${versionCode}"
        buildConfigField 'String', 'VERSION_NAME', "\"${versionName}\""
    }
}

// Because the components are created only during the afterEvaluate phase, you must
// configure your publications using the afterEvaluate() lifecycle method.
afterEvaluate {
    publishing {
        publications {
            // Creates a Maven publication called "release".
            release(MavenPublication) {
                // Applies the component for the release build variant.
                from components.release

                // You can then customize attributes of the publication as shown below.
                groupId = group
                artifactId = artifact
                version = versionName
            }

            // Creates a Maven publication called “debug”.
            debug(MavenPublication) {
                // Applies the component for the debug build variant.
                from components.debug

                        groupId = group + ".debug"
                artifactId = artifact + "-debug"
                version = versionName
            }
        }
    }
}