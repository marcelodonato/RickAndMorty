package com.example.ebdiandroid.bases

import com.google.gson.annotations.SerializedName

data class BaseResponse<T>(
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results : T
)

data class Info(
    @SerializedName("count") val count : Int? = null,
    @SerializedName("pages") val pages : Int? = null,
    @SerializedName("next") val next : String? = null,
    @SerializedName("prev") val prev : String? = null,
)
