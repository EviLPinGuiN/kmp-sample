import com.codingfeline.buildkonfig.compiler.FieldSpec.Type.STRING
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.kotlinCocoapods)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.buildKonfig)
    alias(libs.plugins.sqldelight)
    alias(libs.plugins.composeCompiler)
}

kotlin {
    androidTarget {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_21)
        }
    }
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    cocoapods {
        summary = "Some description for the Shared Module"
        homepage = "Link to the Shared Module homepage"
        version = "1.0"
        ios.deploymentTarget = "16.0"
        podfile = project.file("../iosApp/Podfile")

        framework {
            baseName = "Shared"
            isStatic = true
        }
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.bundles.ktorClientCommon)
                implementation(libs.kotlinx.serialization.core)
                implementation(libs.kotlinx.serialization.json)
                implementation(libs.kotlinx.coroutines.core)
                implementation(libs.kotlinx.datetime)

                implementation(libs.multiplatform.settings)
                implementation(libs.multiplatform.settings.serialization)

                implementation(libs.sqldelight.coroutines.extensions)
                implementation(libs.sqldelight.sqlite.adapter)

                implementation(libs.kodein.di)

                api(libs.androidx.lifecycle.viewmodel)
            }
        }
        androidMain {
            dependencies {
                implementation(libs.ktor.client.okhttp)
                implementation(libs.okhttp3.logging.interceptor)
                implementation(libs.kotlinx.coroutines.android)

                implementation(libs.sqldelight.android.driver)

                implementation(libs.compose.ui)
                implementation(libs.compose.ui.tooling.preview)
                implementation(libs.compose.ui.tooling)
                implementation(libs.compose.material3)
                implementation(libs.compose.runtime)
                implementation(libs.compose.foundation)

                implementation(libs.androidx.lifecycle.runtime)
                implementation(libs.androidx.lifecycle.runtime.compose)
                implementation(libs.androidx.lifecycle.viewmodel.compose)

                implementation(libs.coilCompose)
                implementation(libs.coilNetwork)

                implementation(libs.haze)
                implementation(libs.hazeMaterials)

                implementation(libs.timber)
            }
        }
        iosMain {
            dependencies {
                implementation(libs.ktor.client.ios)
                implementation(libs.sqldelight.native.driver)
            }
        }
        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }
    }
}

buildkonfig {
    packageName = "com.itis.weather"

    defaultConfigs {
        buildConfigField(STRING, "appid", "56fc6c6cb76c0864b4cd055080568268")
    }
}

sqldelight {
    databases {
        create("Database") {
            packageName.set("com.itis.weather")
        }
    }
}

android {
    namespace = "com.itis.weather"
    compileSdk = 36
    defaultConfig {
        minSdk = 26
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    buildFeatures {
        buildConfig = false
        compose = true
    }
}
