package com.oisab.coincap

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Parcel
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlin.random.Random

class UserSettingsFragment : Fragment(R.layout.fragment_user_settings) {
    private lateinit var userSettingsViewModel: UserSettingsViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userSettingsViewModel = ViewModelProvider(this).get(UserSettingsViewModel::class.java)

        saveUserData()
    }

    private fun saveUserData() {
        val userDataSharedPref: SharedPreferences =
            requireActivity().getSharedPreferences("USER_PERSONAL_DATA", Context.MODE_PRIVATE)

        val surnameEditText: AppCompatEditText =
            requireView().findViewById(R.id.userSurname) // Get views
        val nameEditText: AppCompatEditText = requireView().findViewById(R.id.userName)
        val patronymicEditText: AppCompatEditText = requireView().findViewById(R.id.userPatronymic)
        val birthdayEditText: AppCompatEditText = requireView().findViewById(R.id.userBirthdate)
        val countryEditText: AppCompatEditText = requireView().findViewById(R.id.userCountry)
        val cityEditText: AppCompatEditText = requireView().findViewById(R.id.userCity)
        val phoneEditText: AppCompatEditText = requireView().findViewById(R.id.userPhoneNumber)
        val emailEditText: AppCompatEditText = requireView().findViewById(R.id.userEmail)
        val userIdTextView: AppCompatTextView = requireView().findViewById(R.id.userId)
        val saveButton: AppCompatButton = requireView().findViewById(R.id.saveUserDataButton)

        // Save user data in SharedPref
        saveButton.setOnClickListener {
            userSettingsViewModel.saveUserDataInSharedPref(
                userDataSharedPref, UserPersonalData(
                    surnameEditText.text.toString(),
                    nameEditText.text.toString(),
                    patronymicEditText.text.toString(),
                    birthdayEditText.text.toString(),
                    countryEditText.text.toString(),
                    cityEditText.text.toString(),
                    phoneEditText.text.toString(),
                    emailEditText.text.toString(),
                    "id" + (0 until Int.MAX_VALUE).random().toString()
                )
            )
            Toast.makeText(requireContext(), "Saved", Toast.LENGTH_SHORT).show()
        }

        userSettingsViewModel.checkUserData(userDataSharedPref)

        // Show user data in views
        userSettingsViewModel.userPersonalData.observe(viewLifecycleOwner, {
            surnameEditText.setText(it.userSurname)
            nameEditText.setText(it.userName)
            patronymicEditText.setText(it.userPatronymic)
            birthdayEditText.setText(it.userBirthday)
            countryEditText.setText(it.userCountry)
            cityEditText.setText(it.userCity)
            phoneEditText.setText(it.userPhoneNumber)
            emailEditText.setText(it.userEmail)
            userIdTextView.text = it.userId
        })
    }

    companion object {
        const val USER_DATA = "user_data"
    }
}