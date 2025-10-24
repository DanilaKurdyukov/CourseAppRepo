package com.example.courseapp.di

import com.example.courseapp.presentation.vm.AuthViewModel
import com.example.courseapp.presentation.vm.CourseViewModel
import com.example.courseapp.presentation.vm.FavoriteCourseViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<AuthViewModel> {
        AuthViewModel(authUseCase = get())
    }

    viewModel<CourseViewModel> {
        CourseViewModel(
            courseUseCase = get(),
            insertCourseUseCase = get())
    }

    viewModel<FavoriteCourseViewModel> {
        FavoriteCourseViewModel(getLocalCourseUseCase = get())
    }

}