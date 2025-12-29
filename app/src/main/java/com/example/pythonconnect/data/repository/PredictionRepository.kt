package com.example.pythonconnect.data.repository

interface PredictionRepository {
    suspend fun predictRisk(
        yearsAsCustomer: Int,
        averageTransactionValue: Double,
        onTimePaymentRatio: Double,
        pastCreditDefault: String,
    ): Double
}