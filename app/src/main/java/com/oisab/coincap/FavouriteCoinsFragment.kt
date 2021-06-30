package com.oisab.coincap

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class FavouriteCoinsFragment: Fragment(R.layout.fragment_favourite_coins) {
//    @Inject lateinit var coinApi: CoinApi
//    @Inject lateinit var viewModelFactory: ViewModelFactory
//    lateinit var favouriteCoinsViewModel: FavouriteCoinsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
//        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)

//        favouriteCoinsViewModel = ViewModelProvider(this, viewModelFactory).get(FavouriteCoinsViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        favouriteCoinsViewModel.getCoins()
    }
}