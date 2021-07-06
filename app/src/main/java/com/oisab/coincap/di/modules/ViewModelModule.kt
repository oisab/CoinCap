package com.oisab.coincap.di.modules

import androidx.lifecycle.ViewModelProvider
import com.oisab.coincap.di.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}