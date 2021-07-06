package com.oisab.coincap.data.coins.remote

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface CoinApi {
    @GET("/v2/assets")
    fun fetchAssetsAsync(): Deferred<CoinAssetsResponse>
}