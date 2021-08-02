package com.dub.data.module


import com.dub.data.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object RetrofitModule {

    val modules = module {
        single<Retrofit> {
            Retrofit.Builder()
                .client(get() as OkHttpClient)
                .addConverterFactory(get() as Converter.Factory)
                .baseUrl("https://ey3f2y0nre.execute-api.us-east-1.amazonaws.com/")
                .build()
        }

        single<Gson> {
            val gsonBuilder = GsonBuilder()
            gsonBuilder.create()
        }

        single<Converter.Factory> {
            GsonConverterFactory.create(get())
        }

        single {
            OkHttpClient.Builder()
                .addInterceptor(get() as HttpLoggingInterceptor)
                .connectTimeout(300, TimeUnit.SECONDS)
                .callTimeout(300, TimeUnit.SECONDS)
                .readTimeout(300, TimeUnit.SECONDS)
                .build()
        }


        single {
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            if (BuildConfig.DEBUG)
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
            else
                httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.NONE

            httpLoggingInterceptor
        }
    }

}