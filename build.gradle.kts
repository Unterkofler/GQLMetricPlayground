import java.util.regex.Pattern.compile

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.6.21"
    id("org.jetbrains.kotlin.kapt") version "1.6.21"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.6.21"
    id("com.github.johnrengelman.shadow") version "7.1.2"
    id("io.micronaut.application") version "3.4.1"
}

version = "0.1"
group = "graph.ql"

val kotlinVersion=project.properties.get("kotlinVersion")
repositories {
    mavenCentral()
}


dependencies {
    kapt("io.micronaut:micronaut-http-validation")
    implementation("io.micronaut:micronaut-http-client")
    implementation("io.micronaut:micronaut-jackson-databind")
    implementation("io.micronaut.kotlin:micronaut-kotlin-runtime")
    implementation("jakarta.annotation:jakarta.annotation-api")
    implementation("org.jetbrains.kotlin:kotlin-reflect:${kotlinVersion}")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${kotlinVersion}")
    runtimeOnly("ch.qos.logback:logback-classic")
    implementation("io.micronaut:micronaut-validation")

    implementation("io.micronaut.micrometer:micronaut-micrometer-registry-prometheus")
    implementation("io.micronaut.graphql:micronaut-graphql")
    implementation("com.expediagroup:graphql-kotlin-schema-generator:5.5.0")
    runtimeOnly("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("com.graphql-java:graphql-java-extended-scalars:17.0")

    // https://mavenlibs.com/maven/dependency/org.webjars.npm/graphql-subscriptions
    implementation("org.webjars.npm:graphql-subscriptions:0.4.4")

    kaptTest("io.micronaut:micronaut-inject-java")
    testImplementation("io.micronaut.test:micronaut-test-junit5")
    testImplementation("io.mockk:mockk")
    testImplementation("io.micronaut.test:micronaut-test-kotest5")
    testRuntimeOnly("io.kotest:kotest-runner-junit5-jvm")

    compile("com.graphql-java:graphql-java-extended-scalars:18.1")

}


application {
    mainClass.set("graph.ql.ApplicationKt")
}
java {
    sourceCompatibility = JavaVersion.toVersion("11")
}

tasks {
    compileKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
}
graalvmNative.toolchainDetection.set(false)
micronaut {
    runtime("netty")
    testRuntime("junit5")
    processing {
        incremental(true)
        annotations("graph.ql.*")
    }
}