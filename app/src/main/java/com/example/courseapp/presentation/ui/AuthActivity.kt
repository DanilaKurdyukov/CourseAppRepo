package com.example.courseapp.presentation.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.lifecycleScope
import com.example.courseapp.R
import com.example.courseapp.presentation.vm.AuthViewModel
import com.google.android.material.button.MaterialButton
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import androidx.core.net.toUri

class AuthActivity : AppCompatActivity() {

    private lateinit var txtLogin: EditText
    private lateinit var txtPassword: EditText
    private lateinit var btnSignIn: MaterialButton
    private lateinit var btnVk: MaterialButton
    private lateinit var btnOk: MaterialButton

    private val vm by viewModel<AuthViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        txtLogin = findViewById(R.id.edit_text_login)
        txtPassword = findViewById(R.id.edit_text_password)
        btnSignIn = findViewById(R.id.button_signIn)
        btnVk = findViewById(R.id.button_vk)
        btnOk = findViewById(R.id.button_ok)

        txtLogin.doOnTextChanged { text, _, _, _ ->
            vm.onLoginChanged(value = text.toString())
        }
        txtPassword.doOnTextChanged {
            text, _, _, _ ->
            vm.onPasswordChanged(value = text.toString())
        }

        lifecycleScope.launch {
            vm.uiState.collectLatest { state ->
                btnSignIn.isEnabled = state.isButtonEnabled
            }
        }

        btnSignIn.setOnClickListener {
            vm.signIn(txtLogin.text.toString(), txtPassword.text.toString())
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnVk.setOnClickListener {
            val url = "https://vk.com/"
            val intent = Intent(
                Intent.ACTION_VIEW,
                url.toUri()
            ).apply {
                addCategory(Intent.CATEGORY_BROWSABLE)
            }
            startActivity(intent)
        }

        btnOk.setOnClickListener {
            val url = "https://ok.ru/"
            val intent = Intent(
                Intent.ACTION_VIEW,
                url.toUri()
            ).apply {
                addCategory(Intent.CATEGORY_BROWSABLE)
            }
            startActivity(intent)
        }

    }
}