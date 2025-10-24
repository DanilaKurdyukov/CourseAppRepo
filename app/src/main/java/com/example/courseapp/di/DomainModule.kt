package com.example.courseapp.di

import com.example.domain.usecase.AuthUseCase
import com.example.domain.usecase.GetLocalCourseUseCase
import com.example.domain.usecase.GetRemoteCourseUseCase
import com.example.domain.usecase.InsertCourseUseCase
import org.koin.dsl.module

val domainModule = module {

    single<AuthUseCase> {
        AuthUseCase(repository = get())
    }

    single<GetRemoteCourseUseCase> {
        GetRemoteCourseUseCase(courseRepository = get())
    }

    single<GetLocalCourseUseCase> {
        GetLocalCourseUseCase(courseRepository = get())
    }

    single<InsertCourseUseCase> {
        InsertCourseUseCase(courseRepository = get())
    }

}