package com.example.carantecnautisme.models

data class NiveauModel (
    val id: Int? = null,
    val libelle: String? = null,
    val code: String? = null,
    val profondeur_si_encadre: Int? = null,
    val profondeur_si_autonome: Int? = null,
    val niveau: Int? = null,
    val guide_de_palanquee: Boolean? = null,
    val directeur_de_plongee: Boolean? = null,
)
