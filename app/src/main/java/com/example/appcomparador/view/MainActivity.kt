package com.example.appcomparador.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.appcomparador.databinding.ActivityMainBinding
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var compareViewModel: CompareViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        compareViewModel = ViewModelProvider(this).get(CompareViewModel::class.java)

        compareViewModel.compare.observe(this) { compareResult ->
            binding.resultTextView.text = compareResult.result
        }

        binding.compareButton.setOnClickListener {
            compareViewModel.compareTexts(binding.editText1.text.toString(), binding.editText2.text.toString())
        }

    }
}