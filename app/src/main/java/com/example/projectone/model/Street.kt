package com.example.projectone.model

import com.google.gson.annotations.SerializedName


data class Street (

  @SerializedName("number" ) var number : Int?    = null,
  @SerializedName("name"   ) var name   : String? = null

)