package com.example.projectone.model

import com.google.gson.annotations.SerializedName


data class ExampleJson2KtKotlin (

  @SerializedName("results" ) var results : ArrayList<Results> = arrayListOf(),
  @SerializedName("info"    ) var info    : Info?              = Info()

)