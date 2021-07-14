package com.oisab.coincap.screens.start.login

sealed class LoginViewState {
    object Empty: LoginViewState()
    object Success : LoginViewState()
    class Error(val message: String) : LoginViewState()
}
