package com.example.bodymassindexusingviewmodel.ui.theme


import androidx.compose.foundation.layout.Column
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel


class BmiViewModel: ViewModel() {
    var height: String by mutableStateOf("")
    var weight: String by mutableStateOf("")


    val bmi: Double
        get() = calculateBmi()

    private fun calculateBmi(): Double {
        val h = height.toDoubleOrNull() ?: 0.0 // Convert height from String to Double and handle null
        val w = weight.toDoubleOrNull() ?: 0.0 // Convert weight from String to Double and handle null
        return if (h > 0 && w > 0) w / (h * h) else 0.0 // Calculate BMI if valid values, else return 0.0
    }

    fun updateHeight(newHeight: String) {
        if (newHeight.toFloatOrNull() != null) { // Validate if input is a valid float
            height = newHeight
        }
    }

    fun updateWeight(it: String) {
        if (it.toFloatOrNull() != null) { // Validate if input is a valid float
            weight = it
        }
    }

    fun getBmi(): String {
        return String.format("%.2f", bmi) // Format BMI to 2 decimal places
    }

}



@Composable
fun BmiScreen(bmiViewModel: BmiViewModel = viewModel()) {
    // Use states bound to ViewModel fields
    var height by remember { mutableStateOf(bmiViewModel.height) }
    var weight by remember { mutableStateOf(bmiViewModel.weight) }

    Column {
        OutlinedTextField(
            value = height,
            onValueChange = {
                height = it
                bmiViewModel.updateHeight(it)  // Update ViewModel
            },
            label = { Text("Height") }
        )
        OutlinedTextField(
            value = weight,
            onValueChange = {
                weight = it
                bmiViewModel.updateWeight(it)  // Update ViewModel
            },
            label = { Text("Weight") }
        )
        // Display calculated BMI
        Text(text = "BMI: ${bmiViewModel.getBmi()}")
    }
}

