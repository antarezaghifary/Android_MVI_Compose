plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = Config.namespaceBaseApi
    compileSdk = Config.compiledSDK

    defaultConfig {
        minSdk = Config.minSdk
        targetSdk = Config.targetSdk

        testInstrumentationRunner = Config.testInstrumentationRunner
        consumerProguardFiles(Dependency.Proguard.CONSUMER_RULES)
    }

    buildTypes {
        release {
            isMinifyEnabled = Config.isMinifyEnabled
            proguardFiles(
                getDefaultProguardFile(Dependency.Proguard.ANDROID_OPTIMIZED),
                Dependency.Proguard.PROGUARD_RULES
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = Config.jvmTarget
    }
}

dependencies {

    implementation(Dependency.CoreLibrary.KTX)
    implementation(Dependency.APILibrary.KTOR_CORE)
    implementation(Dependency.APILibrary.KTOR_ANDROID)
    implementation(Dependency.APILibrary.KTOR_SERIALIZATION)
    testImplementation(Dependency.TestLibrary.JUNIT)
    androidTestImplementation(Dependency.TestLibrary.EXT_JUNIT)
    androidTestImplementation(Dependency.TestLibrary.ESPRESSO_CORE)
}