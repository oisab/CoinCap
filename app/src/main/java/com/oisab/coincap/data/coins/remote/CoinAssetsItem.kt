package com.oisab.coincap.data.coins.remote

import com.google.gson.annotations.SerializedName
import javax.sql.StatementEvent

data class CoinAssetsItem(
    @SerializedName("id")
    val coinId: String,
    @SerializedName("rank")
    val coinRank: String?,
    @SerializedName("name")
    val coinName: String?,
    @SerializedName("symbol")
    val coinSymbol: String?,
    @SerializedName("supply")
    val coinSupply: String?,
    @SerializedName("maxSupply")
    val coinMaxSupply: String?,
    @SerializedName("marketCapUsd")
    val coinMarketCapUsd: String?,
    @SerializedName("volumeUsd24Hr")
    val coinVolume: String?,
    @SerializedName("priceUsd")
    val coinPriceUsd: String?,
    @SerializedName("changePercent24Hr")
    val coinChangePercent: String?,
    @SerializedName("vwap24Hr")
    val coinWap: String?
)