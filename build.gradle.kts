import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  kotlin("jvm")
  id("org.springframework.boot") version "3.2.0"
  id("org.jetbrains.compose")
}

group = "me.ionas"
version = "1.0-SNAPSHOT"

repositories {
  mavenCentral()
  maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
  google()
}

dependencies {
  val voyagerVersion = "1.0.0-rc10"
  val ktor_version = "2.3.6"
  val springVersion = "6.1.1"
  val jakartaVersion = "2.1.1"
  // Note, if you develop a library, you should use compose.desktop.common.
  // compose.desktop.currentOs should be used in launcher-sourceSet
  // (in a separate module for demo project and in testMain).
  // With compose.desktop.common you will also lose @Preview functionality
  implementation(compose.desktop.currentOs)
  implementation(compose.material3)
  implementation("cafe.adriel.voyager:voyager-navigator:$voyagerVersion")
  implementation("io.ktor:ktor-client-websockets:$ktor_version")
  implementation("io.ktor:ktor-client-cio:$ktor_version")
  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-swing:1.7.3")

  implementation("org.springframework.boot:spring-boot-starter-websocket:3.2.0")
  implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.16.0")

  implementation("org.springframework:spring-websocket:$springVersion")
  implementation("org.springframework:spring-messaging:$springVersion")
  implementation("jakarta.websocket:jakarta.websocket-api:$jakartaVersion")
  // https://mvnrepository.com/artifact/org.glassfish.tyrus.bundles/tyrus-standalone-client
  implementation("org.glassfish.tyrus.bundles:tyrus-standalone-client:2.1.4")
}

compose.desktop {

  application {
    mainClass = "MainKt"

    nativeDistributions {
      targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
      packageName = "Coldwars"
      packageVersion = "1.0.0"
    }
  }
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
  languageVersion = "1.9"
}