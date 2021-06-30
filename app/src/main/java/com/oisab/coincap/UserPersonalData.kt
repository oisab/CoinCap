package com.oisab.coincap

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserPersonalData(
    var userSurname: String,
    var userName: String,
    var userPatronymic: String,
    var userBirthday: String,
    var userCountry: String,
    var userCity: String,
    var userPhoneNumber: String,
    var userEmail: String,
    var userId: String
) : Parcelable