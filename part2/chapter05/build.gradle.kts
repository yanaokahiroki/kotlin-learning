plugins {
    kotlin("jvm") version "1.8.0"
    id("com.thinkimi.gradle.MybatisGenerator") version "2.4"
}

group = "org.learning"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.mybatis:mybatis:3.5.13")
    implementation("org.mybatis.dynamic-sql:mybatis-dynamic-sql:1.4.1")
    implementation("mysql:mysql-connector-java:8.0.32")
    mybatisGenerator("org.mybatis.generator:mybatis-generator-core:1.4.2")
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain {
        this.languageVersion.set(JavaLanguageVersion.of(17))
    }
}

mybatisGenerator {
    verbose = true
    configFile = "${projectDir}/src/main/resources/generatorConfig.xml"
}
