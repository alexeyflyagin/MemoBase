package com.aflyagin.memobase.presentation.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.aflyagin.memobase.databinding.NoteSignBinding

class NoteSign @JvmOverloads constructor (
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyle: Int = 0,
) : ConstraintLayout(context, attributeSet, defStyle) {

    private val binding: NoteSignBinding

    init {
        val inflater = LayoutInflater.from(context)
        binding = NoteSignBinding.inflate(inflater, this, true)
    }

    fun setSign(sign: CharSequence) {
        binding.tvSign.text = sign
    }
}