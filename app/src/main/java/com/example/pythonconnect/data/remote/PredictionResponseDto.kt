package com.example.pythonconnect.data.remote

import com.google.gson.annotations.SerializedName

data class PredictionResponseDto(
    @SerializedName("approved_credit_limit")
    val creditLimit: Double
)