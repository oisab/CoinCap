package com.oisab.coincap

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class LoginFragment: Fragment(R.layout.fragment_login) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val loginButton: Button = view.findViewById(R.id.loginButton)
        val forgotPasswordTextView: AppCompatTextView = view.findViewById(R.id.forgotPasswordTextField)
        val registrationTextView: AppCompatTextView = view.findViewById(R.id.registrationTextField)

        forgotPasswordTextView.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_forgotPasswordFragment)
        }

        registrationTextView.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
        }

        loginButton.setOnClickListener{
            findNavController().navigate(R.id.action_loginFragment_to_menu_navigation_graph)
        }
    }
}