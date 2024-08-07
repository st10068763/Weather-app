package com.example.myweather

import com.google.gson.annotations.SerializedName


data class Maximum (

  @SerializedName("Value"    ) var Value    : Double?    = null,
  @SerializedName("Unit"     ) var Unit     : String? = null,
  @SerializedName("UnitType" ) var UnitType : Int?    = null

)