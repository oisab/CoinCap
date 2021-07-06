package com.oisab.coincap.data.coins

import com.oisab.coincap.data.coins.remote.CoinAssetsResponse
import kotlinx.coroutines.Deferred

interface CoinsRemoteDataSource {

    suspend fun getCoinAssetsAsync(): Deferred<CoinAssetsResponse>
}