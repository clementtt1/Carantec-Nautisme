package com.example.carantecnautisme.models

data class PlongeeModel(
    val id: Int,
    val lieu: Int,
    val bateau: Int,
    val date: String,
    val moment: Int,
    val min_plongeur: Int,
    val max_plongeur: Int,
    val niveau: Int,
    val etat: Int,
    val securite_de_surface: Int,
    val actif: Boolean,
)