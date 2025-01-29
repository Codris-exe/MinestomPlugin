plugins {
    id("java")
    id("com.gradleup.shadow") version "8.3.0"
}

group = "com.codris"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("net.minestom:minestom-snapshots:32735340d7")
}

tasks {
    jar {
        manifest {
            attributes["Main-Class"] = "com.codris.Main"
        }
    }

    build {
        dependsOn(shadowJar)
    }
    shadowJar {
        mergeServiceFiles()
        archiveClassifier.set("")
    }
}