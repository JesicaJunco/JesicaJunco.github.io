package com.example.appcomparador


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.appcomparador.view.CompareViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.Assert.*
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@OptIn(ExperimentalCoroutinesApi::class)
class CompareViewModelUnitTest {
    private lateinit var viewModel: CompareViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()


    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = CompareViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun compareViewModel_InitText() = runTest {
        val text1 = viewModel.compare.value?.editText1
        val text2 = viewModel.compare.value?.editText2
        val result = viewModel.compare.value?.result

        assertEquals("", text1)
        assertEquals("", text2)
        assertEquals("", result)
    }

    @Test
    fun compareViewModel_CompareTextEqual() = runTest {
        launch {
            viewModel.compareTexts("hello", "hello")
        }

        advanceUntilIdle()

        val result = viewModel.compare.value?.result

        assertEquals("Los textos son iguales", result)
    }

    @Test
    fun compareViewModel_CompareTextNoEqual() = runTest {
        launch {
            viewModel.compareTexts("hello", "HELLO")
        }

        advanceUntilIdle()

        val result = viewModel.compare.value?.result

        assertEquals("Los textos NO son iguales", result)
    }
}





