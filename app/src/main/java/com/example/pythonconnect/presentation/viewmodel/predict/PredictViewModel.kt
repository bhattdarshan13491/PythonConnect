package com.example.pythonconnect.presentation.viewmodel.predict

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewModelScope
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.pythonconnect.data.repository.customer.CustomerRepository
import com.example.pythonconnect.domain.PredictionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PredictViewModel @Inject constructor(
    private val predictRiskUseCase: PredictionUseCase,
    private val customerRepository: CustomerRepository,
) : ViewModel() {

    var state by mutableStateOf(PredictState())
        private set

    fun onAction(action: PredictAction) {
        when (action) {
            is PredictAction.UpdateCustomerId -> {
                state = state.copy(customerId = action.customerId)
            }
            is PredictAction.GetCreditLimitByCustomerId -> {
                onPredict(action.customerId)
            }
        }

    }

    private fun onPredict(customerId: String) {
        viewModelScope.launch {
            val customer = customerRepository.getCustomerById(customerId)

            if (customer == null) {
                state = state.copy(error = "Customer not found")
                return@launch
            }

            state = state.copy(error = null, isLoading = true)

            state = state.copy(isLoading = true)
            val result = predictRiskUseCase(
                customer.yearsAsCustomer,
                customer.averageTransactionValue,
                customer.onTimePaymentRatio,
                customer.pastCreditDefault
            )
            Log.d("PredictViewModel", "VM. onPredict: $result")
            state = state.copy(
                isLoading = false,
                approvedCreditLimit = result
            )
        }
    }
}
