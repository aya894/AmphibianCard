package com.example.amphibiancard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.amphibiancard.di.AppContainer
import com.example.amphibiancard.ui.theme.AmphibianCardTheme
import com.example.amphibiancard.uii.viewmodel.AmphibiansViewModel
import com.example.amphibiancard.uii.screens.HomeScreen
import com.example.amphibiancard.ViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AmphibianCardTheme {
                val viewModel: AmphibiansViewModel = viewModel(
                    factory = ViewModelFactory(AppContainer.repository) // Assurez-vous que le repository est exposé correctement
                )
                HomeScreen(viewModel) // Affiche l'écran principal avec le ViewModel
            }
        }
    }
}
