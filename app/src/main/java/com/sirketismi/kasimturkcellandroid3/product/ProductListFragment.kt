package com.sirketismi.kasimturkcellandroid3.product

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.sirketismi.kasimturkcellandroid3.Product
import com.sirketismi.kasimturkcellandroid3.ProductDetailFragment
import com.sirketismi.kasimturkcellandroid3.databinding.FragmentProductListBinding

class ProductListFragment : Fragment() {

    lateinit var viewModel: ProductListViewModel
    lateinit var binding : FragmentProductListBinding

    var adapter : ProductListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductListBinding.inflate(inflater)
        viewModel = ViewModelProvider(this).get(ProductListViewModel::class.java)

        binding.btnAddProduct.setOnClickListener {
            navigateToDetail()
        }

        setFragmentResultListener(ProductDetailFragment.ARG_REQUEST_KEY) { requestKey, bundle ->
            if(requestKey == ProductDetailFragment.ARG_REQUEST_KEY) {
                val product = bundle.getParcelable<Product>(ProductDetailFragment.ARG_PRODUCT)
                product?.let {
                    viewModel.addProduct(it)
                    adapter?.updateData(viewModel.productList)
                }
            }
        }

        return binding.root
    }

    private fun navigateToDetail(product: Product? = null) {
        val action = ProductListFragmentDirections.actionListToDetail(selectedProduct = product)
        findNavController().navigate(action)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupAdapter()
    }

    private fun setupAdapter() {
        adapter = ProductListAdapter(viewModel.productList, onItemSelected = {
            navigateToDetail(it)
        })
        binding.productListView.adapter = adapter
    }
}