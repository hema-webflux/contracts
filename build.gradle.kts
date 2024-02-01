plugins {
    id("java")
    id("maven-publish")
    signing
}

apply(from = "/home/xgbnl/.gradle/publish.gradle")

group = "io.github.hema-webflux"
version = "1.0"

repositories {
    mavenCentral()
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21

    withJavadocJar()
    withSourcesJar()
}

publishing {
    publications {
        register<MavenPublication>(project.name) {
            signing {
                sign(this@register)
            }
        }
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            pom {
                name = project.name
                description = "Contracts"
                url = "https://github.com/hema-webflux/contracts"

                licenses {
                    license {
                        name = "The Apache License, Version 2.0"
                        url = "http://www.apache.org/licenses/LICENSE-2.0.txt"
                    }
                }

                developers {
                    developer {
                        id = "xgbnl"
                        name = "Dai Fei"
                        email = "745502274@qq.com"
                    }
                }

                scm {
                    connection = "scm:git@github.com:hema-webflux/contracts.git"
                    developerConnection = "scm:git@github.com:hema-webflux/contracts.git"
                    url = "https://github.com/hema-webflux/contracts"
                }

            }
        }
    }

    repositories {
        maven {

            val repoProperties: String = if (version.toString().endsWith("SNAPSHOT")) "snapshot" else "release"
            url = uri(providers.gradleProperty("package.${repoProperties}.repo").get())

            credentials {
                username = project.ext.get("sonaUsername").toString()
                password = project.ext.get("sonaPassword").toString()
            }
        }
    }
}

signing {

    val keyId: String = project.ext.get("signing.keyId").toString()
    val password: String = project.ext.get("signing.password").toString()
    val secretKey: String = project.ext.get("signing.secretKeyRingFile").toString()

    useGpgCmd()

    useInMemoryPgpKeys(keyId, secretKey, password)

    isRequired = gradle.taskGraph.hasTask("publish")
    sign(publishing.publications["mavenJava"])
}

tasks.javadoc {
    if (JavaVersion.current().isJava9Compatible) {
        (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
    }
}

