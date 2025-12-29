package com.example.pythonconnect.data.remote

data class PredictionRequestDto(
    val age: Int,
    val bmi: Double,
    val steps: Int
)