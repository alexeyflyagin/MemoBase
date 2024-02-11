package com.aflyagin.memobase.presentation.dialog

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aflyagin.memobase.R
import com.aflyagin.memobase.databinding.FragmentDialogCatalogMenuBinding
import com.aflyagin.memobase.presentation.adapter.DialogMenuActionAdapter
import com.aflyagin.memobase.presentation.adapter.DialogMenuItem
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class CatalogMenuDialog : BottomSheetDialogFragment() {

    private var _binding: FragmentDialogCatalogMenuBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDialogCatalogMenuBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?): Unit = with(binding) {
        super.onViewCreated(view, savedInstanceState)
        val actions = listOf(
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.change, R.drawable.ic_edit) {
                println(getString(it.labelRes))
                dismiss()
            },
            DialogMenuItem(R.string.delete, R.drawable.ic_delete, R.color.error) {
                println(getString(it.labelRes))
                dismiss()
            }
        )
        dialogCatalogMenuRvActions.adapter = DialogMenuActionAdapter(actions)
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {

        fun newInstance() = CatalogMenuDialog().apply {  }
    }
}