package com.andreisingeleytsev.soccernotebet.data.retrofit.datamodels

import com.google.gson.annotations.SerializedName

data class CurrentLeague(
    @SerializedName("get"        ) var get        : String?             = null,
    @SerializedName("parameters" ) var parameters : Parameters?         = Parameters(),
    @SerializedName("errors"     ) var errors     : ArrayList<String>   = arrayListOf(),
    @SerializedName("results"    ) var results    : Int?                = null,
    @SerializedName("paging"     ) var paging     : Paging?             = Paging(),
    @SerializedName("response"   ) var response   : ArrayList<Response> = arrayListOf()
)

data class Parameters (

    @SerializedName("league" ) var league : String? = null,
    @SerializedName("season" ) var season : String? = null

)

data class Paging (

    @SerializedName("current" ) var current : Int? = null,
    @SerializedName("total"   ) var total   : Int? = null

)



data class Venue (

    @SerializedName("id"       ) var id       : Int?    = null,
    @SerializedName("name"     ) var name     : String? = null,
    @SerializedName("address"  ) var address  : String? = null,
    @SerializedName("city"     ) var city     : String? = null,
    @SerializedName("capacity" ) var capacity : Int?    = null,
    @SerializedName("surface"  ) var surface  : String? = null,
    @SerializedName("image"    ) var image    : String? = null

)

data class Response (

    @SerializedName("team"  ) var team  : Team?  = Team(),
    @SerializedName("venue" ) var venue : Venue? = Venue()

)
