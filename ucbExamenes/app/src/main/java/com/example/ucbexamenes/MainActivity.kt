package com.example.ucbexamenes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.ucbexamenes.di.AppModule
import com.example.ucbexamenes.features.time.presentation.TimeScreen
import com.jakewharton.threetenabp.AndroidThreeTen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        AndroidThreeTen.init(this)

        val viewModel = AppModule.provideTimeViewModel()

        setContent {
            TimeScreen(viewModel)
        }
    }
}