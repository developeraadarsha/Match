package com.example.projectone.roomdb


import androidx.room.Insert
import androidx.room.Query
import com.example.projectone.model.Results

interface ResultsDao {
    @Query("SELECT * FROM results")
    suspend fun getAll(): List<Results>

    @Insert
    suspend fun insertAll(results: List<Results>)

}