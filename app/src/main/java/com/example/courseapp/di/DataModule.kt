package com.example.courseapp.di

import com.example.data.network.ApiService
import com.example.data.repository.AuthRepositoryImpl
import com.example.data.repository.CourseRepositoryImpl
import com.example.domain.repository.AuthRepository
import com.example.domain.repository.CourseRepository
import okhttp3.OkHttpClient
import okio.Timeout
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val dataModule = module {

    single<AuthRepository> {
        AuthRepositoryImpl()
    }

    single<CourseRepository> {
        CourseRepositoryImpl(apiService = get())
    }

    single {
        OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl("https://drive.usercontent.google.com/")
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single<ApiService> { get<Retrofit>().create(ApiService::class.java) }

}