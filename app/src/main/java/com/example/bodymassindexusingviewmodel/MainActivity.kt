package com.example.bodymassindexusingviewmodel


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.bodymassindexusingviewmodel.ui.theme.BmiScreen
import com.example.bodymassindexusingviewmodel.ui.theme.BodyMassIndexUsingViewModelTheme
import androidx.compose.material3.MaterialTheme.colorScheme as materialThemeColorScheme
import androidx.compose.material3.Surface as Surface1


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BodyMassIndexUsingViewModelTheme {
                // A surface container using the 'background' color from the theme
                Surface1(color = materialThemeColorScheme.background) {
                    BmiScreen()
                }
            }
        }
    }


}