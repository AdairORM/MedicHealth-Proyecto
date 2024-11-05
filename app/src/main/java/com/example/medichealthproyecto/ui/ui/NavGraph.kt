package com.example.medichealthproyecto.ui.ui


import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.medichealthproyecto.viewmodel.MedicationViewModel



@Composable
fun NavGraph(navController: NavController, viewModel: MedicationViewModel) {
    NavHost(navController = navController as NavHostController, startDestination = "medication_list") {
        composable("medication_list") {
            MedicationListScreen(viewModel = viewModel)
        }
        composable("add_medication") {
            AddMedicationScreen(viewModel = viewModel)
        }
    }
}
