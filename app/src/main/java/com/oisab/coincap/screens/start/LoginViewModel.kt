package com.oisab.coincap.screens.start

import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    fun validateLogin(login: String): Boolean = login.matches(
        Regex(
            "^[\\w! #\$%&‘*+-/=?^`~.]{1,64}@[\\w! #\$%&‘*+-/=?^`~.]" +
                    "{1,253}\\.[a-z]{2,6}$"
        )
    )

    fun validatePassword(password: String): Boolean = password.matches(
        Regex(
            "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])" +
                    "(?=.*[!@#&()–[{}]:;',?/*~\$^+=<>]).{8,32}$"
        )
    )
}