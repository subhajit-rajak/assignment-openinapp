import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id ("com.google.devtools.ksp")
    id("kotlin-kapt")
    id ("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
}

fun getProps(propName: String): String? {
    val propsFile = rootProject.file("local.properties")
    return if (propsFile.exists()) {
        val props = Properties()
        props.load(FileInputStream(propsFile))
        props[propName]?.toString()
    } else {
        null
    }
}

android {
    namespace = "com.subhajitrajak.assignmentopeninapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.subhajitrajak.assignmentopeninapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug{
            isDebuggable = true
            buildConfigField("String", "BEARER_TOKEN", "\"${getProps("BEARER_TOKEN")}\"")
            buildConfigField("String", "API_URL", "\"${getProps("API_URL")}\"")
        }
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    implementation(libs.mpandroidchart)
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.logging.interceptor)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.glide)
    implementation(libs.shimmer)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.lottie)

    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    implementation(libs.androidx.hilt.common)
    implementation(libs.androidx.lifecycle.runtime.ktx)
}