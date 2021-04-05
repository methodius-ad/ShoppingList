package com.methodius.shoppinglist

import android.app.Application
import com.methodius.shoppinglist.di.AppComponent
import com.methodius.shoppinglist.di.DaggerAppComponent
import com.methodius.shoppinglist.di.StorageModule

class App: Application() {

    companion object {
        lateinit var component: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        component = buildComponent()
    }

    private fun buildComponent(): AppComponent =
        DaggerAppComponent.builder().storageModule(StorageModule(this)).build()

}