package com.rick.simplecalculator.softinput

import android.widget.EditText
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import java.lang.ref.WeakReference

class EditTextKeyboardLifecycleObserver(
        private val editText1: WeakReference<EditText>,
        private val editText2: WeakReference<EditText>
) :
        LifecycleObserver {

    @OnLifecycleEvent(
            Lifecycle.Event.ON_RESUME
    )
    fun hideKeyboard() {
        editText1.get()?.postDelayed({ editText1.get()?.hideKeyboard() }, 50)
        editText2.get()?.postDelayed({ editText2.get()?.hideKeyboard() }, 50)
    }
}