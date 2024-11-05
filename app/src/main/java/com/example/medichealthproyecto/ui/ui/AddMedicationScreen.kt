@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.medichealthproyecto.ui.ui


import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.medichealthproyecto.model.Medication
import com.example.medichealthproyecto.viewmodel.MedicationViewModel
import kotlinx.coroutines.launch

@Composable
fun AddMedicationScreen(viewModel: MedicationViewModel) {
    val name = remember { mutableStateOf("") }
    val dosage = remember { mutableStateOf("") }
    val frequency = remember { mutableStateOf("") }
    val snackbarHostState = remember { SnackbarHostState() }

    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Add Medication") }
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) },
        content = { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                TextField(
                    value = name.value,
                    onValueChange = { name.value = it },
                    label = { Text("Medication Name") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = dosage.value,
                    onValueChange = { dosage.value = it },
                    label = { Text("Dosage") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextField(
                    value = frequency.value,
                    onValueChange = { frequency.value = it },
                    label = { Text("Frequency") },
                    modifier = Modifier.fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    onClick = {
                        if (name.value.isNotBlank() && dosage.value.isNotBlank() && frequency.value.isNotBlank()) {
                            val medication = Medication(
                                name = name.value,
                                dosage = dosage.value,
                                frequency = frequency.value,
                                startDate = System.currentTimeMillis(),
                                endDate = System.currentTimeMillis() + 10000000 // Ejemplo de duración
                            )
                            viewModel.insertMedication(medication)

                            scope.launch {
                                snackbarHostState.showSnackbar("Medication added successfully")
                            }
                        }
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Add Medication")
                }
            }
        }
    )
}
