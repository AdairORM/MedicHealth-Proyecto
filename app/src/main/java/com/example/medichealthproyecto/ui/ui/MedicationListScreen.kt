@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.medichealthproyecto.ui.ui



import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.medichealthproyecto.model.Medication
import com.example.medichealthproyecto.viewmodel.MedicationViewModel

@Composable
fun MedicationListScreen(viewModel: MedicationViewModel) {
    val medications by viewModel.allMedications.collectAsState(initial = emptyList())

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Medication Reminder") }
            )
        }
    ) { padding ->
        LazyColumn(
            contentPadding = padding,
            modifier = Modifier.fillMaxSize()
        ) {
            items(medications.size) { index ->
                val medication = medications[index]
                MedicationItem(medication)
            }
        }
    }
}

@Composable
fun MedicationItem(medication: Medication) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(text = "Name: ${medication.name}", style = MaterialTheme.typography.bodyLarge)
        Text(text = "Dosage: ${medication.dosage}", style = MaterialTheme.typography.bodyMedium)
        Text(text = "Frequency: ${medication.frequency}", style = MaterialTheme.typography.bodyMedium)
    }
}
