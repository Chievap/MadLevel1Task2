package com.example.madlevel1task2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import com.example.madlevel1task2.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView() {
        binding.btnSubmit.setOnClickListener {
            validateInput()
        }
    }

    private fun validateInput() {
        val values = getValues()
        val answers = arrayOf("T","F","F","F")

        for (value in values) {
            if (value.isEmpty()) {
                onNotAllFilledIn()
                return
            }
            if (value != "T" && value != "F") {
                onInvalidInput();
                return
            }
        }
        for(i in values.indices){
            if(values[i] != answers[i]){
                onIncorrectAnswer()
                return
            }
        }
        onCorrectAnswer()
    }

    private fun getValues(): Array<String> {
        return arrayOf(
            binding.ptC1.text.toString().toUpperCase(Locale.ROOT),
            binding.ptC2.text.toString().toUpperCase(Locale.ROOT),
            binding.ptC3.text.toString().toUpperCase(Locale.ROOT),
            binding.ptC4.text.toString().toUpperCase(Locale.ROOT)
        )
    }

    private fun onIncorrectAnswer() {
        Toast.makeText(this, getString(R.string.incorrect), Toast.LENGTH_LONG).show()
    }

    private fun onNotAllFilledIn() {
        Toast.makeText(this, getString(R.string.fill_in_all), Toast.LENGTH_LONG).show()
    }

    private fun onInvalidInput() {
        Toast.makeText(this, getString(R.string.invalid_input), Toast.LENGTH_LONG).show()
    }

    private fun onCorrectAnswer(){
        Toast.makeText(this, getString(R.string.correct), Toast.LENGTH_LONG).show()
    }
}
