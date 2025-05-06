package com.example.ebdiandroid.data

import com.example.ebdiandroid.data.model.CharacterEntity

class RickAndMortyRemoteDataSource(private val api: RickAndMortyAPI) {

    suspend fun getCharacters() : List<CharacterEntity> {
        val response = api.getCharacters()
        return response.results
    }

}