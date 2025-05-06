package com.example.ebdiandroid.di

import com.example.ebdiandroid.data.RickAndMortyRemoteDataSource
import com.example.ebdiandroid.data.RickAndMortyAPI
import com.example.ebdiandroid.domain.repository.RickAndMortyRepository
import com.example.ebdiandroid.domain.repository.RickAndMortyRepositoryImpl
import com.example.ebdiandroid.domain.useCase.RickAndMortyUseCase
import com.example.ebdiandroid.domain.useCase.RickAndMortyUseCaseImpl
import com.example.ebdiandroid.extensions.getRetrofit
import com.example.ebdiandroid.presentation.viewModel.HomeViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModel = module {
    viewModel { HomeViewModel(get()) }
}

val useCase = module {
    single<RickAndMortyUseCase> {RickAndMortyUseCaseImpl(get())}
}

val repository = module {
    single<RickAndMortyRepository> {RickAndMortyRepositoryImpl(get())}
}

val dataSource = module {
    single { RickAndMortyRemoteDataSource(get()) }
}

val api = module {
    single<RickAndMortyAPI> {getRetrofit().create(RickAndMortyAPI::class.java)}
 }