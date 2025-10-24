package com.example.courseapp.presentation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.courseapp.R
import com.google.android.material.textview.MaterialTextView


class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    private lateinit var rowSupport: View
    private lateinit var rowSettings: View
    private lateinit var rowLogOut: View

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rowSupport = view.findViewById(R.id.row_support)
        rowSettings = view.findViewById(R.id.row_settings)
        rowLogOut = view.findViewById(R.id.row_logOut)
    }

    override fun onResume() {
        super.onResume()

        rowSupport.findViewById<MaterialTextView>(R.id.text_view_actionName).text = "Написать в поддержку"
        rowSettings.findViewById<MaterialTextView>(R.id.text_view_actionName).text = "Настройки"
        rowLogOut.findViewById<MaterialTextView>(R.id.text_view_actionName).text = "Выйти из аккаунта"
    }
}