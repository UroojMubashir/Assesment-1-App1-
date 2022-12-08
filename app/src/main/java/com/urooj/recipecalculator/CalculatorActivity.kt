package com.urooj.recipecalculator

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.urooj.recipecalculator.databinding.ActivityCalculatorBinding
import com.urooj.recipecalculator.databinding.ActivityMainBinding

class CalculatorActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityCalculatorBinding
    private val ingredients = mutableListOf<Ingredients>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()
    }

    private fun initViews() {
        binding.egg.tag = Ingredients.EGG
        binding.egg.setOnClickListener(this)
        binding.cream.tag = Ingredients.CREAM
        binding.cream.setOnClickListener(this)
        binding.chocolate.tag = Ingredients.CHOCOLATE
        binding.chocolate.setOnClickListener(this)
        binding.coffee.tag = Ingredients.COFFEE
        binding.coffee.setOnClickListener(this)
        binding.banana.tag = Ingredients.BANANA
        binding.banana.setOnClickListener(this)
        binding.mango.tag = Ingredients.MANGO
        binding.mango.setOnClickListener(this)
        binding.oreo.tag = Ingredients.OREO
        binding.oreo.setOnClickListener(this)
        binding.flour.tag = Ingredients.FLOUR
        binding.flour.setOnClickListener(this)
        binding.marbleCake.tag = Ingredients.MARBLE_CAKE
        binding.marbleCake.setOnClickListener(this)
        binding.nutella.tag = Ingredients.NUTELLA
        binding.nutella.setOnClickListener(this)
        binding.clear.setOnClickListener {
            ingredients.clear()
            binding.display.text = ""
        }
        binding.add.setOnClickListener {
            if (ingredients.lastOrNull() != Ingredients.PLUS) {
                ingredients.add(Ingredients.PLUS)
                updateDisplay()
            }
        }
        binding.delete.setOnClickListener {
            ingredients.removeLastOrNull()
            updateDisplay()
        }
        binding.calculate.setOnClickListener {
            if (ingredients.isNotEmpty()) {
                val deserts = calculate(ingredients)
                if (deserts == Deserts.NONE) {
                    showMessage("Invalid ingredients")
                } else {
                    binding.display.text = deserts.desertName
                    ingredients.clear()
                }
            }
        }
    }

    private fun updateDisplay() {
        val display = StringBuilder()
        for(ingredient in ingredients) {
            display.append(ingredient.ingredientName)
            display.append(" ")
        }
        binding.display.text = display
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onClick(view: View) {
        val tag = view.tag as Ingredients
        if (ingredients.isEmpty() || ingredients.last() == Ingredients.PLUS) {
            ingredients.add(tag)
            updateDisplay()
        }
    }
}