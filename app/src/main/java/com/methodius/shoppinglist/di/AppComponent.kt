package com.methodius.shoppinglist.di

import com.methodius.shoppinglist.MainActivity
import dagger.Component
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
@Component(modules = [StorageModule::class])
interface AppComponent {

    fun injectsMain(mainActivity: MainActivity)
}