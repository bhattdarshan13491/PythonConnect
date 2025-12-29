package com.example.pythonconnect.domain

import com.example.pythonconnect.data.repository.PredictionRepository
import javax.inject.Inject

class PredictionUseCase @Inject constructor(
    private val repository: PredictionRepository
) {
    suspend operator fun invoke(
        age: Int,
        bmi: Double,
        steps: Int
    ): String {
        return repository.predictRisk(age, bmi, steps)
    }
}