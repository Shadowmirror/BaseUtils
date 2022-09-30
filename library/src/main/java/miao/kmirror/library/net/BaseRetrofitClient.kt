package miao.kmirror.library.net

import android.util.Log
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.security.auth.login.LoginException

abstract class BaseRetrofitClient {
    companion object {
        private var _connectTimeout = 5L
        private var _readTimeout = 5L
        private var _gson = setDefaultGson()
        private var _httpLoggingInterceptor = setDefaultHttpLoggingInterceptor()
        private var _okHttpClient = setDefaultOkHttpClient()

        private fun setDefaultGson() = Gson().newBuilder()
            .setLenient()
            .serializeNulls()
            .create()

        private fun setDefaultHttpLoggingInterceptor() = let {
            val interceptor = HttpLoggingInterceptor { message -> Log.i("Kmirror_Retrofit", message) }
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            interceptor
        }

        private fun setDefaultOkHttpClient() = OkHttpClient.Builder()
            .connectTimeout(_connectTimeout, TimeUnit.SECONDS)
            .readTimeout(_readTimeout, TimeUnit.SECONDS)
            .addInterceptor(_httpLoggingInterceptor)
            .build()

    }

    open fun setConnectTimeout(timeout: Long) {
        _connectTimeout = timeout
        setDefaultOkHttpClient()
    }

    open fun setReadTimeout(timeout: Long) {
        _readTimeout = timeout
        setDefaultOkHttpClient()
    }

    open fun setGson(change: () -> Gson) {
        _gson = change()
    }


    open fun setHttpLoggingInterceptor(change: () -> HttpLoggingInterceptor) {
        _httpLoggingInterceptor = change()
        _okHttpClient = setDefaultOkHttpClient()
    }


    /**
     * 如果使用了此方法，[BaseRetrofitClient.setReadTimeout] 和 [BaseRetrofitClient.setConnectTimeout] 将失效
     * */
    open fun setOkHttpClient(change: () -> OkHttpClient) {
        _okHttpClient = change()
    }

    /**
     * 如果你想更改 [BaseRetrofitClient._okHttpClient],[BaseRetrofitClient._gson],[BaseRetrofitClient._connectTimeout],[BaseRetrofitClient._httpLoggingInterceptor]
     * 或者 [BaseRetrofitClient._readTimeout] 内容可以参照以下对应方法，注意要在 [BaseRetrofitClient.getService] 方法之前 <br>
     *
     * [BaseRetrofitClient._connectTimeout] -> [BaseRetrofitClient.setConnectTimeout]
     *
     * [BaseRetrofitClient._readTimeout] -> [BaseRetrofitClient.setReadTimeout]
     *
     * [BaseRetrofitClient._gson] -> [BaseRetrofitClient.setGson]
     *
     * [BaseRetrofitClient._httpLoggingInterceptor] -> [BaseRetrofitClient.setHttpLoggingInterceptor]
     *
     * [BaseRetrofitClient._okHttpClient] -> [BaseRetrofitClient.setOkHttpClient]
     *
     * 如果你想重写 Service 可以直接重写 [BaseRetrofitClient.getService]
     * */
    open fun <Service> getService(serviceClass: Class<Service>, baseUrl: String): Service {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(_okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(_gson))
            .build()
            .create(serviceClass)
    }
}