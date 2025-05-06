package com.example.ebdiandroid.domain.useCase

import com.example.ebdiandroid.domain.repository.RickAndMortyRepository

class RickAndMortyUseCaseImpl(private val repository: RickAndMortyRepository) : RickAndMortyUseCase {

    override suspend fun getCharacters() = repository.getCharacters()
}