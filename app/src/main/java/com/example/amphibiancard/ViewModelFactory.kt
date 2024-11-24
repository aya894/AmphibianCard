package com.example.amphibiancard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.amphibiancard.data.repository.AmphibiansRepository
import com.example.amphibiancard.uii.viewmodel.AmphibiansViewModel

class ViewModelFactory(private val repository: AmphibiansRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AmphibiansViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AmphibiansViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
