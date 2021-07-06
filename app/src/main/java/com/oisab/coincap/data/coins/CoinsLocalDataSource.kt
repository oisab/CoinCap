package com.oisab.coincap.data.coins

import com.oisab.coincap.data.coins.remote.CoinAssetsResponse
import com.oisab.coincap.data.coins.room.dao.CoinsEntity

interface CoinsLocalDataSource {

    suspend fun loadAllCoinsAsync(): List<CoinsEntity>
    suspend fun saveRemoteResponse(response: CoinAssetsResponse)
}