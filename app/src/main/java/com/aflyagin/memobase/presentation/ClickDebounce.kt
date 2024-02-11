package com.aflyagin.memobase.presentation

import android.os.SystemClock
import android.view.View
import android.view.View.OnClickListener
import android.view.View.OnLongClickListener

fun View.setOnClickDebuonceListener(
    debounce: Long = ClickDebounce.DEFAULT_DEBOUNCE,
    a: (View?) -> Unit
) {
    setOnClickListener { ClickDebounce.getOnClickListener(debounce, a).onClick(it) }
}

fun View.setOnLongClickDebuonceListener(
    debounce: Long = ClickDebounce.DEFAULT_DEBOUNCE,
    a: (View?) -> Boolean
) {
    setOnLongClickListener { ClickDebounce.getOnLongClickListener(debounce, a).onLongClick(it) }
}

object ClickDebounce {

    const val DEFAULT_DEBOUNCE = 600L

    private var _lastClickTime = 0L
    private var _debounce = DEFAULT_DEBOUNCE
    private var _nextDebounce = DEFAULT_DEBOUNCE
    private var _action: ((View?) -> Unit)? = null
    private var _actionLong: ((View?) -> Boolean)? = null

    var nextDebounce get() = _nextDebounce
        set(value) { _nextDebounce = value}

    private val _onClickListener = object : OnClickListener {
        override fun onClick(v: View?) {
            if (SystemClock.elapsedRealtime() - _lastClickTime < _debounce) {
                _action = null
                return
            }
            _action?.invoke(v)
            _lastClickTime = SystemClock.elapsedRealtime()
            resetClickData()
        }
    }

    private val _onLongClickListener = object : OnLongClickListener {
        override fun onLongClick(v: View?): Boolean {
            if (SystemClock.elapsedRealtime() - _lastClickTime < _debounce) {
                _actionLong = null
                return false
            }
            val r = _actionLong?.invoke(v) ?: false
            _lastClickTime = SystemClock.elapsedRealtime()
            resetClickData()
            return r
        }
    }

    fun getOnClickListener(debounce: Long, a: (View?) -> Unit): OnClickListener {
        _action = a
        _nextDebounce = debounce
        return _onClickListener
    }

    fun getOnLongClickListener(debounce: Long, a: (View?) -> Boolean): OnLongClickListener {
        _actionLong = a
        _nextDebounce = debounce
        return _onLongClickListener
    }

    private fun resetClickData() {
        _debounce = _nextDebounce
        _nextDebounce = DEFAULT_DEBOUNCE
        _action = null
        _actionLong = null
    }
}