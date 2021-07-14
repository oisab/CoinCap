package com.oisab.coincap.screens.start.login

import com.oisab.coincap.screens.BaseViewModel
import com.oisab.coincap.screens.start.AuthData
import com.oisab.coincap.screens.start.LoginEvent
import com.oisab.coincap.screens.start.login.LoginViewState

class LoginViewModel : BaseViewModel<LoginViewState, LoginAction, LoginEvent>() {
    lateinit var authData: AuthData

    init {
        viewState = LoginViewState.Empty
    }

    override fun obtainEvent(viewEvent: LoginEvent) {
        viewState = when (viewEvent) {
            LoginEvent.LogInClick -> if (performLogin(authData)) {
                LoginViewState.Success
            } else {
                LoginViewState.Error("Invalid login or password")
            }
            else -> LoginViewState.Error("Authorization error")
        }
    }

    private fun performLogin(authData: AuthData): Boolean =
        validateLogin(authData.login) && validatePassword(authData.password)

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