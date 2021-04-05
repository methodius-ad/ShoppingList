package com.methodius.shoppinglist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.methodius.shoppinglist.adapter.CurrentListAdapter
import com.methodius.shoppinglist.model.Product
import javax.inject.Inject
import javax.inject.Singleton

class MainActivity : AppCompatActivity() {

    @Inject
    @Singleton
    lateinit var db: AppDatabase

    lateinit var addButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        App.component.injectsMain(this)



        addButton = findViewById(R.id.floatingActionButton)

        val list: ArrayList<Product> = ArrayList<Product>()
        val product: Product = Product(1, "asalam")
        list.add(product)


        val adapter: CurrentListAdapter = CurrentListAdapter()
        adapter.fillList(list)

        val recyclerView: RecyclerView = findViewById(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        Log.d("logs", list[0].text)

        addButton.setOnClickListener{
            startActivity(Intent(it.context, NewShoppingActivity::class.java))
        }
    }
}