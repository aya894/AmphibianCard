package com.example.amphibiancard.uii.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.amphibiancard.data.repository.AmphibiansRepository
import com.example.amphibiancard.uii.viewmodel.AmphibiansViewModel
import com.example.amphibiancard.ui.theme.AmphibiansAppTheme
import com.example.amphibiancard.uii.AmphibianCard

@Composable
fun HomeScreen(viewModel: AmphibiansViewModel) {
    // Collecte des données des amphibiens du StateFlow dans le ViewModel
    val amphibians = viewModel.amphibians.collectAsState(initial = emptyList()).value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Amphibians",
            style = MaterialTheme.typography.titleLarge.copy(fontSize = 24.sp)
        )

        // Utilisation de LazyColumn pour afficher les amphibiens
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(amphibians) { amphibian ->
                AmphibianCard(
                    title = amphibian.name,
                    description = amphibian.description,
                    imageResource = amphibian.imageResource
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    // Créez un repository mocké
    val mockRepository = AmphibiansRepository(null)  // Vous pouvez passer `null` si l'API n'est pas nécessaire pour la prévisualisation.
    // Passez le repository mocké au ViewModel via la factory
    val mockViewModel = AmphibiansViewModel(mockRepository)
    HomeScreen(viewModel = mockViewModel)
}
