package com.oisab.coincap.data.coins

import com.oisab.coincap.data.coins.remote.CoinAssetsResponse
import com.oisab.coincap.data.coins.room.dao.mapToRemote
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

class CoinsRepository(val local: CoinsLocalDataSource, val remote: CoinsRemoteDataSource) {

    suspend fun fetchLocalCoinAssetsAsync(): Deferred<CoinAssetsResponse> {

        return coroutineScope {
            async {
                CoinAssetsResponse(local.loadAllCoinsAsync().mapToRemote(), 0)
            }
        }
    }

    suspend fun fetchRemoteCoinAssetsAsync(): Deferred<CoinAssetsResponse> {
        val remoteRequest = remote.getCoinAssetsAsync()
        local.saveRemoteResponse(remoteRequest.await())
        return remoteRequest
    }
}