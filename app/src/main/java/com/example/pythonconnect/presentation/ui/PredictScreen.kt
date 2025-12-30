package com.example.pythonconnect.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.pythonconnect.R
import com.example.pythonconnect.presentation.viewmodel.predict.PredictAction
import com.example.pythonconnect.presentation.viewmodel.predict.PredictViewModel

@Composable
fun PredictScreen(
    viewModel: PredictViewModel = hiltViewModel()
) {
    val state = viewModel.state
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {

        // -------- Title --------
        Text(
            text = stringResource(R.string.credit_limit_predictor),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // -------- Customer ID Input --------
        OutlinedTextField(
            value = state.customerId,
            onValueChange = {
                viewModel.onAction(PredictAction.UpdateCustomerId(customerId = it))
            },
            label = { Text(stringResource(R.string.customer_id)) },
            placeholder = { Text("cust_001") },
            isError = state.error != null,
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedTextColor = Color.Blue,
                unfocusedTextColor = Color.Black,
                focusedLabelColor = Color.Blue,
                errorTextColor = Color.Red,
                errorLabelColor = Color.Red,
                errorBorderColor = Color.Red
            )
        )

        // -------- Error Message --------
        if (state.error != null) {
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = state.error,
                color = Color.Red,
                style = MaterialTheme.typography.bodySmall
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // -------- Action Button --------
        Button(
            onClick = {
                viewModel.onAction(PredictAction.GetCreditLimitByCustomerId(state.customerId))
            },
            enabled = !state.isLoading,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = if (state.isLoading) "Please wait..." else "Get Credit Limit",
                style = MaterialTheme.typography.titleMedium
            )
        }

        // -------- Result --------
        state.approvedCreditLimit?.let { limit ->
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = stringResource(R.string.approved_credit_limit),
                color = Color.Black,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "₹ $limit",
                style = MaterialTheme.typography.headlineSmall,
                color = Color.Green,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun PredictScreenPreview() {
    PredictScreen(
        viewModel = hiltViewModel(),
    )
}