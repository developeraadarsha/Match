package com.example.projectone.roomdb

import com.example.projectone.model.Results

class DatabaseHelperImpl (private val appDatabase: AppDatabase) : DatabaseHelper {

    override suspend fun getResults(): List<Results> = appDatabase.resultsDao().getAll()

    override suspend fun insertAll(results: List<Results>) = appDatabase.resultsDao().insertAll(results)


}