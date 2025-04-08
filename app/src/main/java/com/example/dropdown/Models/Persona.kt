package com.example.dropdown.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

data class PersonaData(val nombre: String, val email: String, val profesion: String)

class Persona : ViewModel() {
    private val _personas = mutableStateListOf<PersonaData>()
    val personas: List<PersonaData> = _personas

    fun agregarPersona(nombre: String, email: String, profesion: String) {
        _personas.add(PersonaData(nombre, email, profesion))
    }
}
