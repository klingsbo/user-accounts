plugins {
    kotlin("jvm") version "1.8.21"
    kotlin("plugin.allopen") version "1.8.21"
    id("io.quarkus")
    jacoco
}

repositories {
    mavenCentral()
    mavenLocal()
}

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("io.quarkus:quarkus-kotlin")
    implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
    implementation("io.quarkus:quarkus-resteasy")
    implementation("io.quarkus:quarkus-resteasy-jackson")
    implementation("io.quarkus:quarkus-hibernate-orm-panache")
    implementation("io.quarkus:quarkus-jdbc-postgresql")
    implementation("io.quarkus:quarkus-liquibase")
    implementation("io.quarkus:quarkus-arc")

    testImplementation("io.quarkus:quarkus-junit5")
    testImplementation("io.quarkus:quarkus-jacoco")
    testImplementation("io.rest-assured:rest-assured")
}

group = "com.github.klingsbo"
version = "1.0.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = JavaVersion.VERSION_17.toString()
    kotlinOptions.javaParameters = true
}

tasks.jacocoTestCoverageVerification {
    executionData.setFrom("./build/jacoco-quarkus.exec")
    violationRules {
        rule {
            limit {
                counter = "CLASS"
                minimum = "1".toBigDecimal()
            }
            limit {
                counter = "INSTRUCTION"
                minimum = "0.6".toBigDecimal()
            }
            limit {
                counter = "BRANCH"
                minimum = "0.8".toBigDecimal()
            }
        }
    }
}

tasks.build {
    dependsOn(tasks.jacocoTestCoverageVerification)
}

allOpen {
    annotation("jakarta.ws.rs.Path")
    annotation("jakarta.enterprise.context.ApplicationScoped")
    annotation("io.quarkus.test.junit.QuarkusTest")
}
