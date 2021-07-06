package com.oisab.coincap.data.coins.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.oisab.coincap.data.coins.room.dao.CoinAssetsDao
import com.oisab.coincap.data.coins.room.dao.CoinsEntity

@Database(
    entities = [
        CoinsEntity::class
    ], version = 1, exportSchema = true
)
abstract class CoinsDatabase: RoomDatabase() {
    abstract fun coinsDao(): CoinAssetsDao
}