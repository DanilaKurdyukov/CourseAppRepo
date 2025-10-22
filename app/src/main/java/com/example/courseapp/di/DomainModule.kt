package com.example.courseapp.di

import com.example.domain.usecase.AuthUseCase
import org.koin.dsl.module

val domainModule = module {

    single<AuthUseCase> {
        AuthUseCase(repository = get())
    }

}