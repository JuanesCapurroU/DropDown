package com.example.dropdown.Screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.dropdown.viewmodel.Persona

//@Preview(showBackground = true)
@Composable
fun navegationExample(personaViewModel: Persona) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "screenA") {
        composable("screenA") {
            ScreenA(navController, personaViewModel)
        }
        composable("screenB") {
            ScreenB(navController, personaViewModel)
        }
    }
}
