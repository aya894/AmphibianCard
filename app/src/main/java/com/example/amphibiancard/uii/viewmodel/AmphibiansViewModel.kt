package com.example.amphibiancard.uii.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.amphibiancard.data.model.Amphibian
import com.example.amphibiancard.data.repository.AmphibiansRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AmphibiansViewModel(private val repository: AmphibiansRepository) : ViewModel() {

    private val _amphibians = MutableStateFlow<List<Amphibian>>(emptyList())
    val amphibians: StateFlow<List<Amphibian>> = _amphibians

    init {
        loadAmphibians()
    }

    private fun loadAmphibians() {
        viewModelScope.launch {
            _amphibians.value = repository.getAmphibians()
        }
    }
}
