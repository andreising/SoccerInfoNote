package com.andreisingeleytsev.soccernotebet.data.retrofit.datamodels

import com.google.gson.annotations.SerializedName


data class Players (
    @SerializedName("response"   ) var response   : ArrayList<ResponsePLayers> = arrayListOf()

)
data class ResponsePLayers (

    @SerializedName("player"     ) var player     : Player?           = Player()

)
data class Player(
    @SerializedName("id"          ) var id          : Int?     = null,
    @SerializedName("name"        ) var name        : String?  = null,
    @SerializedName("firstname"   ) var firstname   : String?  = null,
    @SerializedName("lastname"    ) var lastname    : String?  = null,
    @SerializedName("age"         ) var age         : Int?     = null,
    @SerializedName("birth"       ) var birth       : Birth?   = Birth(),
    @SerializedName("nationality" ) var nationality : String?  = null,
    @SerializedName("height"      ) var height      : String?  = null,
    @SerializedName("weight"      ) var weight      : String?  = null,
    @SerializedName("injured"     ) var injured     : Boolean? = null,
    @SerializedName("photo"       ) var photo       : String?  = null
)

data class Birth (

    @SerializedName("date"    ) var date    : String? = null,
    @SerializedName("place"   ) var place   : String? = null,
    @SerializedName("country" ) var country : String? = null

)