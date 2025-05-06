package com.example.ebdiandroid.domain.repository

import com.example.ebdiandroid.data.model.CharacterEntity

interface RickAndMortyRepository {

     suspend fun getCharacters() : List<CharacterEntity>
}