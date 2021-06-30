package com.oisab.coincap

import kotlinx.coroutines.Deferred
import retrofit2.http.GET

interface CoinApi {

    @GET("./assets")
    fun fetchAssetsAsync(): Deferred<List<CoinAssetsResponse>>
}