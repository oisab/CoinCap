package com.oisab.coincap

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun favouriteCoinsFragment(): FavouriteCoinsFragment
}