package com.oisab.coincap.screens

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.oisab.coincap.R

class MenuContainerFragment : Fragment(R.layout.fragment_menu_container) {

    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        bottomNavigationView = requireView().findViewById(R.id.navigationMenu)
        bottomNavigationView.setOnItemSelectedListener { item ->
            val res = when (item.itemId) {
                R.id.fragmentNews -> {
                    R.navigation.news_navigation_graph
                }
                R.id.fragmentFavourites -> {
                    R.navigation.favourite_coins_navigation_graph
                }
                R.id.fragmentMyCoins -> {
                    R.navigation.my_coins_navigation_graph
                }
                R.id.fragmentUserSettings -> {
                    R.navigation.user_settings_navigation_graph
                }
                else -> {
                    R.navigation.news_navigation_graph
                }
            }
            val navHostFragment = NavHostFragment.create(res)
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.menuFragmentNavHost, navHostFragment)
                ?.commitNow()
            true
        }
        bottomNavigationView.selectedItemId = R.id.fragmentNews
    }
}