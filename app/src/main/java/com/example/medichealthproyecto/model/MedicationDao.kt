package com.example.medichealthproyecto.model

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MedicationDao {
    @Insert
    suspend fun insertMedication(medication: Medication)

    @Query("SELECT * FROM medications")
    suspend fun getAllMedications(): List<Medication>
}