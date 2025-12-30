package com.example.pythonconnect.presentation.viewmodel.predict

data class PredictState(
    val isLoading: Boolean = false,
    val approvedCreditLimit: Double? = null,
    val customerId: String = "",
    val error: String? = null,
)

sealed interface PredictAction{
    data class UpdateCustomerId(val customerId: String) : PredictAction
    data class GetCreditLimitByCustomerId(val customerId: String) : PredictAction
}