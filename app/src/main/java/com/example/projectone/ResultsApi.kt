package com.example.projectone

import com.example.projectone.model.ExampleJson2KtKotlin
import com.example.projectone.model.Results
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface ResultsApi {
    @GET("/api/?results=10")

     fun getResults(): Call<ExampleJson2KtKotlin>
}