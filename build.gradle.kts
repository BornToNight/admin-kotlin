val kotlinVer: String by project // 2.1.0
val springBootStarterVer: String by project // 3.3.1-SNAPSHOT
val jacksonKotlinVer: String by project // 2.18.2
val springAdminVer: String by project // 3.4.1
val junitVer: String by project // 1.11.0-M2

plugins {
    kotlin("jvm") version "2.1.0"
    kotlin("plugin.spring") version "2.1.0"
    id("org.springframework.boot") version "3.4.2-SNAPSHOT"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "ru.pachan"
version = "1.0"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
    maven { url = uri("https://repo.spring.io/snapshot") }
}

extra["springBootAdminVersion"] = "3.4.1"

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect:$kotlinVer")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonKotlinVer")
    implementation("org.springframework.boot:spring-boot-starter-security:$springBootStarterVer")
    implementation("org.springframework.boot:spring-boot-starter-web:$springBootStarterVer")
    implementation("de.codecentric:spring-boot-admin-starter-server:$springAdminVer")
    testImplementation("org.springframework.boot:spring-boot-starter-test:$springBootStarterVer")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:$kotlinVer")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:$junitVer")
}

dependencyManagement {
    imports {
        mavenBom("de.codecentric:spring-boot-admin-dependencies:${property("springBootAdminVersion")}")
    }
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
