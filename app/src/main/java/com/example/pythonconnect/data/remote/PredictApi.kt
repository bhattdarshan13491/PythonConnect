package com.example.pythonconnect.data.remote

import retrofit2.http.Body
import retrofit2.http.POST

interface PredictApi {

    @POST("predict")
    suspend fun predictRisk(
        @Body request: PredictionRequestDto
    ): PredictionResponseDto
}