package com.methodius.shoppinglist.di

import android.content.Context
import androidx.room.Room
import com.methodius.shoppinglist.App
import com.methodius.shoppinglist.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StorageModule(app: Context) {
    val context = app

    @Provides
    @Singleton
    fun provideDatabase(): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, "db").build()

    @Provides
    @Singleton
    fun provideDao(db: AppDatabase) = db.productDao()
}