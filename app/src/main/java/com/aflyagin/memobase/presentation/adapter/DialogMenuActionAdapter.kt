package com.aflyagin.memobase.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.view.isGone
import androidx.recyclerview.widget.RecyclerView
import com.aflyagin.memobase.R
import com.aflyagin.memobase.databinding.ItemDialogMenuBinding
import com.aflyagin.memobase.presentation.setOnClickDebuonceListener

class DialogMenuActionAdapter(
    startItems: List<DialogMenuItem>
) : RecyclerView.Adapter<DialogMenuActionAdapter.ViewHolder>() {

    private val _items = startItems
    val items get() = _items.toList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemDialogMenuBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int = _items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = with(holder.binding) {
        val item = _items[position]
        val resources = root.context.resources
        itemDialogMenuTvLabel.text = resources.getString(item.labelRes)
        item.iconRes?.let { itemDialogMenuIvIcon.setImageResource(it) }
        itemDialogMenuIvIcon.isGone = item.iconRes == null
        itemDialogMenuIvIcon.imageTintList = resources.getColorStateList(item.iconTint, null)
        when(item.badge) {
            Badge.NEW -> {
                itemDialogMenuTvBadge.isGone = false
                itemDialogMenuTvBadge.setText(R.string.neww)
            }
            else -> itemDialogMenuTvBadge.isGone = true
        }
        root.setOnClickDebuonceListener { item.onClickListener.invoke(item) }
    }

    enum class Badge { NONE, NEW }

    class ViewHolder(val binding: ItemDialogMenuBinding) : RecyclerView.ViewHolder(binding.root)
}

data class DialogMenuItem(
    @StringRes val labelRes: Int,
    @DrawableRes val iconRes: Int?,
    @ColorRes val iconTint: Int = R.color.on_surface_variant,
    val badge: DialogMenuActionAdapter.Badge = DialogMenuActionAdapter.Badge.NONE,
    val onClickListener: (DialogMenuItem) -> Unit,
)