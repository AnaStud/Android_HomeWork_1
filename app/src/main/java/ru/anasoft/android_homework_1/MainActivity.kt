package ru.anasoft.android_homework_1

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import ru.anasoft.android_homework_1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val busSize = 49
    var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        fun updateViews() {
            binding.textViewCounter.text = counter.toString()
            binding.textViewMainMessage.text = getMainText()
            binding.textViewMainMessage.setTextColor(getColourText())
            binding.buttonMinus.isEnabled = getMinusStatus()
            binding.buttonReset.visibility = getResetStatus()
        }

        binding.buttonPlus.setOnClickListener {
            counter++
            updateViews()
        }

        binding.buttonMinus.setOnClickListener {
            counter--
            updateViews()
        }

        binding.buttonReset.setOnClickListener {
            counter = 0
            updateViews()
        }
    }

    private fun getMainText(): String {
        if (counter == 0) {
            return getText(R.string.busIsEmpty).toString()
        } else if (counter > busSize) {
            return getText(R.string.busIsFull).toString()
        } else {
            return "${getText(R.string.busStatus)} ${busSize - counter}"
        }
    }

    private fun getColourText(): Int {

        if (counter == 0) {
            return Color.parseColor("#00FF00")
        } else if (counter > busSize) {
            return Color.parseColor("#FF0000")
        } else {
            return Color.parseColor("#0000FF")
        }
    }

    private fun getResetStatus(): Int {

        if (counter > busSize) {
            return View.VISIBLE
        } else {
            return View.INVISIBLE
        }
    }

    private fun getMinusStatus(): Boolean {

        if (counter == 0) {
            return false
        } else {
            return true
        }
    }
}