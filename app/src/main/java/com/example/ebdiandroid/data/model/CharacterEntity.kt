package com.example.ebdiandroid.data.model

import com.google.gson.annotations.SerializedName

data class CharacterEntity(
    @SerializedName("id") val id: Int? = null,
    @SerializedName("name") val name: String? = null,
    @SerializedName("status") val status: String? = null,
    @SerializedName("species") val species: String? = null,
    @SerializedName("type") val type: String? = null,
    @SerializedName("gender") val gender: String? = null,
    @SerializedName("origin") val origin: Kind? = null,
    @SerializedName("location") val location: Kind? = null,
    @SerializedName("image") val image: String? = null,
    @SerializedName("episode") val episode: List<String>? = null,
    @SerializedName("url") val url: String? = null,
    @SerializedName("created") val created: String? = null,
)

data class Kind(
    @SerializedName("name") val name: String? = null,
    @SerializedName("url") val url: String? = null,
)