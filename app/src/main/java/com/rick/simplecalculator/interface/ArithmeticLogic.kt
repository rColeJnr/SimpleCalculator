package com.rick.simplecalculator.`interface`

import android.widget.EditText
import android.widget.ImageView
import androidx.core.view.isVisible

interface ArithmeticLogic {

    fun arithmeticLogic(val1: EditText, val2: EditText, ivAtention: ImageView, ivAtention2: ImageView): Boolean {
        if (val1.text.isEmpty() || val2.text.isEmpty()){
            if (val1.text.isEmpty()){
                ivAtention.isVisible = true
            }
            if (val2.text.isEmpty()){
                ivAtention2.isVisible = true
            }
            if (val1.text.isNotEmpty()){
                ivAtention.isVisible = false
            }
            if (val2.text.isNotEmpty()){
                ivAtention2.isVisible = false
            }
            return false
        }
        else if (val1.text.isNotEmpty() && val2.text.isNotEmpty()){
            if (val1.text.isNotEmpty()){
                ivAtention.isVisible = false
            }
            if (val2.text.isNotEmpty()){
                ivAtention2.isVisible = false
            }
        }
        return true
    }
}