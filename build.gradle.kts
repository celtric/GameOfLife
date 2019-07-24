import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.3.41"
    jacoco
}

group = "celtric.katas"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.junit.jupiter:junit-jupiter:5.5.1")
}

tasks.test {
    useJUnitPlatform()
    finalizedBy(tasks.jacocoTestCoverageVerification)
}

jacoco {
    toolVersion = "0.8.4"
    reportsDir = file("$buildDir/customJacocoReportDir")
}

tasks.jacocoTestCoverageVerification {
    violationRules {
        rule {
            excludes = listOf("celtric.katas.gameoflife.acceptance.*")

            limit {
                counter = "LINE"
                value = "TOTALCOUNT"
                maximum = 0.toBigDecimal()
            }
        }
    }
}

tasks.getting(KotlinCompile::class) {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}