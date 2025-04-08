package com.example.dropdown.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.dropdown.viewmodel.Persona

@Composable
fun ScreenB(navController: NavController, personaViewModel: Persona) {
    val personas = personaViewModel.personas

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        personas.forEach { persona ->
            Text(text = "Nombre: ${persona.nombre}")
            Text(text = "Correo Electrónico: ${persona.email}")
            Text(text = "Profesión: ${persona.profesion}")
            Spacer(modifier = Modifier.height(20.dp))
        }
        Button(onClick = { navController.popBackStack() }) {
            Text("Volver a Pantalla A")
        }
    }
}