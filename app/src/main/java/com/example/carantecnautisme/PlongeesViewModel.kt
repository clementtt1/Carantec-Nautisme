package com.example.carantecnautisme

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Query
import com.example.carantecnautisme.models.PlongeeModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlongeesViewModel(val app: Application): AndroidViewModel(app) {
    private val base = DatabasePlongee.getInstance(app)

    fun insertPlongee(plongee: InscriptionPlongee) {
        viewModelScope.launch(Dispatchers.IO) {
            val idenfiant = base.plongeeDao().insertPlongee(plongee)
            //plongee.id = idenfiant
        }
    }

    fun getAllPlongees(): LiveData<List<InscriptionPlongee>> {
        return base.plongeeDao().getAll()
    }
}
