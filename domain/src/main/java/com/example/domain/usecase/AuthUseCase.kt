package com.example.domain.usecase

import com.example.domain.model.AuthResult
import com.example.domain.repository.AuthRepository

class  AuthUseCase(private val repository: AuthRepository) {
    fun execute (login: String, password: String) : AuthResult {
        if(login.isBlank() || password.isBlank()) return AuthResult.Error(message = "Заполните поля!")
        if(!login.contains("@")) return AuthResult.Error(message = "Некорректный e-mail!")
        if(password.length < 6) return AuthResult.Error(message = "Пароль слишком короткий!")
        return repository.signIn(login, password)
    }
}