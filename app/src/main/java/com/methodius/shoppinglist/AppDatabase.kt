package com.methodius.shoppinglist

import androidx.room.Database
import androidx.room.RoomDatabase
import com.methodius.shoppinglist.model.Product

@Database(entities = [Product::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun productDao(): ProductDao
}