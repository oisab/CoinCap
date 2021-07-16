package com.oisab.coincap.screens.start.login

sealed class LoginViewState{
    object NavigateToMenu : LoginViewState()
    object NavigateToForgotPassword : LoginViewState()
    object NavigateToRegistration : LoginViewState()
    object Error : LoginViewState()
}