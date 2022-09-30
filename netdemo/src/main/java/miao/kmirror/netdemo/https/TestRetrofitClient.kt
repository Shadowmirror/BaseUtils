package miao.kmirror.netdemo.https

import android.util.Log
import miao.kmirror.library.net.BaseRetrofitClient
import okhttp3.logging.HttpLoggingInterceptor

object TestRetrofitClient : BaseRetrofitClient() {


    val service by lazy {
        setHttpLoggingInterceptor {
            val interceptor = HttpLoggingInterceptor { message -> Log.i("Gmirror_Retrofit", message) }
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            return@setHttpLoggingInterceptor interceptor
        }
        getService(ApiService::class.java, "https://www.wanandroid.com/")
    }


}
