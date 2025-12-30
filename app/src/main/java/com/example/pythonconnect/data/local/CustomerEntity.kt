package com.example.pythonconnect.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "customer_entries")
data class CustomerEntity(
    @PrimaryKey
    val customerId: String,
    val yearsAsCustomer: Int,
    val purchaseFrequencyDays: Int,
    val averageTransactionValue: Double,
    val onTimePaymentRatio: Double,
    val pastCreditDefault: String
)