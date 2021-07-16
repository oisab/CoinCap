package com.oisab.coincap.screens.start.login

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
        val forgotPasswordTextView: AppCompatTextView = view.findViewById(R.id.forgotPasswordTextField)
        val registrationTextView: AppCompatTextView = view.findViewById(R.id.registrationTextField)
        val loginEditText: AppCompatEditText = view.findViewById(R.id.loginTextField)
        val passwordEditText: AppCompatEditText = view.findViewById(R.id.passwordTextField)

        loginViewModel.viewStates().observe(viewLifecycleOwner, { bindViewState(it) })
//        loginViewModel.viewActions().observe(viewLifecycleOwner, { bindViewAction(it) })

        forgotPasswordTextView.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_forgotPasswordFragment)
        }

        registrationTextView.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment)
        }

        loginButton.setOnClickListener {
            loginViewModel.authData = AuthData(loginEditText.text.toString(), passwordEditText.text.toString())
            loginViewModel.obtainEvent(LoginEvent.LogInClick)
        }
    }

    private fun bindViewState(viewState: LoginViewState) {
        when (viewState.fetchStatus) {
            FetchStatus.Success -> findNavController().navigate(R.id.action_loginFragment_to_menu_navigation_graph)
            FetchStatus.Error -> bindViewAction(LoginAction(LoginEffects.ShowMessage, viewState.errorMessage))
            else -> {
                FetchStatus.Empty
            }
        }
    }

    private fun bindViewAction(viewAction: LoginAction) {
        when(viewAction.loginEffects) {
            LoginEffects.ShowMessage -> Toast.makeText(requireContext(), viewAction.message, Toast.LENGTH_SHORT).show()
        }
    }
}