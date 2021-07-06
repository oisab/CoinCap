package com.oisab.coincap.screens.start

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.oisab.coincap.R

class LoginFragment : Fragment(R.layout.fragment_login) {
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val loginButton: Button = view.findViewById(R.id.loginButton)
        val forgotPasswordTextView: AppCompatTextView =
            view.findViewById(R.id.forgotPasswordTextField)
        val registrationTextView: AppCompatTextView = view.findViewById(R.id.registrationTextField)
//        val loginEditText: AppCompatEditText = view.findViewById(R.id.loginTextField)
//        val passwordEditText: AppCompatEditText = view.findViewById(R.id.passwordTextField)

        forgotPasswordTextView.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_forgotPasswordFragment)
        }

        registrationTextView.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
        }

        loginButton.setOnClickListener {
//            if(loginViewModel.validateLogin(loginEditText.text.toString()) && loginViewModel.validatePassword(passwordEditText.text.toString())) {
//                findNavController().navigate(R.id.action_loginFragment_to_menu_navigation_graph)
//            }
//            else
//            Toast.makeText(requireContext(), "Invalid login or password", Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_loginFragment_to_menu_navigation_graph)
        }
    }
}