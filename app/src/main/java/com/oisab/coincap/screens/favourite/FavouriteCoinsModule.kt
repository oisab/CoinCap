package com.oisab.coincap.screens.favourite

import androidx.lifecycle.ViewModel
import com.oisab.coincap.di.ViewModelKey
import com.oisab.coincap.screens.favourite.FavouriteCoinsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class FavouriteCoinsModule {

    @Binds
    @IntoMap
    @ViewModelKey(FavouriteCoinsViewModel::class)
    internal abstract fun favouriteCoinsViewModel(viewModel: FavouriteCoinsViewModel): ViewModel
}