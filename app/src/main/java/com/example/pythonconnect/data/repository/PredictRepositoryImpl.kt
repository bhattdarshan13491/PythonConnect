package com.example.pythonconnect.data.repository

import com.example.pythonconnect.data.remote.PredictApi
import com.example.pythonconnect.data.remote.PredictionRequestDto
import javax.inject.Inject

class PredictRepositoryImpl @Inject constructor(
    private val api: PredictApi
) : PredictionRepository {
    override suspend fun predictRisk(
        age: Int,
        bmi: Double,
        steps: Int
    ): String {
        return api.predictRisk(
            PredictionRequestDto(
                age, bmi, steps
            )
        ).risk
    }
}