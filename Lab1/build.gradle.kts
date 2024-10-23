plugins {
    kotlin("jvm") version "1.7.20" // Adjust the version as needed
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // JUnit 5 for testing
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // Jackson dependencies for JSON and XML serialization
    implementation("com.fasterxml.jackson.core:jackson-databind:2.14.0") // For JSON
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.14.0")
    implementation("com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.14.0") // For XML
    implementation ("com.fasterxml.jackson.dataformat:jackson-dataformat-yaml:2.15.0")

    // SnakeYAML dependency for YAML serialization
    implementation("org.yaml:snakeyaml:1.30") // For YAML
}

tasks.test {
    useJUnitPlatform()
}
