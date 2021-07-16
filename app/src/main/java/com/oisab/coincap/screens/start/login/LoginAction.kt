package com.oisab.coincap.screens.start.login

data class LoginAction(
    val loginEffects: LoginEffects,
    val message: String?
)

sealed class LoginEffects {
    object ShowMessage: LoginEffects()
}