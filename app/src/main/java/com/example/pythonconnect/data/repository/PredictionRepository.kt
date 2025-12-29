package com.example.pythonconnect.data.repository

interface PredictionRepository {
    suspend fun predictRisk(
        age: Int,
        bmi: Double,
        steps: Int
    ): String
}