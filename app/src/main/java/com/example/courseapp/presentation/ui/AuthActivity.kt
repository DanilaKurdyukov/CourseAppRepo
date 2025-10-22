package com.example.courseapp.presentation.ui

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.courseapp.R
import com.example.courseapp.presentation.vm.AuthViewModel
import com.example.domain.model.AuthResult
import com.google.android.material.button.MaterialButton
import org.koin.androidx.viewmodel.ext.android.viewModel

class AuthActivity : AppCompatActivity() {

    private lateinit var txtEmail: EditText
    private lateinit var txtPassword: EditText
    private lateinit var btnSignIn: MaterialButton

    private val vm by viewModel<AuthViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        txtEmail = findViewById(R.id.edit_text_email)
        txtPassword = findViewById(R.id.edit_text_password)
        btnSignIn = findViewById(R.id.button_signIn)

        btnSignIn.setOnClickListener {
            vm.getResult(txtEmail.text.toString(), txtPassword.text.toString())

        }



    }
}