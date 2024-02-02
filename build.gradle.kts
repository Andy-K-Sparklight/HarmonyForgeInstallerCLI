plugins {
    id("java-library")
    id("maven-publish")
    id("application")
}

group = "rarityeg.alicorn"
version = "1.0"

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = group.toString()
            artifactId = rootProject.name
            version = version

            from(components["java"])
        }
    }
}

application {
    mainClass = "rarityeg.alicorn.ForgeInstallerWrapper"
}