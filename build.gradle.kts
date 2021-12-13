buildscript {
    // Library version
    val kotlinVersion by extra("1.6.0")
    val coroutinesVersion by extra("1.5.2")
    val composeVersion by extra("1.1.0-beta04")
    val accompanistVersion by extra("0.21.3-beta")

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:7.0.4")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}