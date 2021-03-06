package com.oisab.coincap.di.modules

import com.oisab.coincap.screens.favourite.FavouriteCoinsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ScreenBindingModule {

    @ContributesAndroidInjector
    abstract fun favouriteCoinsFragment(): FavouriteCoinsFragment
}