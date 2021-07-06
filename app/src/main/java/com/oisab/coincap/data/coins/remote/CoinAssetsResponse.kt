package com.oisab.coincap.data.coins.remote

data class CoinAssetsResponse(
    val data: ArrayList<CoinAssetsItem>,
    val timesTamp: Int
)