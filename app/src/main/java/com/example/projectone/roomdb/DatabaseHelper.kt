package com.example.projectone.roomdb

import com.example.projectone.model.Results

interface DatabaseHelper {

    suspend fun getResults(): List<Results>

    suspend fun insertAll(results: List<Results>)

}