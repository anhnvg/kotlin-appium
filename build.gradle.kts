import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("io.qameta.allure.gradle.report:allure-report-plugin:2.11.2")
    }
}
plugins {
    kotlin("jvm") version "1.7.10"
    id("io.qameta.allure-report") version "2.11.2"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

apply(plugin = "io.qameta.allure-report")

dependencies {
    testImplementation(kotlin("test"))
    implementation("io.appium:java-client:8.2.0")
    implementation("org.testng:testng:7.0.0")
    implementation("io.insert-koin:koin-core:3.0.1")
    implementation("org.slf4j:slf4j-api:1.7.30")
}

tasks.test {
    useJUnitPlatform()
    useTestNG(){
        useDefaultListeners = true
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}