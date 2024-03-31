package com.example.carantecnautisme

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plongees_inscrites")
data class InscriptionAdherents(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    var license: String,
    var date_certificat: String,
    var forfait: String,
    var nom: String,
    var prenom: String,
    var email: String,
    var password: String,
    var niveau: String,
    var secretaire: Boolean,
    var directeur: Boolean,
    var securite: Boolean,
    var pilote: Boolean,
)