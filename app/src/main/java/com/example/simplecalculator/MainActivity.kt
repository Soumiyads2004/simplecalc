package com.example.simplecalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.simplecalculator.R.id

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val input1 = findViewById<EditText>(id.input1)
        val input2 = findViewById<EditText>(id.input2)
        val result = findViewById<EditText>(id.res)

        val plusButton = findViewById<Button>(id.plus)
        val minusButton = findViewById<Button>(id.minus)
        val divideButton = findViewById<Button>(id.divide)
        val multiplyButton = findViewById<Button>(id.multiply)


        plusButton.setOnClickListener {
            calculate('+', input1, input2, result)
        }

        minusButton.setOnClickListener {
            calculate('-', input1, input2, result)
        }

        divideButton.setOnClickListener {
            calculate('/', input1, input2, result)
        }

        multiplyButton.setOnClickListener {
            calculate('*', input1, input2, result)
        }
    }

    private fun calculate(operator: Char, input1: EditText, input2: EditText, result: EditText) {
        val num1 = input1.text.toString().toDouble()
        val num2 = input2.text.toString().toDouble()
        val res: Double = when (operator) {
            '+' -> num1 + num2
            '-' -> num1 - num2
            '*' -> num1 * num2
            '/' -> num1 / num2
            else -> 0.0
        }
        result.setText(res.toString())
    }
}