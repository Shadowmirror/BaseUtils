/**
 * 项目依赖版本统一管理
 *
 */
object DependencyConfig {

    /**
     * 依赖版本号
     */
    object Version {

        // AndroidX--------------------------------------------------------------
        const val AppCompat = "1.5.1"
        const val CoreKtx = "1.7.0"
        const val ConstraintLayout = "2.1.3"                // 约束布局

        const val ActivityKtx = "1.5.1"
        const val FragmentKtx = "1.5.2"

        // Test
        const val Junit = "4.13.2"
        const val TestExtJunit = "1.1.3"
        const val TestEspresso = "3.4.0"

        // Android---------------------------------------------------------------

        const val Material = "1.6.1"                        // 材料设计UI套件

        // Kotlin----------------------------------------------------------------
        const val Kotlin = "1.7.10"
        const val Coroutines = "1.6.1"                      // 协程

        // JetPack---------------------------------------------------------------
        const val Lifecycle = "2.5.1"                       // Lifecycle相关（ViewModel & LiveData & Lifecycle）
        const val Room = "2.4.3"

        // GitHub----------------------------------------------------------------
        const val OkHttp = "4.9.0"                          // OkHttp
        const val OkHttpInterceptorLogging = "4.9.1"        // OkHttp 请求Log拦截器
        const val Retrofit = "2.9.0"                        // Retrofit
        const val RetrofitConverterGson = "2.9.0"           // Retrofit Gson 转换器
        const val Gson = "2.8.7"                            // Gson
        const val MMKV = "1.2.9"                            // 腾讯 MMKV 替代SP
        const val PermissionX = "1.4.0"                     // 权限申请
        const val LeakCanary = "2.9.1"                        // 检测内存泄漏
        const val XPopup = "2.9.0"                          // 弹窗
        const val MultiType = "4.3.0"                       // MultiType
        const val LiveEventBus = "1.8.0"                    // 消息总线
    }

    /**
     * AndroidX相关依赖
     */
    object AndroidX {
        const val AndroidJUnitRunner = "androidx.test.runner.AndroidJUnitRunner"
        const val AppCompat = "androidx.appcompat:appcompat:${Version.AppCompat}"
        const val CoreKtx = "androidx.core:core-ktx:${Version.CoreKtx}"
        const val ConstraintLayout =
            "androidx.constraintlayout:constraintlayout:${Version.ConstraintLayout}"
        const val ActivityKtx = "androidx.activity:activity-ktx:${Version.ActivityKtx}"
        const val FragmentKtx = "androidx.fragment:fragment-ktx:${Version.FragmentKtx}"
    }

    /**
     * Test 相关依赖
     * */
    object Test {
        const val TestExtJunit = "androidx.test.ext:junit:${Version.TestExtJunit}"
        const val TestEspresso = "androidx.test.espresso:espresso-core:${Version.TestEspresso}"
        const val Junit = "junit:junit:${Version.Junit}"
    }

    /**
     * Android相关依赖
     */
    object Android {
        const val Material = "com.google.android.material:material:${Version.Material}"
    }

    /**
     * JetPack相关依赖
     */
    object JetPack {
        const val ViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.Lifecycle}"
        const val ViewModelSavedState = "androidx.lifecycle:lifecycle-viewmodel-savedstate:${Version.Lifecycle}"
        const val LiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.Lifecycle}"
        const val Lifecycle = "androidx.lifecycle:lifecycle-runtime-ktx:${Version.Lifecycle}"
        const val LifecycleCompilerAPT = "androidx.lifecycle:lifecycle-compiler:${Version.Lifecycle}"
        const val RoomRuntime = "androidx.room:room-runtime:${Version.Room}"
        const val RoomCompiler = "androidx.room:room-compiler:${Version.Room}"
        const val RoomKtx = "androidx.room:room-ktx:${Version.Room}"
    }

    /**
     * Kotlin相关依赖
     */
    object Kotlin {
        const val Kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Version.Kotlin}"
        const val CoroutinesCore =
            "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Version.Coroutines}"
        const val CoroutinesAndroid =
            "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.Coroutines}"
    }

    /**
     * GitHub及其他相关依赖
     */
    object GitHub {
        const val OkHttp = "com.squareup.okhttp3:okhttp:${Version.OkHttp}"
        const val OkHttpInterceptorLogging =
            "com.squareup.okhttp3:logging-interceptor:${Version.OkHttpInterceptorLogging}"
        const val Retrofit = "com.squareup.retrofit2:retrofit:${Version.Retrofit}"
        const val RetrofitConverterGson =
            "com.squareup.retrofit2:converter-gson:${Version.RetrofitConverterGson}"
        const val Gson = "com.google.code.gson:gson:${Version.Gson}"
        const val MMKV = "com.tencent:mmkv-static:${Version.MMKV}"
        const val PermissionX = "com.permissionx.guolindev:permissionx:${Version.PermissionX}"
        const val LeakCanary = "com.squareup.leakcanary:leakcanary-android:${Version.LeakCanary}"
        const val XPopup = "com.github.li-xiaojun:XPopup:${Version.XPopup}"
        const val MultiType = "com.drakeet.multitype:multitype:${Version.MultiType}"
        const val LiveEventBus = "io.github.jeremyliao:live-event-bus-x:${Version.LiveEventBus}"

    }

}