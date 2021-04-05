package com.methodius.shoppinglist

import androidx.lifecycle.LiveData
import androidx.room.*
import com.methodius.shoppinglist.model.Product
import java.util.concurrent.Flow

@Dao
interface ProductDao {

    @Query("SELECT * FROM product")
    fun getAll(): LiveData<List<Product>>

    @Query("SELECT * FROM product WHERE id = :id")
    fun getProduct(id: Int): LiveData<Product>

    @Insert
    fun addProduct(product: Product)

    @Update
    fun updateProduct(product: Product)

    @Delete
    fun deleteProduct(product: Product)
}