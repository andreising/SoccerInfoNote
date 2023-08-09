package com.andreisingeleytsev.soccernotebet.data.retrofit.datamodels

import com.google.gson.annotations.SerializedName

data class Team (

    @SerializedName("id"       ) var id       : Int?     = null,
    @SerializedName("name"     ) var name     : String?  = null,
    @SerializedName("code"     ) var code     : String?  = null,
    @SerializedName("country"  ) var country  : String?  = null,
    @SerializedName("founded"  ) var founded  : Int?     = null,
    @SerializedName("national" ) var national : Boolean? = null,
    @SerializedName("logo"     ) var logo     : String?  = null

)
