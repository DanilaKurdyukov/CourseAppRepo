package com.example.courseapp.di

import androidx.room.Room
import com.example.data.local.DatabaseService
import com.example.data.local.dao.CourseDAO
import com.example.data.remote.ApiService
import com.example.data.repository.AuthRepositoryImpl
import com.example.data.repository.CourseRepositoryImpl
import com.example.domain.repository.AuthRepository
import com.example.domain.repository.CourseRepository
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val dataModule = module {

    single<AuthRepository> {
        AuthRepositoryImpl()
    }

    single {
        Room.databaseBuilder(
            context = get(),
            klass = DatabaseService::class.java,
            name = "CourseDatabase"
        ).build()
    }

    single<CourseDAO> {
        get<DatabaseService>().courseDao()
    }

    single<CourseRepository> {
        CourseRepositoryImpl(
            apiService = get(),
            courseDAO = get())
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