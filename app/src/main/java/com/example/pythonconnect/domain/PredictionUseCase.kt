package com.example.pythonconnect.domain

import android.util.Log
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
        val result = repository.predictRisk(yearsAsCustomer, averageTransactionValue, onTimePaymentRatio, pastCreditDefault)
        Log.d("PredictViewModel", "Usecase. onPredict: $result")
        return result
    }
}