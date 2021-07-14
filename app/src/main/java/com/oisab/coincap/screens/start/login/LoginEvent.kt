package com.oisab.coincap.screens.start

sealed class LoginEvent {
//    object ScreenShown: LoginEvent()
    object LogInClick: LoginEvent()
//    object RegistrationClick: LoginEvent()
//    object ForgotPasswordClick: LoginEvent()
}

data class AuthData(
    var login: String,
    var password: String
) : LoginEvent()