package com.example.carantecnautisme.models

data class PlongeeModel (
    val id: Int? = null,
    val lieu: Int? = null,
    val bateau: Int? = null,
    val date: String? = null,
    val moment: Int? = null,
    val min_plongeur: Int? = null,
    val max_plongeur: Int? = null,
    val niveau: Int? = null,
    val etat: Int? = null,
    val securite_de_surface: Int? = null,
    val actif: Boolean? = null,
)