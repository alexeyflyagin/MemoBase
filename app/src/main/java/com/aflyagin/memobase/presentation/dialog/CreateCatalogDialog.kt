package com.aflyagin.memobase.presentation.dialog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.core.widget.addTextChangedListener
import com.aflyagin.memobase.databinding.FragmentDialogCreateCatalogBinding
import com.aflyagin.memobase.presentation.setOnClickDebuonceListener
import com.aflyagin.memobase.presentation.showKeyboard
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CreateCatalogDialog : BottomSheetDialogFragment() {

    private var _binding: FragmentDialogCreateCatalogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDialogCreateCatalogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        dialogCreateCatalogEtNaming.setOnEditorActionListener { v, actionId, event ->
            createCatalog()
            return@setOnEditorActionListener true
        }
        dialogCreateCatalogEtNaming.addTextChangedListener {
            dialogCreateCatalogBtnCreate.isEnabled = checkData()
        }
        dialogCreateCatalogBtnCreate.setOnClickDebuonceListener { createCatalog() }
        dialogCreateCatalogEtNaming.requestFocus()
        dialogCreateCatalogEtNaming.showKeyboard()
        dialogCreateCatalogEtNaming.setText("")
    }

    private fun checkData(): Boolean = with(binding) {
        val text = dialogCreateCatalogEtNaming.text.toString().trim()
        return text.isNotEmpty()
    }

    private fun createCatalog() {
        if (!checkData()) return
        dismiss()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {

        fun newInstance() = CreateCatalogDialog().apply { }
    }
}