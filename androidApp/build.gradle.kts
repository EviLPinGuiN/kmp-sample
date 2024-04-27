import org.jetbrains.kotlin.konan.properties.Properties

plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.googleService)
    alias(libs.plugins.crashlytics)
}

android {
    namespace = "com.itis.weather.android"
    compileSdk = 34
    defaultConfig {
        applicationId = "com.itis.weather.android"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
//            excludes += "META-INF/proguard/okhttp3.pro"
        }
    }
    signingConfigs {
        val DEBUG = "keystore/debug.properties"
        val RELEASE = "keystore/release.properties"

        val STORE_FILE = "keystore.file"
        val STORE_PASSWORD = "keystore.password"
        val KEY_ALIAS = "key.alias"
        val KEY_PASSWORD = "key.password"

        fun getConfig(name: String): Properties? {
            return rootProject.projectDir.resolve(name).takeIf {
                it.exists()
            }?.let { Properties().apply { load(it.inputStream()) } }
        }

        create("release") {
            val config = getConfig(RELEASE) ?: requireNotNull(getConfig(DEBUG))
            storeFile = rootProject.projectDir.resolve(config[STORE_FILE] as String)
            storePassword = config[STORE_PASSWORD] as String
            keyAlias = config[KEY_ALIAS] as String
            keyPassword = config[KEY_PASSWORD] as String
        }
    }
    buildTypes {
        getByName("debug") {
            isDebuggable = true
            isMinifyEnabled = false

            signingConfig = signingConfigs.getByName("debug")
        }
        getByName("release") {
            isDebuggable = false
            isMinifyEnabled = true

            signingConfig = signingConfigs.getByName("release")

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
                *fileTree("proguard").toList().toTypedArray(),
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(projects.shared)

    implementation(libs.compose.ui)
    implementation(libs.compose.ui.tooling.preview)
    implementation(libs.compose.material3)
    implementation(libs.androidx.activity.compose)
    debugImplementation(libs.compose.ui.tooling)

    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.analytics)
    implementation(libs.firebase.crashlytics)
    implementation(libs.firebase.config)

    implementation(libs.androidx.splashscreen)
}
