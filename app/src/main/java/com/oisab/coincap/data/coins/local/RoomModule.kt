package com.oisab.coincap.data.coins.local

import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides

@Module
class RoomModule {

    @Provides
    fun provideApplicationContext(application: Application): Context {
        return application.applicationContext
    }

    @Provides
    fun provideRoomDatabase(context: Context) = Room.databaseBuilder(context, CoinsDatabase::class.java, "coins_database").build()
}