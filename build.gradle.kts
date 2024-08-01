// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        mavenCentral()
        maven {
            url = uri("https://jitpack.io")
        }
    }
    dependencies {
        classpath(libs.hilt.android.gradle.plugin)
        classpath(libs.google.services)
        classpath("com.android.tools.build:gradle:8.5.0")
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.jetbrains.kotlin.android) apply false
    id("com.google.dagger.hilt.android") version ("2.48.1") apply false
    id("com.google.devtools.ksp") version ("1.9.10-1.0.13") apply false
}