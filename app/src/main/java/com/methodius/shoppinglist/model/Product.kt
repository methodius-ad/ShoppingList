package com.methodius.shoppinglist.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Product(
        @PrimaryKey
        val id: Int,
        val text: String)