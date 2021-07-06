package com.oisab.coincap.data.coins.room

import com.oisab.coincap.data.coins.CoinsLocalDataSource
import com.oisab.coincap.data.coins.remote.CoinAssetsResponse
import com.oisab.coincap.data.coins.room.dao.CoinAssetsDao
import com.oisab.coincap.data.coins.room.dao.CoinsEntity
import com.oisab.coincap.data.coins.room.dao.mapToLocal

class RoomCoinsDataSource(private val coinAssetsDao: CoinAssetsDao) : CoinsLocalDataSource {

    override suspend fun loadAllCoinsAsync(): List<CoinsEntity> = coinAssetsDao.getAllCoinAssetsAsync()

    override suspend fun saveRemoteResponse(response: CoinAssetsResponse) = coinAssetsDao.saveAllCoins(response.data.mapToLocal())
}