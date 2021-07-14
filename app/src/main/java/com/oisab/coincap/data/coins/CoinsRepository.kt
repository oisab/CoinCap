package com.oisab.coincap.data.coins

import com.oisab.coincap.data.coins.remote.CoinAssetsResponse
import com.oisab.coincap.data.coins.room.dao.mapToRemote

class CoinsRepository(val local: CoinsLocalDataSource, val remote: CoinsRemoteDataSource) {

    suspend fun fetchLocalCoinAssetsAsync(): CoinAssetsResponse =
        CoinAssetsResponse(local.loadAllCoinsAsync().mapToRemote(), 0)


    suspend fun fetchRemoteCoinAssetsAsync(): CoinAssetsResponse {
        val remoteRequest = remote.getCoinAssetsAsync().await()
        local.saveRemoteResponse(remoteRequest)
        return remoteRequest
    }
}