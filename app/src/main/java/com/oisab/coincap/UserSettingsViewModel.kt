package com.oisab.coincap

import android.content.SharedPreferences
import android.os.Parcel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson

class UserSettingsViewModel : ViewModel() {
    val userPersonalData = MutableLiveData<UserPersonalData>()

    fun saveUserDataInSharedPref(
        sharedPref: SharedPreferences,
        userData: UserPersonalData
    ) {
        val jsonString = Gson().toJson(userData)
        sharedPref.edit().putString(UserSettingsFragment.USER_DATA, jsonString).apply()
    }

    fun checkUserData(sharedPref: SharedPreferences) {
        val jsonString = sharedPref.getString(UserSettingsFragment.USER_DATA, "1")
        userPersonalData.postValue(Gson().fromJson(jsonString, UserPersonalData::class.java))
    }
}