package com.oisab.coincap.data.coins.room.dao

import androidx.room.*

@Dao
interface CoinAssetsDao {

    @Query("SELECT * FROM ${CoinsEntity.TABLE_NAME}")
    suspend fun getAllCoinAssetsAsync() : List<CoinsEntity>

    @Insert(entity = CoinsEntity::class, onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCoinAsset(coinsEntity: CoinsEntity)

    @Insert(entity = CoinsEntity::class, onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    suspend fun saveAllCoins(entities: List<CoinsEntity>)

    @Delete(entity = CoinsEntity::class)
    suspend fun deleteCoinAsset(coinsEntity: CoinsEntity)
}