package com.example.courseapp.di

import com.example.data.repository.AuthRepositoryImpl
import com.example.domain.repository.AuthRepository
import org.koin.dsl.module

val dataModule = module {

    single<AuthRepository> {
        AuthRepositoryImpl()
    }

}