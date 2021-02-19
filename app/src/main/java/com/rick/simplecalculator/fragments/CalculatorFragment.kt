package com.rick.simplecalculator.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.rick.simplecalculator.R
import com.rick.simplecalculator.`interface`.ArithmeticLogic
import com.rick.simplecalculator.softinput.EditTextKeyboardLifecycleObserver
import kotlinx.android.synthetic.main.bmi_fragment.*
import kotlinx.android.synthetic.main.calculator_fragment.*
import java.lang.ref.WeakReference

class CalculatorFragment: Fragment(R.layout.calculator_fragment), ArithmeticLogic {

    var num1 = 0f
    var num2 = 0f

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAdd.setOnClickListener {
            lifecycle.addObserver(
                    EditTextKeyboardLifecycleObserver(
                            WeakReference(etNum2),
                            WeakReference(etNum1)
                    )
            )
            if (arithmeticLogic(etNum1, etNum2, ivAtention, ivAtention2)) {
                num1 = etNum1.text.toString().toFloat()
                num2 = etNum2.text.toString().toFloat()
                tvResult.text = add(num1, num2).toString()
            }
        }
        btnMinus.setOnClickListener {
            if (arithmeticLogic(etNum1, etNum2, ivAtention, ivAtention2)) {
                num1 = etNum1.text.toString().toFloat()
                num2 = etNum2.text.toString().toFloat()
                tvResult.text = minus(num1, num2).toString()
            }
        }
        btnMult.setOnClickListener {
            if (arithmeticLogic(etNum1, etNum2, ivAtention, ivAtention2)) {
                num1 = etNum1.text.toString().toFloat()
                num2 = etNum2.text.toString().toFloat()
                tvResult.text = mult(num1, num2).toString()
            }
        }
        btnDivide.setOnClickListener {
            if (arithmeticLogic(etNum1, etNum2, ivAtention, ivAtention2)) {
                num1 = etNum1.text.toString().toFloat()
                num2 = etNum2.text.toString().toFloat()
                if (num2 != 0f){
                    tvResult.text = divide(num1, num2).toString()
                } else {
                    Toast.makeText(requireContext(), "Can't divide by zero", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun add(num1: Float, num2: Float) = num1 + num2
    private fun minus(num1: Float, num2: Float) = num1 - num2
    private fun mult(num1: Float, num2: Float) = num1 * num2
    private fun divide(num1: Float, num2: Float) = num1 / num2

}