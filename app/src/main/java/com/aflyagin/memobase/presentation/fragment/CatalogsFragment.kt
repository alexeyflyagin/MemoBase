package com.aflyagin.memobase.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.aflyagin.memobase.databinding.FragmentCatalogsBinding
import com.aflyagin.memobase.presentation.setOnClickDebuonceListener
import java.util.concurrent.TimeUnit

class CatalogsFragment : Fragment() {

    private var _binding: FragmentCatalogsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        postponeEnterTransition(1, TimeUnit.MILLISECONDS)
        _binding = FragmentCatalogsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?): Unit = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        toolbarCatalogs.toolbarCatalogsBtnMenu.setOnClickDebuonceListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}