package com.example.pythonconnect.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pythonconnect.presentation.viewmodel.predict.PredictViewModel

@Composable
fun PredictScreen(
    viewModel: PredictViewModel = hiltViewModel()
){
    val state = viewModel.state

    Column(
        modifier = Modifier.padding(
            16.dp
        ).fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            viewModel.onPredict(
                age = 32,
                bmi = 27.5,
                steps = 4000
            )
        }) {
            Text("Predict Risk")
        }

        if (state.isLoading) {
            CircularProgressIndicator()
        }

        state.risk?.let {
            Text("Risk: $it")
        }

    }
}