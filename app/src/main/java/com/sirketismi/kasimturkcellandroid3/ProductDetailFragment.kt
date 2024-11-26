package com.sirketismi.kasimturkcellandroid3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.sirketismi.kasimturkcellandroid3.databinding.FragmentProductDetailBinding
import com.sirketismi.kasimturkcellandroid3.databinding.FragmentProductListBinding

class ProductDetailFragment : Fragment() {
    lateinit var binding : FragmentProductDetailBinding
    val args : ProductDetailFragmentArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /*arguments?.let {
            val selectedProduct = it.getParcelable<Product>("selectedProduct")

        }*/
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductDetailBinding.inflate(inflater)

        binding.btnAddProduct.setOnClickListener {
            val title = binding.edtProductTitle.text.toString()
            val name = binding.edtProductName.text.toString()
            val description = binding.edtProductDesctiption.text.toString()
            var product = Product(title, name, description)

            val bundle = Bundle()
            bundle.putParcelable(ARG_PRODUCT, product)
            setFragmentResult(ARG_REQUEST_KEY, bundle)
            //findNavController().popBackStack()
            findNavController().navigateUp()

        }

       return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val selectedProduct = args.selectedProduct

        selectedProduct?.let {
            binding.edtProductTitle.setText(it.title)
            binding.edtProductName.setText(it.name)
            binding.edtProductDesctiption.setText(it.description)
        }
    }

    companion object {
        val ARG_PRODUCT = "product"
        val ARG_REQUEST_KEY = "requestKey"
    }
}