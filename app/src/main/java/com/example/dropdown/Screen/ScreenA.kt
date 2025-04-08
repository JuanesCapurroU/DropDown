package com.example.dropdown.Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.dropdown.viewmodel.Persona

@Composable
fun ScreenA(navController: NavController, personaViewModel: Persona) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var profesion by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TextField(value = name, onValueChange = { name = it }, label = { Text("Nombre") })
        Spacer(modifier = Modifier.height(16.dp))
        TextField(value = email, onValueChange = { email = it }, label = { Text("Correo Electrónico") })
        Spacer(modifier = Modifier.height(16.dp))
        TextField(value = profesion, onValueChange = { profesion = it }, label = { Text("Profesión") })
        Spacer(modifier = Modifier.height(30.dp))
        Button(onClick = {
            personaViewModel.agregarPersona(name, email, profesion)
            navController.navigate("screenB")
        }) {
            Text("Enviar e ir a la Pantalla B")
        }
    }
}
