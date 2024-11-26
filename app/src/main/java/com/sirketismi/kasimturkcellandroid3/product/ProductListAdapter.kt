package com.sirketismi.kasimturkcellandroid3.product

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.sirketismi.kasimturkcellandroid3.Product
import com.sirketismi.kasimturkcellandroid3.databinding.ListItemProductBinding

class ProductListAdapter(private var products : List<Product>, val onItemSelected : (Product)->Unit) : BaseAdapter() {

    fun updateData(newList : List<Product>) {
        products = newList
        notifyDataSetChanged()
    }
    override fun getCount(): Int {
        return products.size
    }

    override fun getItem(p0: Int): Any {
        return products[p0]
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getView(position: Int, contentView: View?, parent: ViewGroup?): View {
        var newContentView : View? = null
        var holder : ViewHolder

        contentView?.let {
            newContentView = contentView

            (contentView.tag as? ViewHolder)?.let {
                holder = it
                products.getOrNull(position)?.let {
                  holder.bind(it)
                }
            }
        } ?: run {
            val layoutInflater = LayoutInflater.from(parent?.context)
            val binding : ListItemProductBinding = ListItemProductBinding.inflate(layoutInflater , parent, false)
            newContentView = binding.root

            holder = ViewHolder(binding)

            binding.root.setOnClickListener {
                onItemSelected(products[position])
            }

            products.getOrNull(position)?.let {
                holder.bind(it)
            }
            newContentView?.tag = holder
        }

        return newContentView!!
    }
}

class ViewHolder(var binding : ListItemProductBinding) {
    fun bind(product : Product) {
        binding.txtProductTitle.text = product.title
        binding.txtProductDetail.text = product.description
    }
}