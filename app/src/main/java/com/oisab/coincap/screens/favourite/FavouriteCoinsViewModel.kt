package com.oisab.coincap.screens.favourite

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oisab.coincap.data.coins.CoinsRepository
import com.oisab.coincap.data.coins.remote.CoinAssetsResponse
import com.oisab.coincap.screens.favourite.adapter.FavouriteCoinCellModel
import kotlinx.coroutines.*
import javax.inject.Inject
import com.oisab.coincap.screens.favourite.adapter.mapToUI

class FavouriteCoinsViewModel @Inject constructor(private val coinsRepository: CoinsRepository) :
    ViewModel() {
    val favouriteCoins = MutableLiveData<ArrayList<FavouriteCoinCellModel>>()

    private var myJob: Job? = null

    fun getCoins() {
        myJob = viewModelScope.launch {
            withContext(Dispatchers.IO) {
                favouriteCoins.postValue(getLocalCoinAssetsAsync().data.mapToUI())
                favouriteCoins.postValue(getRemoteCoinAssetsAsync().data.mapToUI())
            }
        }
    }

    private suspend fun getLocalCoinAssetsAsync(): CoinAssetsResponse {
        return coinsRepository.fetchLocalCoinAssetsAsync().await()
    }

    private suspend fun getRemoteCoinAssetsAsync(): CoinAssetsResponse {
        return coinsRepository.fetchRemoteCoinAssetsAsync().await()
    }
}