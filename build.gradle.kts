plugins {
    java
    id("org.springframework.boot") version "2.3.4.RELEASE"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
    jacoco
    id("io.freefair.lombok") version "5.2.1"
}

group = "br.com.docket.regestry"
version = "0.1-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
    jcenter()
}

dependencies {
    val junitVersion = "5.7.0"
    val assertJVersion = "3.17.2"
    val h2Version = "1.4.197"
    val lombokVersion = "1.18.12"

    implementation("org.springframework.boot:spring-boot-starter-web") {
        exclude(module = "spring-boot-starter-tomcat")
    }
    implementation("org.springframework.boot:spring-boot-starter-jetty")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    testImplementation("org.junit.jupiter:junit-jupiter:$junitVersion")
    testImplementation("org.junit.vintage:junit-vintage-engine:$junitVersion")
    testImplementation("org.assertj:assertj-core:$assertJVersion")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(module = "junit")
    }
    runtimeOnly("com.h2database:h2:$h2Version")


}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.jacocoTestReport {
    reports {
        csv.isEnabled = false
        html.isEnabled = false
        xml.isEnabled = true
        xml.destination = File("$buildDir/reports/jacoco/report.xml")
    }
}

tasks.jacocoTestCoverageVerification {
    classDirectories.setFrom(
            sourceSets.main.get().output.asFileTree.matching {
                exclude(

                )
            }
    )
}

val codeCoverage by tasks.registering {
    group = "verification"
    description = "Gradle tests with Code Coverage"

    dependsOn(tasks.test, tasks.jacocoTestReport, tasks.jacocoTestCoverageVerification)

    tasks.findByName("jacocoTestReport")
            ?.mustRunAfter(tasks.findByName("test"))

    tasks.findByName("jacocoTestCoverageVerification")
            ?.mustRunAfter(tasks.findByName("jacocoTestReport"))
}
