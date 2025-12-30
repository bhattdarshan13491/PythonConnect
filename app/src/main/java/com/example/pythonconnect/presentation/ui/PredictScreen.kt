package com.example.pythonconnect.presentation.ui

import android.util.Log
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
                yearsAsCustomer = 10,
                averageTransactionValue = 1000.0,
                onTimePaymentRatio = 0.9,
                pastCreditDefault = "0"
            )
        }) {
            Text("Predict Risk")
        }

        if (state.isLoading) {
            CircularProgressIndicator()
        }

        state.risk?.let {
            Log.d("PredictViewModel", "UI. onPredict: $it")
            Text("Risk: ${it.toString()}")
        }

    }
}