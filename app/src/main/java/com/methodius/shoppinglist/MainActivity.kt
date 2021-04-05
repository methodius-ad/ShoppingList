package com.methodius.shoppinglist

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.methodius.shoppinglist.adapter.CurrentListAdapter

class MainActivity : AppCompatActivity() {

    lateinit var addButton: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addButton = findViewById(R.id.floatingActionButton)

        val list: List<String> = arrayOf("first", "second", "aboba").toList()
        val adapter: CurrentListAdapter = CurrentListAdapter()
        adapter.fillList(list)

        val recyclerView: RecyclerView = findViewById(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        Log.d("logs", list[0])

        addButton.setOnClickListener{
            startActivity(Intent(it.context, NewShoppingActivity::class.java))
        }
    }
}