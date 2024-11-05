package com.example.medichealthproyecto
/*
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.medichealthproyecto.theme.MedicHealthProyectoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MedicHealthProyectoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

*/

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.compose.rememberNavController
import com.example.medichealthproyecto.model.MedicationDatabase
import com.example.medichealthproyecto.repository.MedicationRepository
import com.example.medichealthproyecto.ui.ui.NavGraph
import com.example.medichealthproyecto.theme.MedicHealthProyectoTheme
import com.example.medichealthproyecto.viewmodel.MedicationViewModel
import com.example.medichealthproyecto.viewmodel.MedicationViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inicializar la base de datos y el repositorio
        val dao = MedicationDatabase.getDatabase(applicationContext).medicationDao()
        val repository = MedicationRepository(dao)
        val viewModelFactory = MedicationViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, viewModelFactory)[MedicationViewModel::class.java]

        setContent {
            MedicHealthProyectoTheme {
                val navController = rememberNavController()
                NavGraph(navController = navController, viewModel = viewModel)
            }
        }
    }
}
