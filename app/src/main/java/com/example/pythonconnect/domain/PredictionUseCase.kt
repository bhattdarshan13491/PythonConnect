package com.example.pythonconnect.domain

import com.example.pythonconnect.data.repository.PredictionRepository
import javax.inject.Inject

class PredictionUseCase @Inject constructor(
    private val repository: PredictionRepository
) {
    suspend operator fun invoke(
        yearsAsCustomer: Int,
        averageTransactionValue: Double,
        onTimePaymentRatio: Double,
        pastCreditDefault: String,
    ): Double {
        return repository.predictRisk(yearsAsCustomer, averageTransactionValue, onTimePaymentRatio, pastCreditDefault)
    }
}