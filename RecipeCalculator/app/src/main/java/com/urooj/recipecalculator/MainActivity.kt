package com.urooj.recipecalculator

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.urooj.recipecalculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.icon.setOnClickListener { showPopup() }
    }

    private fun showPopup() {
        val dialogBuilder = AlertDialog.Builder(this)
        dialogBuilder
            .setCancelable(false)
            .setTitle(R.string.instruction_title)
            .setMessage(R.string.instruction_message)
            .setPositiveButton(R.string.instruction_button) { _, _ ->
                startActivity(Intent(this@MainActivity, CalculatorActivity::class.java))
            }
            .create()
            .show()
    }
}