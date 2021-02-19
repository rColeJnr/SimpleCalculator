package com.rick.simplecalculator.fragments

import android.app.Activity
import android.content.Context
import android.inputmethodservice.Keyboard
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import com.rick.simplecalculator.R
import com.rick.simplecalculator.`interface`.ArithmeticLogic
import com.rick.simplecalculator.softinput.EditTextKeyboardLifecycleObserver
import kotlinx.android.synthetic.main.bmi_fragment.*
import java.lang.ref.WeakReference

class BMIfragment: Fragment(R.layout.bmi_fragment), ArithmeticLogic {

    var peso = 0f
    var altura = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnCalculaBMI.isClickable = true

        btnCalculaBMI.setOnClickListener {

            lifecycle.addObserver(
                    EditTextKeyboardLifecycleObserver(
                            WeakReference(etWeight),
                            WeakReference(etHeight)
                    )
            )
            if (arithmeticLogic(etWeight, etHeight, ivPeso, ivAltura)) {
                peso = etWeight.text.toString().toFloat()
                altura = etHeight.text.toString().toFloat()
                tvResultadoBmi.text = bmiValue(peso, altura).toString()
            }
        }

    }

    private fun bmiValue(peso: Float, altura: Float) = peso / (altura * altura)
}