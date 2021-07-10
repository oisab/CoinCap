package com.oisab.coincap.screens.favourite

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.oisab.coincap.data.coins.remote.CoinApi
import com.oisab.coincap.R
import com.oisab.coincap.di.ViewModelFactory
import com.oisab.coincap.screens.favourite.adapter.FavouriteCoinCellModel
import com.oisab.coincap.screens.favourite.adapter.FavouriteCoinsAdapter
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class FavouriteCoinsFragment : Fragment(R.layout.fragment_favourite_coins) {
    @Inject lateinit var coinApi: CoinApi
    @Inject lateinit var viewModelFactory: ViewModelFactory
    private lateinit var favouriteCoinsViewModel: FavouriteCoinsViewModel
    private val favouriteCoinsAdapter = FavouriteCoinsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onCreate(savedInstanceState)

        favouriteCoinsViewModel = ViewModelProvider(this, viewModelFactory).get(FavouriteCoinsViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val favouriteCoinsRecyclerView: RecyclerView = view.findViewById(R.id.favouriteCoinsRecyclerView)
        favouriteCoinsRecyclerView.adapter = favouriteCoinsAdapter
        favouriteCoinsRecyclerView.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)

        favouriteCoinsViewModel.getCoins()
        favouriteCoinsViewModel.favouriteCoins.observe(viewLifecycleOwner, {
            favouriteCoinsAdapter.setData(it)
        })
    }
}