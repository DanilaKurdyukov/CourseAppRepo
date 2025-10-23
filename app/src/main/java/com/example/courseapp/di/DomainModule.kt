package com.example.courseapp.di

import com.example.domain.usecase.AuthUseCase
import com.example.domain.usecase.GetCourseUseCase
import org.koin.dsl.module

val domainModule = module {

    single<AuthUseCase> {
        AuthUseCase(repository = get())
    }

    single<GetCourseUseCase> {
        GetCourseUseCase(courseRepository = get())
    }

}