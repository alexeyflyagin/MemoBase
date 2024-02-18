package com.aflyagin.memobase.presentation.dialog

import android.app.Dialog
import android.graphics.Color
import android.graphics.Rect
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.FrameLayout
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.core.view.marginTop
import androidx.core.view.setPadding
import androidx.core.view.updatePadding
import com.aflyagin.memobase.R
import com.aflyagin.memobase.databinding.FragmentDialogCatalogMenuBinding
import com.aflyagin.memobase.presentation.adapter.DialogMenuActionAdapter
import com.aflyagin.memobase.presentation.adapter.DialogMenuItem
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.internal.EdgeToEdgeUtils

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
            DialogMenuItem(R.string.delete, R.drawable.ic_delete, R.color.error) {
                dismiss()
            }
        )
        dialogCatalogMenuRvActions.adapter = DialogMenuActionAdapter(actions)
        dialogCatalogMenuRvActions.post {
            val maxHeight = (root.parent.parent as CoordinatorLayout).height
            val headerHeight = dialogCatalogMenuHeader.height
            if (headerHeight + dialogCatalogMenuRvActions.height > maxHeight) {
                dialogCatalogMenuRvActions.layoutParams.height = maxHeight - headerHeight
                dialogCatalogMenuRvActions.requestLayout()
            }
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.window?.let {
            WindowInsetsControllerCompat(it, it.decorView).isAppearanceLightStatusBars = true
            WindowInsetsControllerCompat(it, it.decorView).isAppearanceLightStatusBars = true
        }
        (dialog as BottomSheetDialog).behavior.peekHeight = 1000
        return dialog
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object {

        private const val CATALOG_ID = "catalog_id"

        fun newInstance(catalogId: Long) = CatalogMenuDialog().apply {
            arguments = Bundle().apply {
                putLong(CATALOG_ID, catalogId)
            }
        }
    }
}