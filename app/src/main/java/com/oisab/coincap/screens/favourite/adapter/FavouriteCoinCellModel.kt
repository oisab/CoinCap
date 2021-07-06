package com.oisab.coincap.screens.favourite.adapter

import android.os.Parcelable
import com.oisab.coincap.data.coins.remote.CoinAssetsItem
import kotlinx.parcelize.Parcelize

@Parcelize
data class FavouriteCoinCellModel(
    val coinId: String,
//    val coinRank: String?,
    val coinSymbol: String?,
    val coinName: String?,
//    val coinSupply: String?,
//    val coinMaxSupply: String?,
//    val coinMarketCapUsd: String?,
//    val coinVolume: String?,
    val coinPriceUsd: String?,
    val coinChangePercent: String?,
//    val coinWap: String?

) : Parcelable

fun ArrayList<CoinAssetsItem>.mapToUI(): ArrayList<FavouriteCoinCellModel> {
    val favouriteCoinsList: ArrayList<FavouriteCoinCellModel> = ArrayList()
    this.forEach {
        favouriteCoinsList.add(
            FavouriteCoinCellModel(
                coinId = it.coinId,
//        coinRank = it.coinRank,
                coinName = it.coinName,
                coinSymbol = it.coinSymbol,
//        coinSupply = it.coinSupply,
//        coinMaxSupply = it.coinMaxSupply,
//        coinMarketCapUsd = it.coinMarketCapUsd,
//        coinVolume = it.coinVolume,
                coinPriceUsd = it.coinPriceUsd,
                coinChangePercent = it.coinChangePercent,
//        coinWap = it.coinWap)
            )
        )
    }
    return favouriteCoinsList
}