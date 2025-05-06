package com.example.ebdiandroid.presentation

import android.app.Application
import com.example.ebdiandroid.di.api
import com.example.ebdiandroid.di.dataSource
import com.example.ebdiandroid.di.repository
import com.example.ebdiandroid.di.useCase
import com.example.ebdiandroid.di.viewModel
import com.example.ebdiandroid.security.securityModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class RickAndMortyAppApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@RickAndMortyAppApplication)
            androidLogger(Level.ERROR)
            modules(securityModule, viewModel, useCase, repository, api, dataSource)
        }
    }
}