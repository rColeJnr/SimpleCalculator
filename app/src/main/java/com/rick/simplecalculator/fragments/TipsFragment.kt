package com.rick.simplecalculator.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.rick.simplecalculator.R
import com.rick.simplecalculator.`interface`.ArithmeticLogic
import com.rick.simplecalculator.softinput.EditTextKeyboardLifecycleObserver
import kotlinx.android.synthetic.main.tips_fragment.*
import java.lang.ref.WeakReference

class TipsFragment: Fragment(R.layout.tips_fragment), ArithmeticLogic {

    var valor = 0f
    var percentagem = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        calculatePercentagem.setOnClickListener {
            lifecycle.addObserver(
                    EditTextKeyboardLifecycleObserver(
                            WeakReference(etPercentagemGorgeta),
                            WeakReference(etValorConta)
                    )
            )
            if (arithmeticLogic(etValorConta, etPercentagemGorgeta, ivPercentagem, ivValor)) {
                valor = etValorConta.text.toString().toFloat()
                percentagem = etPercentagemGorgeta.text.toString().toFloat()
                oResultadoTip.text = "->${calculateTip(valor, percentagem)}"
            }
        }

    }

    private fun calculateTip(valor: Float, percentagem: Float) = (valor * percentagem) / 100
}