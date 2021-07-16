package com.oisab.coincap.screens.start.login

import com.oisab.coincap.screens.BaseViewModel

class LoginViewModel : BaseViewModel<LoginViewState, LoginAction, LoginEvent>() {
    lateinit var authData: AuthData

    override fun obtainEvent(viewEvent: LoginEvent) {
        when (viewEvent) {
            LoginEvent.RegistrationClick -> viewState = LoginViewState.NavigateToRegistration
            LoginEvent.ForgotPasswordClick -> viewState = LoginViewState.NavigateToForgotPassword
            LoginEvent.LogInClick -> performLogin(authData)
            else -> { viewState = LoginViewState.Error
                viewAction = LoginAction.ShowMessage("Authorization error")
            }
        }
    }

    private fun performLogin(authData: AuthData) {
        if (validateLogin(authData.login) && validatePassword(authData.password)) {
            viewState = LoginViewState.NavigateToMenu
        } else {
            viewState = LoginViewState.Error
            viewAction = LoginAction.ShowMessage("Invalid login or password")
        }
    }

    private fun validateLogin(login: String): Boolean = login.matches(
        Regex(

            "^[\\w! #\$%&‘*+-/=?^`~.]{1,64}@[\\w! #\$%&‘*+-/=?^`~.]" +
                    "{1,253}\\.[a-z]{2,6}$"
        )
    )

    private fun validatePassword(password: String): Boolean = password.matches(
        Regex(
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])" +
                    "(?=.*[!@#&()–[{}]:;',?/*~\$^+=<>]).{8,32}$"
        )
    )
}