package com.example.ebdiandroid.data

import com.example.ebdiandroid.bases.BaseResponse
import com.example.ebdiandroid.data.model.CharacterEntity
import retrofit2.http.GET

interface RickAndMortyAPI {

    companion object {
        const val  GET_CHARACTERS = "character"
    }

    @GET(GET_CHARACTERS)
    suspend fun getCharacters() : BaseResponse<List<CharacterEntity>>
}