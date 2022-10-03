package com.example.projectone.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Results (
  @PrimaryKey val uid: Int,
  @SerializedName("gender"     ) var gender     : String?     = "",
  @SerializedName("name"       ) var name       : Name?       = Name(),
  @SerializedName("location"   ) var location   : Location?   = Location(),
  @SerializedName("email"      ) var email      : String?     = "",
  @SerializedName("login"      ) var login      : Login?      = Login(),
  @SerializedName("dob"        ) var dob        : Dob?        = Dob(),
  @SerializedName("registered" ) var registered : Registered? = Registered(),
  @SerializedName("phone"      ) var phone      : String?     = "",
  @SerializedName("cell"       ) var cell       : String?     = "",
  @SerializedName("id"         ) var id         : Id?         = Id(),
  @SerializedName("picture"    ) var picture    : Picture?    = Picture(),
  @SerializedName("nat"        ) var nat        : String?     = "",
  var status : String? = ""

)