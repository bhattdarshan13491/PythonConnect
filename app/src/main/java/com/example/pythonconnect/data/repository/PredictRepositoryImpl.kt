package com.example.pythonconnect.data.repository

import com.example.pythonconnect.data.remote.PredictApi
import com.example.pythonconnect.data.remote.PredictionRequestDto
import javax.inject.Inject

class PredictRepositoryImpl @Inject constructor(
    private val api: PredictApi
) : PredictionRepository {
    override suspend fun predictRisk(
        yearsAsCustomer: Int,
        averageTransactionValue: Double,
        onTimePaymentRatio: Double,
        pastCreditDefault: String,
    ): Double {
        return api.predictRisk(
            PredictionRequestDto(
                yearsAsCustomer = 10,
                purchaseFrequencyDays = 30,
                averageTransactionValue = 100.0f,
                onTimePaymentRatio = 0.9,
                pastCreditDefault = "0"
            )
        ).creditLimit
    }
}