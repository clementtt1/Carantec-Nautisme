package com.example.carantecnautisme

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plongees_inscrites")
data class InscriptionPlongee(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0, //Id de l'inscription
    var plongeeId: Int, // L'ID de la plongée
)