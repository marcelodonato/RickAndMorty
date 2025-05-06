package com.example.ebdiandroid.domain.useCase

import com.example.ebdiandroid.data.model.CharacterEntity

interface RickAndMortyUseCase {

    suspend fun getCharacters() : List<CharacterEntity>
}