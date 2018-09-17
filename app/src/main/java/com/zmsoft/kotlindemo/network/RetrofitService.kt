package com.zmsoft.kotlindemo.network

import com.facebook.stetho.okhttp3.StethoInterceptor
import com.google.gson.Gson
import com.zmsoft.kotlindemo.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitService{

    companion object {
        private const val BASE_URL: String = "https://newsapi.org/v2/"

        private const val CONNECT_TIMEOUT = 10L
        private const val READ_TIMEOUT = 10L
        private const val WRITE_TIMEOUT = 20L


        private var okHttpClient: OkHttpClient? = null

        private val lock = Object()

        //得到Retrofit实例
        private var retrofit: Retrofit? = null
            get() {
                if (field == null) {
                    synchronized(lock) {
                        if (field == null) {
                            val builder:OkHttpClient.Builder = OkHttpClient().newBuilder()
                            val httpLoggingInterceptor = HttpLoggingInterceptor()

                            builder.connectTimeout(CONNECT_TIMEOUT , TimeUnit.SECONDS)
                                    .readTimeout(READ_TIMEOUT , TimeUnit.SECONDS)
                                    .writeTimeout(WRITE_TIMEOUT , TimeUnit.SECONDS)
                                    .retryOnConnectionFailure(true)

                            if (BuildConfig.DEBUG){
                                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
                                builder.addInterceptor(httpLoggingInterceptor)
                                builder.addNetworkInterceptor(StethoInterceptor())
                            }

                            okHttpClient = builder.build()

                            retrofit = Retrofit.Builder().client(okHttpClient)
                                    .baseUrl(BASE_URL)
                                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                                    .addConverterFactory(GsonConverterFactory.create(Gson()))
                                    .build()

                        }
                    }
                }
                return field
            }



        //得到新闻API实例
        val newsApi: NewsApi by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) {
            retrofit!!.create(NewsApi::class.java)
        }
    }



}