package com.oisab.coincap.screens.start.login

data class LoginViewState(
    val fetchStatus: FetchStatus,
    val errorMessage: String?
)

sealed class FetchStatus {
    object Empty : FetchStatus()
    object Success : FetchStatus()
    object Error : FetchStatus()
}
