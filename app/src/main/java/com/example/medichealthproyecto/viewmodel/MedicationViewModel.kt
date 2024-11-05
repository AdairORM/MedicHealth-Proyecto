package com.example.medichealthproyecto.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.medichealthproyecto.model.Medication
import com.example.medichealthproyecto.repository.MedicationRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MedicationViewModel(private val repository: MedicationRepository) : ViewModel() {

    // Exposición de un flujo de datos reactivos (StateFlow) para la UI
    private val _allMedications = MutableStateFlow<List<Medication>>(emptyList())
    val allMedications: StateFlow<List<Medication>> = _allMedications

    init {
        // Cargar datos al inicializar
        getMedications()
    }

    private fun getMedications() {
        viewModelScope.launch {
            repository.getAllMedications().collect { medications ->
                _allMedications.value = medications
            }
        }
    }

    fun insertMedication(medication: Medication) {
        viewModelScope.launch {
            repository.insertMedication(medication)
        }
    }

    fun deleteMedication(medication: Medication) {
        viewModelScope.launch {
            repository.deleteMedication(medication)
        }
    }
}
