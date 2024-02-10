package com.aflyagin.memobase

import android.graphics.drawable.Drawable
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class NotePageAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {

    private val _items = mutableListOf<NotePageItem>()
    val items get() = _items.toList()

    override fun getItemCount(): Int = _items.size

    override fun createFragment(position: Int): Fragment {
        TODO("Not yet implemented")
    }

    data class NotePageItem(
        val id: Long,
        val name: String?,
        @DrawableRes val iconRes: Int?,
    )
}