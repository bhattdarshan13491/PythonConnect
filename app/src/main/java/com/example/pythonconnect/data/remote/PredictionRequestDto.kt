package com.example.pythonconnect.data.remote

import com.google.gson.annotations.SerializedName

data class PredictionRequestDto(
    @SerializedName("years_as_customer")
    val yearsAsCustomer: Int,
    @SerializedName("purchase_frequency_days")
    val purchaseFrequencyDays: Int,
    @SerializedName("average_transaction_value")
    val averageTransactionValue: Float,
    @SerializedName("on_time_payment_ratio")
    val onTimePaymentRatio: Double,
    @SerializedName("past_credit_default")
    val pastCreditDefault: String,
)