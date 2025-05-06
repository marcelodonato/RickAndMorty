package com.example.ebdiandroid.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.ebdiandroid.R
import com.example.ebdiandroid.adapter.model.CarouselEntity
import com.example.ebdiandroid.adapter.model.ProfileCardEntity
import com.example.ebdiandroid.bases.BaseViewModel
import com.example.ebdiandroid.data.model.CharacterEntity
import com.example.ebdiandroid.domain.useCase.RickAndMortyUseCase
import kotlinx.coroutines.launch

class HomeViewModel(private val useCase: RickAndMortyUseCase) : BaseViewModel() {

    private val _onCharacterList = MutableLiveData<List<CharacterEntity?>>()
    val onCharacterList: LiveData<List<CharacterEntity?>> get() = _onCharacterList

    private val _onError = MutableLiveData<String>()
    val onError: LiveData<String> get() = _onError


    fun getCharacters() {
        viewModelScope.launch {
            try {
                val characters = useCase.getCharacters()
                _onCharacterList.postValue(characters)
            } catch (e: Exception) {
                _onError.postValue("Erro ao buscar personagens: ${e.message}")
            }
        }
    }


    fun mockProfileCardItems(): List<ProfileCardEntity> {
        return listOf(
            ProfileCardEntity(
                "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                "Marcelo Donato"
            ),
            ProfileCardEntity(
                "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
                "Marcelo Donato"
            ),
        )
    }


    fun mockBanners(): List<CarouselEntity> {
        return listOf(
            CarouselEntity(R.drawable.banner_1),
            CarouselEntity(R.drawable.banner_2),
            CarouselEntity(R.drawable.banner_3),
        )
    }
}