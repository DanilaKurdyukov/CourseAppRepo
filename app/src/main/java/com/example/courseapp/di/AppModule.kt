package com.example.courseapp.di

import com.example.courseapp.presentation.vm.AuthViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<AuthViewModel> {
        AuthViewModel(authUseCase = get())
    }
}