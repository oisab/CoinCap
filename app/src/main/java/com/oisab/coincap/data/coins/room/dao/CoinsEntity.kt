package com.oisab.coincap.data.coins.room.dao

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.oisab.coincap.data.coins.remote.CoinAssetsItem
import com.oisab.coincap.data.coins.room.dao.CoinsEntity.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class CoinsEntity(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val coinId: String,
    @ColumnInfo(name = "rank")
    val coinRank: String?,
    @ColumnInfo(name = "name")
    val coinName: String?,
    @ColumnInfo(name = "symbol")
    val coinSymbol: String?,
    @ColumnInfo(name = "supply")
    val coinSupply: String?,
    @ColumnInfo(name = "maxSupply")
    val coinMaxSupply: String?,
    @ColumnInfo(name = "marketCapUsd")
    val coinMarketCapUsd: String?,
    @ColumnInfo(name = "volumeUsd24Hr")
    val coinVolume: String?,
    @ColumnInfo(name = "priceUsd")
    val coinPriceUsd: String?,
    @ColumnInfo(name = "changePercent24Hr")
    val coinChangePercent: String?,
    @ColumnInfo(name = "vwap24Hr")
    val coinWap: String?
) {
    companion object {
        const val TABLE_NAME = "coin_assets"
    }
}

fun List<CoinsEntity>.mapToRemote(): ArrayList<CoinAssetsItem> {
    val coinAssetsItemArray: ArrayList<CoinAssetsItem> = ArrayList()
    this.forEach { coinsEntity ->
        coinAssetsItemArray.add(
            CoinAssetsItem(
                coinId = coinsEntity.coinId,
                coinRank = coinsEntity.coinRank,
                coinName = coinsEntity.coinName,
                coinSymbol = coinsEntity.coinSymbol,
                coinSupply = coinsEntity.coinSupply,
                coinMaxSupply = coinsEntity.coinMaxSupply,
                coinMarketCapUsd = coinsEntity.coinMarketCapUsd,
                coinVolume = coinsEntity.coinVolume,
                coinPriceUsd = coinsEntity.coinPriceUsd,
                coinChangePercent = coinsEntity.coinChangePercent,
                coinWap = coinsEntity.coinWap
            )
        )
    }
    return coinAssetsItemArray
}

fun ArrayList<CoinAssetsItem>.mapToLocal(): MutableList<CoinsEntity> {
    val coinsEntity: MutableList<CoinsEntity> = mutableListOf()
    this.forEach { coinAssetsItem ->
        coinsEntity.add(
            CoinsEntity(
                coinId = coinAssetsItem.coinId,
                coinRank = coinAssetsItem.coinRank,
                coinName = coinAssetsItem.coinName,
                coinSymbol = coinAssetsItem.coinSymbol,
                coinSupply = coinAssetsItem.coinSupply,
                coinMaxSupply = coinAssetsItem.coinMaxSupply,
                coinMarketCapUsd = coinAssetsItem.coinMarketCapUsd,
                coinVolume = coinAssetsItem.coinVolume,
                coinPriceUsd = coinAssetsItem.coinPriceUsd,
                coinChangePercent = coinAssetsItem.coinChangePercent,
                coinWap = coinAssetsItem.coinWap
            )
        )
    }
    return coinsEntity
}