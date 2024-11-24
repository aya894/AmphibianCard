package com.example.amphibiancard.network

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import com.example.amphibiancard.data.model.Amphibian

interface AmphibiansApiService {
    @GET("amphibians") // Point de terminaison pour récupérer les amphibiens
    suspend fun getAmphibians(): List<Amphibian>
}

object RetrofitClient {
    private const val BASE_URL = "https://api.amphibiancard.com/"


    val apiService: AmphibiansApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create()) // Utilisation de Moshi pour la conversion JSON
            .build()
            .create(AmphibiansApiService::class.java)
    }
}
