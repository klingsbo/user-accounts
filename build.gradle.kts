plugins {
    java
    jacoco
    id("io.quarkus")
}

repositories {
    mavenCentral()
    mavenLocal()
}

val quarkusPlatformGroupId: String by project
val quarkusPlatformArtifactId: String by project
val quarkusPlatformVersion: String by project

dependencies {
    implementation(enforcedPlatform("${quarkusPlatformGroupId}:${quarkusPlatformArtifactId}:${quarkusPlatformVersion}"))
    implementation("io.quarkus:quarkus-resteasy-reactive-jackson")
    implementation("io.quarkus:quarkus-hibernate-reactive-panache")
    implementation("io.quarkus:quarkus-reactive-pg-client")
    implementation("io.quarkus:quarkus-arc")
    implementation("io.quarkus:quarkus-resteasy-reactive")

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

tasks.withType<Test> {
    systemProperty("java.util.logging.manager", "org.jboss.logmanager.LogManager")
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
    options.compilerArgs.add("-parameters")
}

tasks.check {
    finalizedBy(tasks.jacocoTestReport, tasks.jacocoTestCoverageVerification) // report is always generated after tests run
}

//tasks.jacocoTestReport {
//    dependsOn(tasks.check) // tests are required to run before generating the report
//}
//
//jacoco {
//
//    excludeClassLoaders = ["*QuarkusClassLoader"]
//    destinationFile = layout.buildDirectory.file("jacoco-quarkus.exec").get().asFile
//}
//
//tasks.test {
//    finalizedBy(tasks.jacocoTestReport)
//    jacocoTestReport.enabled = false
//}

tasks.jacocoTestCoverageVerification {
    executionData.from("$buildDir/jacoco-quarkus.exec")
    violationRules {
        rule {
            limit {
                minimum = "0.95".toBigDecimal()
            }
        }
    }
}
