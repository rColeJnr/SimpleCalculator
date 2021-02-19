package com.rick.simplecalculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.rick.simplecalculator.fragments.BMIfragment
import com.rick.simplecalculator.fragments.CalculatorFragment
import com.rick.simplecalculator.fragments.TipsFragment
import kotlinx.android.synthetic.main.activity_calculator.*
import kotlinx.android.synthetic.main.calculator_fragment.*

class CalculatorActivity : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView
            .OnNavigationItemSelectedListener { item ->
                when(item.itemId){
                    R.id.simpleCal -> {
                        oncalculatorSelected(CalculatorFragment())
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.bmiCal -> {
                        oncalculatorSelected(BMIfragment())
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.tipsCall -> {
                        oncalculatorSelected(TipsFragment())
                        return@OnNavigationItemSelectedListener true
                    }
                }
                false
            }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)

        val fm = supportFragmentManager
        val currentFragment = fm.findFragmentById(R.id.fragmentContainer)
        if (currentFragment == null){
            fm.beginTransaction()
                    .add(R.id.fragmentContainer, CalculatorFragment())
                    .commit()
        }

        bottomNavMenu.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }

    private fun oncalculatorSelected(fragment: Fragment){
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }

}