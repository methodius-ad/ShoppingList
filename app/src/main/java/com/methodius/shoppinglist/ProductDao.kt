package com.methodius.shoppinglist

import androidx.room.*
import com.methodius.shoppinglist.model.Product

@Dao
interface ProductDao {

    @Query("SELECT * FROM product")
    fun getAll(): ArrayList<Product>

    @Query("SELECT * FROM product WHERE id = id")
    fun getProduct(id: Int)

    @Insert
    fun addProduct(product: Product)

    @Update
    fun updateProduct(product: Product)

    @Delete
    fun deleteProduct(product: Product)
}