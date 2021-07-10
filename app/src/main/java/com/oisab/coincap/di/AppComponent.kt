package com.oisab.coincap.di

import android.app.Application
import com.oisab.coincap.CoinApp
import com.oisab.coincap.data.coins.local.RoomModule
import com.oisab.coincap.data.coins.room.CoinsDataModule
import com.oisab.coincap.di.modules.ScreenBindingModule
import com.oisab.coincap.screens.favourite.FavouriteCoinsModule
import com.oisab.coincap.di.modules.RemoteModule
import com.oisab.coincap.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Component(
    modules = [AndroidInjectionModule::class,
        ScreenBindingModule::class,
        FavouriteCoinsModule::class,
        ViewModelModule::class,
        CoinsDataModule::class,
        RemoteModule::class,
        RoomModule::class]
)

@Singleton
interface AppComponent : AndroidInjector<CoinApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}