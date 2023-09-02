package com.example.appcomparador


import com.example.appcomparador.viewmodel.CompareViewModel
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CompareViewModelUnitTest {
    private lateinit var viewModel: CompareViewModel

    @Before
    fun setupViewModel() {
        viewModel = CompareViewModel()
    }

    @Test
    fun testCompareTexts() {
        viewModel.text1.value = "hello"
        viewModel.text2.value = "world"
        viewModel.compareTexts()
        assertEquals("Las cadenas no son iguales", viewModel.result.value)
    }
}




