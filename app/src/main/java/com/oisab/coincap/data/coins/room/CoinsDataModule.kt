package com.oisab.coincap.data.coins.room

import com.oisab.coincap.data.coins.CoinsLocalDataSource
import com.oisab.coincap.data.coins.CoinsRemoteDataSource
import com.oisab.coincap.data.coins.CoinsRepository
import com.oisab.coincap.data.coins.local.CoinsDatabase
import com.oisab.coincap.data.coins.remote.CoinApi
import com.oisab.coincap.data.coins.retrofit.RetrofitCoinsDataSource
import dagger.Module
import dagger.Provides

@Module
class CoinsDataModule {

    @Provides
    fun provideLocalDataSource(roomDatabase: CoinsDatabase): CoinsLocalDataSource = RoomCoinsDataSource(roomDatabase.coinsDao())

    @Provides
    fun provideRemoteDataSource(coinApi: CoinApi): CoinsRemoteDataSource =
        RetrofitCoinsDataSource(coinApi)

    @Provides
    fun provideCoinsRepository(
        local: CoinsLocalDataSource,
        remote: CoinsRemoteDataSource
    ): CoinsRepository = CoinsRepository(local, remote)
}