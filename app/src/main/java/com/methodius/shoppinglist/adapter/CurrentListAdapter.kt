package com.methodius.shoppinglist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.methodius.shoppinglist.R
import com.methodius.shoppinglist.model.Product

class CurrentListAdapter: RecyclerView.Adapter<CurrentListAdapter.ProductItemHolder>() {

    var list: List<Product> = emptyList()

    class ProductItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text: TextView = itemView.findViewById(R.id.textItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductItemHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ProductItemHolder(view)
    }

    override fun onBindViewHolder(holder: ProductItemHolder, position: Int) {
        holder.text.text = list[position].text
    }

    override fun getItemCount(): Int = list.size

    fun fillList(list: List<Product>) {
        this.list = list
    }
}