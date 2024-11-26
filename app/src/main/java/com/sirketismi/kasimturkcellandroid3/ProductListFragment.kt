package com.sirketismi.kasimturkcellandroid3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.sirketismi.kasimturkcellandroid3.databinding.FragmentProductListBinding

class ProductListFragment : Fragment() {

    lateinit var binding : FragmentProductListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductListBinding.inflate(inflater)


        binding.btnAddProduct.setOnClickListener {
            val action = ProductListFragmentDirections.actionListToDetail()
            findNavController().navigate(action)
        }

        return binding.root
    }
}