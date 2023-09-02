package com.example.appcomparador.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import com.example.appcomparador.R
import com.example.appcomparador.viewmodel.CompareViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProvider(this).get(CompareViewModel::class.java)

        val compareButton = findViewById<Button>(R.id.compareButton)
        val clearButton = findViewById<Button>(R.id.clearButton)
        compareButton.setOnClickListener {
            viewModel.compareTexts()
        }

        clearButton.setOnClickListener {
            viewModel.clearFields()
        }
    }
}