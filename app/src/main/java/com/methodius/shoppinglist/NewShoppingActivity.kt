package com.methodius.shoppinglist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.methodius.shoppinglist.adapter.CurrentListAdapter

class NewShoppingActivity : AppCompatActivity() {

    lateinit var editText: EditText
    lateinit var button: Button
    lateinit var recyclerView: RecyclerView

    private lateinit var adapter: CurrentListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_shopping)

        val list: ArrayList<String> = ArrayList<String>()

        editText = findViewById(R.id.newItem)
        button = findViewById(R.id.save)
        recyclerView = findViewById(R.id.newRecycler)

        adapter = CurrentListAdapter()
        adapter.fillList(list)

        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter


        button.setOnClickListener {
            list.add(editText.text.toString())
            adapter.notifyDataSetChanged()
        }
    }
}