package com.oisab.coincap

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Component(modules = [ActivityBindingModule::class, AndroidInjectionModule::class, RemoteModule::class, ViewModelModule::class])

@Singleton
interface AppComponent: AndroidInjector<CoinApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }
}