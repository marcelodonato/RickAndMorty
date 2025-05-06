package com.example.ebdiandroid.extensions

import org.koin.core.scope.Scope
import retrofit2.Retrofit

fun Scope.getRetrofit() = get<Retrofit>()