package com.oisab.coincap

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.*

class FavouriteCoinsViewModel(private val coinApi: CoinApi): ViewModel() {

    private var myJob: Job? = null

    fun getCoins() { //rename after
        myJob = viewModelScope.launch {
            val result = getCoinAssetsAsync(coinApi)
            withContext(Dispatchers.IO) {
                Log.e("TAG", result.toString())
            }
        }
    }

     private suspend fun getCoinAssetsAsync(coinApi: CoinApi): List<CoinAssetsResponse> {
        return coinApi.fetchAssetsAsync().await()
    }
}