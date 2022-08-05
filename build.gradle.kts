buildscript {
    // Library version
    val kotlinVersion by extra("1.7.0")
    val coroutinesVersion by extra("1.6.4")
    val composeVersion by extra("1.3.0-alpha02")
    val accompanistVersion by extra("0.26.0-alpha")

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:7.2.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}

task<Delete>("clean") {
    delete(rootProject.buildDir)
}