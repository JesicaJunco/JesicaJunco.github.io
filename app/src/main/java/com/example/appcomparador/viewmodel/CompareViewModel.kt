package com.example.appcomparador.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CompareViewModel : ViewModel() {
    val text1 = MutableLiveData<String>()
    val text2 = MutableLiveData<String>()
    val result = MutableLiveData<String>()
    val clearFields = MutableLiveData<String>()

    fun compareTexts() {
        if (text1.value.isNullOrEmpty() || text2.value.isNullOrEmpty()) {
            result.value = "Ingresa ambos textos antes de comparar"
        } else {
            if (text1.value == text2.value) {
                result.value = "Las cadenas son iguales"
            } else {
                result.value = "Las cadenas no son iguales"
            }
        }
    }


    fun clearFields() {
        text1.value = ""
        text2.value = ""
        result.value = ""
    }
}

