package com.example.data.repository

import com.example.domain.repository.AuthRepository

class AuthRepositoryImpl: AuthRepository {

    override fun signIn(
        login: String,
        password: String
    ): Result<String> {
        return Result.success("Успех!")
    }
}