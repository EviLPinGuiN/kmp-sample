plugins {
    //trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.androidApplication).apply(false)
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinAndroid).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    alias(libs.plugins.kotlinCocoapods).apply(false)
    alias(libs.plugins.kotlinSerialization).apply(false)
    alias(libs.plugins.composeCompiler).apply(false)
    alias(libs.plugins.buildKonfig).apply(false)
    alias(libs.plugins.sqldelight).apply(false)
    alias(libs.plugins.googleService).apply(false)
    alias(libs.plugins.crashlytics).apply(false)
}
