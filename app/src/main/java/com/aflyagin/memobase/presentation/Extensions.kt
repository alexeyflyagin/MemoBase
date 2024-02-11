package com.aflyagin.memobase.presentation

import android.app.Activity
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.MenuInflater
import android.view.MenuItem
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.PopupMenu
import androidx.annotation.MenuRes
import androidx.core.os.BundleCompat
import androidx.core.view.MenuItemCompat
import androidx.core.view.forEach
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun String.words(): List<String> {
    val text = this.trimStart().trimEnd().replace("\n", " ")
    return text.split(" ").filter { it.isNotEmpty() }
}

fun EditText.showKeyboard() {
    val imm = this.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.showSoftInput(this, InputMethodManager.SHOW_IMPLICIT)
}

fun EditText.hideKeyboard() {
    val imm = this.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(this.windowToken, 0)
}

fun LocalDateTime.format(pattern: String): String {
    val formatter = DateTimeFormatter.ofPattern(pattern)
    return this.format(formatter)
}

fun getListFromMenu(context: Context, @MenuRes menuId: Int): List<MenuItem> {
    val res = mutableListOf<MenuItem>()
    PopupMenu(context, null).apply {
        menuInflater.inflate(menuId, menu)
        menu.forEach { res.add(it) }
    }
    return res
}

