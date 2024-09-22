
plugins {
    kotlin("jvm")
}

group = "com.around"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // include for JVM target
    implementation("org.jetbrains.kotlinx:kotlinx-html-jvm:0.11.0")
    // include for JS target
    implementation("org.jetbrains.kotlinx:kotlinx-html:0.11.0")
    testImplementation(kotlin("test"))

}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}