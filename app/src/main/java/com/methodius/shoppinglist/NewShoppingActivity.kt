package com.methodius.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.methodius.shoppinglist.adapter.CurrentListAdapter
import com.methodius.shoppinglist.model.Product

class NewShoppingActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var button: Button
    private lateinit var recyclerView: RecyclerView

    private lateinit var list: ArrayList<Product>

    private lateinit var adapter: CurrentListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_shopping)

        list = ArrayList<Product>()

        editText = findViewById(R.id.newItem)
        button = findViewById(R.id.save)
        recyclerView = findViewById(R.id.newRecycler)

        adapter = CurrentListAdapter()
        adapter.fillList(list)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter


        button.setOnClickListener {
            createRoom()
            makeButtonEmpty()
            adapter.notifyDataSetChanged()
        }
    }

    private fun makeButtonEmpty() {
        editText.setText("")
    }

    private fun createRoom() {
        val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "db")
        val product: Product = Product(1, editText.text.toString())
        list.add(product)
    }
}