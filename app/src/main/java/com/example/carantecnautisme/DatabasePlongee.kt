package com.example.carantecnautisme

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration

@Database(entities = [InscriptionPlongee::class], version = 1)
abstract class DatabasePlongee : RoomDatabase() {
    abstract fun plongeeDao(): PlongeeDao
    abstract fun AdherentDao(): AdherentDao
    companion object {
        private var instance: DatabasePlongee? = null

        fun getInstance(context: Context): DatabasePlongee {
            if (DatabasePlongee.instance == null) {
                instance = Room.databaseBuilder(
                    context,
                    DatabasePlongee::class.java,
                    "base.sqlite"
                ).addMigrations(Migration(1,2) {/* ... */}).build()
            }
            return instance!!
        }
    }

}