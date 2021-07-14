package com.oisab.coincap.screens.start.login

sealed class LoginAction {
    class ShowMessage(val message: String): LoginAction()
}