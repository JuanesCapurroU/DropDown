package com.example.dropdown

import DropdownRow
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.dropdown.Screen.ScreenA
import com.example.dropdown.Screen.navegationExample
import com.example.dropdown.ui.theme.DropDownTheme
import com.example.dropdown.viewmodel.Persona

class MainActivity : ComponentActivity() {
    private val personaViewModel: Persona by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DropDownTheme {
                navegationExample(personaViewModel)
            }
        }
    }
}