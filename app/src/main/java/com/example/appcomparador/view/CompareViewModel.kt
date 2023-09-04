package com.example.appcomparador.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appcomparador.model.Compare

class CompareViewModel : ViewModel() {
    val compare: LiveData<Compare> get() = _compare
    private var _compare = MutableLiveData<Compare>(Compare("", "", ""))

    fun compareTexts(editText1: String, editText2: String) {
        if (editText1 == editText2) {
            _compare.value = Compare(editText1, editText2, result(true))
        } else {
            _compare.value =
                Compare(editText1, editText2, result(false))
        }
    }

    private fun result(result: Boolean): String {
        if (result) {
            return "Los textos son iguales"
        } else {
            return "Los textos NO son iguales"
        }
    }

}

