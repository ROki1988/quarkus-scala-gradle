group = "com.github.aesteve"
version = "0.0.1-SNAPSHOT"

plugins {
    java
    scala
    id("io.quarkus") version("0.23.1")
}

tasks {
   buildNative {
       additionalBuildArgs = listOf("--static", "-O3")
   }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.scala-lang:scala-library:2.13.1")

    // Quarkus
    implementation(enforcedPlatform("io.quarkus:quarkus-bom:0.23.1"))
    implementation("io.quarkus:quarkus-resteasy-jsonb")
    implementation("io.quarkus:quarkus-scala")
}

quarkus {
    setSourceDir(project.projectDir.resolve("src/main/scala").absolutePath)
    setOutputDirectory(project.buildDir.resolve("classes/scala/main").absolutePath)
}
