package com.example.ebdiandroid.presentation.viewModel


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.ebdiandroid.data.model.CharacterEntity
import com.example.ebdiandroid.domain.useCase.RickAndMortyUseCase
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import kotlin.test.Test

@ExperimentalCoroutinesApi
class HomeViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val useCase: RickAndMortyUseCase = mockk()
    private lateinit var viewModel: HomeViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(StandardTestDispatcher())
        viewModel = HomeViewModel(useCase)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `quando getCharacters for chamado, deve atualizar  o live data corretamente`() = runTest {
        val expectedResponse = listOf(
            CharacterEntity(id = 1, name = "Marcelo Test", status = "Alive", species = "Human"),
            CharacterEntity(id = 1, name = "Marcelo Test", status = "Alive", species = "Human")
        )

        coEvery { useCase.getCharacters() } returns expectedResponse

        val job = launch {
            viewModel.getCharacters()
        }

        advanceUntilIdle()

        job.cancel()
    }

    @Test
    fun `quando getCharacters falhar, deve atualizar o live data de erro`() = runTest {

        val expectedErrorMessage = "Erro de rede"

        coEvery { useCase.getCharacters() } throws RuntimeException(expectedErrorMessage)

        val job = launch {
            viewModel.getCharacters()
        }

        advanceUntilIdle()
        job.cancel()

    }



}



