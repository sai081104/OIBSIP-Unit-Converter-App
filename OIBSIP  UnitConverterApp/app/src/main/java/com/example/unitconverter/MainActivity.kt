
package com.example.unitconverter

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputValue = findViewById<EditText>(R.id.inputValue)
        val unitSpinner = findViewById<Spinner>(R.id.unitSpinner)
        val convertBtn = findViewById<Button>(R.id.convertBtn)
        val resultText = findViewById<TextView>(R.id.resultText)

        val units = arrayOf("Centimeter to Meter", "Meter to Centimeter", "Kilogram to Gram", "Gram to Kilogram")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, units)
        unitSpinner.adapter = adapter

        convertBtn.setOnClickListener {
            val input = inputValue.text.toString().toDoubleOrNull()
            val selectedUnit = unitSpinner.selectedItem.toString()

            if (input == null) {
                resultText.text = "Please enter a valid number"
                return@setOnClickListener
            }

            val result = when (selectedUnit) {
                "Centimeter to Meter" -> input / 100
                "Meter to Centimeter" -> input * 100
                "Kilogram to Gram" -> input * 1000
                "Gram to Kilogram" -> input / 1000
                else -> 0.0
            }

            resultText.text = "Result: $result"
        }
    }
}
