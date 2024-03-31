package com.example.carantecnautisme
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.carantecnautisme.models.PlongeeModel

@Dao
interface PlongeeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPlongee(plongee: InscriptionPlongee)

    @Query("SELECT * FROM plongees_inscrites")
    fun getAll(): LiveData<List<InscriptionPlongee>>
}