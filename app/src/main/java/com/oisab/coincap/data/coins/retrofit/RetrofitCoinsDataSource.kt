package com.oisab.coincap.data.coins.retrofit

import com.oisab.coincap.data.coins.CoinsRemoteDataSource
import com.oisab.coincap.data.coins.remote.CoinApi
import com.oisab.coincap.data.coins.remote.CoinAssetsResponse
import kotlinx.coroutines.Deferred

class RetrofitCoinsDataSource(private val coinApi: CoinApi): CoinsRemoteDataSource {
    override suspend fun getCoinAssetsAsync(): Deferred<CoinAssetsResponse> {
        return coinApi.fetchAssetsAsync()
    }
}