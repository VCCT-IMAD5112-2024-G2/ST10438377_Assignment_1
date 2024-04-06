package com.example.myapplication11

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    enum class HistoricalEvent(val year: Int, val description: String) {
        EVENT_1(1975, "Declaration of independence in Angola"),
        EVENT_2(1922, "Was born the first president of Angola"),
        EVENT_3(1969, "Neil Armstrong went to the moon"),
        EVENT_4(1979, "The first president of Angola died"),
        EVENT_5(1999, "Mengue was born"),
        EVENT_6(2005, "Celebrate human rights in Angola"),
        EVENT_7(2002, "Celebrate the date of peace in Angola"),
        EVENT_8(2007, "Celebrate Angola day"),
        EVENT_9(2011, "Contract between Angola and China"),
        EVENT_10(2022, "Second president of Angola left the field"),
    }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userYear = findViewById<EditText>(R.id.editTextNumber)
        val displayResult = findViewById<Button>(R.id.button)
        val clearApp = findViewById<Button>(R.id.button2)
        val txtResult = findViewById<TextView>(R.id.textView)

        displayResult.setOnClickListener {
            val birthYearString = userYear.text.toString()
            val birthYear = birthYearString.toIntOrNull()
            if (birthYear == null || birthYear !in 1500..2024) {
                txtResult.text = "Please enter a valid year between 1500 and 2024."
                return@setOnClickListener
            }

            val events = HistoricalEvent.values().filter { it.year == birthYear }.map { "In $birthYear: ${it.description}" }
            txtResult.text = if (events.isNotEmpty()) events.joinToString() else "No historical events found for $birthYear."
        }

        clearApp.setOnClickListener {
            userYear.text.clear()
            txtResult.text = "Event"
        }
    }
}
