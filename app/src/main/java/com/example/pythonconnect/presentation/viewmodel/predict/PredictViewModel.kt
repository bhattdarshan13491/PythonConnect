package com.example.pythonconnect.presentation.viewmodel.predict

import androidx.compose.runtime.getValue
import androidx.lifecycle.viewModelScope
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.pythonconnect.domain.PredictionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PredictViewModel @Inject constructor(
    private val predictRiskUseCase: PredictionUseCase
) : ViewModel() {

    var state by mutableStateOf(PredictState())
        private set

    fun onPredict(yearsAsCustomer: Int,
                  averageTransactionValue: Double,
                  onTimePaymentRatio: Double,
                  pastCreditDefault: String,) {
        viewModelScope.launch {
            state = state.copy(isLoading = true)
            val result = predictRiskUseCase(
                yearsAsCustomer,
                averageTransactionValue,
                onTimePaymentRatio,
                pastCreditDefault
            )
            state = state.copy(
                isLoading = false,
                risk = result
            )
        }
    }
}
