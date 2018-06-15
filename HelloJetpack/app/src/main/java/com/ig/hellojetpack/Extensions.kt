package com.ig.hellojetpack

import android.support.annotation.ColorRes
import android.support.v4.content.ContextCompat
import android.widget.TextView

fun TextView.setTextColorRes(@ColorRes color: Int) {
    setTextColor(ContextCompat.getColor(context, color))
}