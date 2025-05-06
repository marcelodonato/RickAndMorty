package com.example.ebdiandroid.domain.repository

import com.example.ebdiandroid.data.RickAndMortyRemoteDataSource
import com.example.ebdiandroid.data.model.CharacterEntity

class RickAndMortyRepositoryImpl(private val remoteDataSource: RickAndMortyRemoteDataSource) : RickAndMortyRepository {
    override suspend fun getCharacters(): List<CharacterEntity> {
        return remoteDataSource.getCharacters()
    }
}