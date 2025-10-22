package com.example.domain.usecase

import com.example.domain.repository.AuthRepository

class  AuthUseCase(private val repository: AuthRepository) {
    fun execute (login: String, password: String) : Result<String> {
        try {
            if(login.isBlank() || password.isBlank()) throw Exception("Заполните поля!")
            if(!login.contains("@")) throw Exception("Некорректный e-mail!")
            if(password.length < 6) throw Exception("Пароль слишком короткий!")
            return repository.signIn(login, password)
        }
        catch (ex: Exception) {
            return Result.failure(ex)
        }
    }
}