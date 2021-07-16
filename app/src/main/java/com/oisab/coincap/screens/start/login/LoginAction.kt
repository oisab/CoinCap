package com.oisab.coincap.screens.start.login

sealed class LoginAction {
    data class ShowMessage(val message: String?) : LoginAction()
}