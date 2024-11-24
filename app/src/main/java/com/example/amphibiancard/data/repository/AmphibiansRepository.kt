package com.example.amphibiancard.data.repository

import com.example.amphibiancard.R
import com.example.amphibiancard.data.model.Amphibian
import com.example.amphibiancard.network.AmphibiansApiService

class AmphibiansRepository(private val apiService: AmphibiansApiService?) {

    fun getAmphibians(): List<Amphibian> {
        // Vous pouvez ici utiliser `apiService` pour récupérer les données depuis l'API.
        return listOf(
            Amphibian("Great Basin Spadefoot (Toad)", "This toad spends most of its life underground.", R.drawable.spadefoot_toad),
            Amphibian("Roraima Bush Toad (Toad)", "This toad is found in South America.", R.drawable.bush_toad)
        )
    }
}
