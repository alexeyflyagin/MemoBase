package com.aflyagin.memobase.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aflyagin.memobase.databinding.FragmentNotesBinding
import com.aflyagin.memobase.presentation.dialog.CatalogMenuDialog
import com.aflyagin.memobase.presentation.dialog.CreateCatalogDialog
import com.aflyagin.memobase.presentation.setOnClickDebuonceListener
import com.aflyagin.memobase.presentation.setOnLongClickDebuonceListener

class NotesFragment : Fragment() {

    private var _binding: FragmentNotesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?): Unit = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        with(tlCatalogs) {
            tabLayoutCatalogsBtnAdd.setOnClickDebuonceListener {
                val dialog = CreateCatalogDialog.newInstance()
                dialog.show(childFragmentManager, null)
            }
            tabLayoutCatalogsBtnAdd.setOnLongClickDebuonceListener {
                CatalogMenuDialog().show(childFragmentManager, null)
                true
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {

        fun newInstance() = NotesFragment()

    }
}