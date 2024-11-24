package com.example.amphibiancard.di

import com.example.amphibiancard.data.repository.AmphibiansRepository
import com.example.amphibiancard.network.AmphibiansApiService  // Ajoutez cette ligne
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppContainer {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://example.com/api/") // Remplacez ceci par l'URL réelle
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val apiService: AmphibiansApiService by lazy {
        retrofit.create(AmphibiansApiService::class.java)
    }

    val repository: AmphibiansRepository by lazy {
        AmphibiansRepository(apiService)
    }
}

