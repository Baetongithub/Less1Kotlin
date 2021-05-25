package com.geektech.less1kotlin

import android.app.Activity
import android.widget.EditText
import android.widget.Toast

fun Activity.toast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}

fun EditText.isEmpty(): Boolean {
    if (this.text.toString().trim().isEmpty()) {
        return true
    }
    return false
}