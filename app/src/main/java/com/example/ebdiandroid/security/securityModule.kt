package com.example.ebdiandroid.security

import com.example.ebdiandroid.BuildConfig
import com.example.ebdiandroid.security.APIConstants.BASE_URL
import com.example.ebdiandroid.security.APIConstants.CALL_TIMEOUT
import com.example.ebdiandroid.security.APIConstants.READ_TIMEOUT
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val securityModule = module {

    fun provideGson(): Gson = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
        .create()

    fun  provideHttpClient(): OkHttpClient  {
        val logInterceptor = HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }

        return  OkHttpClient.Builder()
            .addInterceptor(logInterceptor)
            .callTimeout(CALL_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .build()
    }

    fun provideRetrofit(factory: Gson, client: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(factory))
            .client(client)
            .build()
    }
    single { provideGson() }
    single { provideHttpClient() }
    single { provideRetrofit(get(), get()) }
}