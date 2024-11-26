package com.sirketismi.kasimturkcellandroid3.product

import androidx.lifecycle.ViewModel
import com.sirketismi.kasimturkcellandroid3.Product

// RX -> Reactive
// iOS -> Combine
// LiveData, Flow, Channel -> Android
class ProductListViewModel : ViewModel() {
    var productList = mutableListOf<Product>()

    fun addProduct(product : Product) {
        productList.add(product)
    }
}

// ListView
// RecylerView